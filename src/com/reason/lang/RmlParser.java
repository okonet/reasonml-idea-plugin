package com.reason.lang;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static com.reason.lang.RmlTypes.*;

public class RmlParser implements PsiParser, LightPsiParser {

    private static final String ERR_SEMI_EXPECTED = "';' expected";
    private static final String ERR_RBRACE_EXPECTED = "'}' expected";
    private static final String ERR_EQ_EXPECTED = "'=' expected";
    private static final String ERR_ARROW_EXPECTED = "'=>' expected";
    private static final String ERR_COLON_EXPECTED = "':' expected";
    private static final String ERR_NAME_LIDENT = "Name must start with a lower case";
    private static final String ERR_NAME_UPPERCASE = "Name must start with an uppercase";

    @NotNull
    public ASTNode parse(@NotNull IElementType elementType, @NotNull PsiBuilder builder) {
        parseLight(elementType, builder);
        return builder.getTreeBuilt();
    }

    public void parseLight(IElementType elementType, PsiBuilder builder) {
        boolean r;
        //b.setDebugMode(true);
        builder = adapt_builder_(elementType, builder, this, null);
        Marker m = enter_section_(builder, 0, _COLLAPSE_, null);
        r = reasonFile(builder);
        exit_section_(builder, 0, m, elementType, r, true, TRUE_CONDITION);
    }

    private static boolean reasonFile(PsiBuilder builder) {
        if (!recursion_guard_(builder, 1, "reasonFile")) {
            return false;
        }

        int c = current_position_(builder);
        while (true) {
            IElementType tokenType = builder.getTokenType();
            if (tokenType == null) {
                break;
            }

            if (tokenType == OPEN) {
                openExpression(builder, 1);
            } else if (tokenType == INCLUDE) {
                includeExpression(builder, 1);
            } else if (tokenType == TYPE) {
                typeExpression(builder, 1);
            } else if (tokenType == MODULE) {
                moduleExpression(builder, 1);
            } else if (tokenType == EXTERNAL) {
                externalExpression(builder, 1);
            } else if (tokenType == LET) {
                letExpression(builder, 1);
            } else {
                builder.advanceLexer();
            }

            if (!empty_element_parsed_guard_(builder, "reasonFile", c)) {
                break;
            }

            c = builder.rawTokenIndex();
        }
        return true;
    }

    // **********
    // OPEN EXCLAMATION_MARK? module_path SEMI
    // **********
    private static void openExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "openExpression")) {
            return;
        }

        IElementType nextTokenType = builder.lookAhead(1);
        if (nextTokenType == EXCLAMATION_MARK) {
            builder.advanceLexer();
        }

        // Continue until a ';' or another toplevel expression is found
        Marker moduleMarker = enter_section_(builder);
        IElementType tokenType = advance(builder);
        if (tokenType != SEMI) {
            modulePath(builder, recLevel + 1);
        }

        endExpression(builder);
        exit_section_(builder, moduleMarker, OPEN_EXPRESSION, true);

    }

    // **********
    // TYPE type_name any* EQ (scoped_expression | expr) ;
    // **********
    private static void typeExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "type expression")) {
            return;
        }

        // enter type
        Marker exprMarker = enter_section_(builder);

        // type name
        IElementType tokenType = advance(builder);
        if (tokenType != SEMI) {
            Marker nameMarker = enter_section_(builder);
            Marker errorMarker = null;
            boolean isNameCorrect = tokenType == LIDENT;

            if (!isNameCorrect) {
                errorMarker = builder.mark();
            }

            builder.advanceLexer();

            if (!isNameCorrect) {
                errorMarker.error("Type name must start with a lower case");
            }

            exit_section_(builder, nameMarker, TYPE_CONSTR_NAME, true);
        }

        // anything until EQ or SEMI
        tokenType = builder.getTokenType();
        if (tokenType != EQ && tokenType != SEMI) {
            advanceUntil(builder, recLevel++, EQ);
        }

        tokenType = builder.getTokenType();
        if (tokenType != SEMI) {
            // =
            if (tokenType != EQ) {
                fail(builder, ERR_EQ_EXPECTED);
            } else {
                builder.advanceLexer();
            }

            tokenType = builder.getTokenType();
            if (tokenType == LBRACE) {
                // scoped body, anything inside braces
                scopedExpression(builder, recLevel + 1);
            } else {
                // anything but semi or start expression
                Marker marker = enter_section_(builder);

                while (true) {
                    builder.advanceLexer();
                    tokenType = builder.getTokenType();
                    if (isStartExpression(tokenType)) {
                        break;
                    }
                }

                exit_section_(builder, marker, SCOPED_EXPR, true);
            }
        }

        // end of type
        endExpression(builder);
        exit_section_(builder, exprMarker, TYPE_EXPRESSION, true);
    }

    // **********
    // INCLUDE module_path (scoped_expression)? SEMI
    // **********
    private static void includeExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "include expression")) {
            return;
        }

        // enter
        Marker exprMarker = enter_section_(builder);
        IElementType tokenType = advance(builder);
        if (tokenType != SEMI) {
            // module path
            modulePath(builder, recLevel + 1);
            tokenType = builder.getTokenType();
            if (tokenType == LBRACE) {
                scopedExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            }
            if (tokenType != SEMI) {
                fail(builder, ERR_SEMI_EXPECTED);
            }
        }

        endExpression(builder);
        exit_section_(builder, exprMarker, INCLUDE_EXPRESSION, true);
    }

    // **********
    // MODULE TYPE? module_name | SEMI
    //                          | (COLON module_type)? EQ                          (module_alias | scoped_expression) SEMI
    //                          | (LPAREN any RPAREN)+ (COLON module_type)? ARROW
    // **********
    private static void moduleExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "module expression")) {
            return;
        }

        // enter module
        Marker moduleMarker = enter_section_(builder);
        IElementType tokenType = advance(builder);
        if (tokenType != SEMI) {
            // might be a module definition only
            if (tokenType == TYPE) {
                builder.advanceLexer();
                tokenType = builder.getTokenType();
            }

            // module name
            boolean isNameIncorrect = tokenType != UIDENT;
            Marker errorMarker = null;

            Marker moduleNameMarker = enter_section_(builder);

            if (isNameIncorrect) {
                errorMarker = builder.mark();
            }

            builder.advanceLexer();

            if (isNameIncorrect) {
                errorMarker.error("Module name must start with upper case");
            }

            exit_section_(builder, moduleNameMarker, MODULE_NAME, true);

            tokenType = builder.getTokenType();
            if (tokenType != SEMI) {
                if (tokenType == LPAREN) {
                    // module constructor (function)
                    advanceUntil(builder, recLevel + 1, ARROW);

                    tokenType = builder.getTokenType();
                    if (tokenType != ARROW) {
                        fail(builder, ERR_ARROW_EXPECTED);
                    } else {
                        // module definition
                        builder.advanceLexer();

                        tokenType = builder.getTokenType();
                        if (tokenType == LBRACE) {
                            // scoped body, anything inside braces
                            scopedExpression(builder, recLevel + 1);
                        } else if (tokenType != SEMI) {
                            // module alias
                            modulePath(builder, recLevel + 1);
                        }
                    }
                } else if (tokenType == EQ || tokenType == COLON) {
                    if (tokenType == COLON) {
                        // module type
                        advanceUntil(builder, recLevel + 1, EQ);
                        tokenType = builder.getTokenType();
                    }

                    if (tokenType == EQ) {
                        // module definition
                        builder.advanceLexer();

                        tokenType = builder.getTokenType();
                        if (tokenType == LBRACE) {
                            // scoped body, anything inside braces
                            scopedExpression(builder, recLevel + 1);
                        } else if (tokenType != SEMI) {
                            // module alias
                            modulePath(builder, recLevel + 1);
                        }
                    }
                } else {
                    fail(builder, ERR_EQ_EXPECTED);
                }
            }
        }

        endExpression(builder);
        exit_section_(builder, moduleMarker, MODULE_EXPRESSION, true);
    }

    // ***** UIDENT (DOT UIDENT|scoped_expression)* ( (.*) )::constr
    private static void modulePath(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "module path")) {
            return;
        }

        Marker marker = enter_section_(builder);

        // First element must be a module name
        boolean incorrectName = builder.getTokenType() != UIDENT;
        Marker nameMarker = enter_section_(builder);
        builder.advanceLexer();
        if (incorrectName) {
            nameMarker.error(ERR_NAME_UPPERCASE);
        } else {
            exit_section_(builder, nameMarker, MODULE_NAME, true);

            // Then we can have other modules with dot notation
            while (true) {
                nameMarker = enter_section_(builder);
                IElementType tokenType = builder.getTokenType();

                if (tokenType == LPAREN) {
                    nameMarker.drop();
                    // Anything until we get to closing paren or semi
                    parenExpression(builder, recLevel + 1);
                    continue;
                } else if (tokenType == LBRACE) {
                    nameMarker.drop();
                    // scoped body, anything inside braces
                    scopedExpression(builder, recLevel + 1);
                }


                // a semi or scope is found, stop module path exploration
                if (tokenType == SEMI || tokenType == LBRACE) {
                    nameMarker.drop();
                    break;
                }

                if (tokenType == DOT) {
                    nameMarker.drop();
                    builder.advanceLexer();
                    continue;
                }

                if (tokenType != UIDENT) {
                    builder.advanceLexer();
                    nameMarker.error(ERR_NAME_UPPERCASE);
                    break;
                }

                builder.advanceLexer();
                exit_section_(builder, nameMarker, MODULE_NAME, true);
            }
        }

        exit_section_(builder, marker, MODULE_PATH, true);
    }

    // **********
    // EXTERNAL external_name COLON expression* SEMI
    private static void externalExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "external expression")) {
            return;
        }

        // enter external
        Marker exprMarker = enter_section_(builder);

        // name
        IElementType tokenType = advance(builder);
        if (tokenType != SEMI) {
            Marker nameMarker = enter_section_(builder);
            Marker errorMarker = null;
            boolean isNameCorrect = tokenType == LIDENT;

            if (!isNameCorrect) {
                errorMarker = builder.mark();
            }

            builder.advanceLexer();

            if (!isNameCorrect) {
                errorMarker.error("External name must start with a lower case");
            }

            exit_section_(builder, nameMarker, VALUE_NAME, true);
        }

        tokenType = builder.getTokenType();
        // :
        if (tokenType == COLON) {
            builder.advanceLexer();
        } else {
            fail(builder, ERR_COLON_EXPECTED);
        }

        tokenType = builder.getTokenType();
        if (tokenType != SEMI) {
            // anything but semi
            while (true) {
                builder.advanceLexer();
                tokenType = builder.getTokenType();
                if (tokenType == null || tokenType == SEMI) {
                    break;
                }
            }
        }

        // end of external
        endExpression(builder);
        exit_section_(builder, exprMarker, EXTERNAL_EXPRESSION, true);
    }

    // **********
    // LET REC? MODULE? (destructure|value_name) expression* (EQ (scoped_)expression | ARROW scoped_expression) SEMI
    // LET REC? MODULE? value_name COLON expression+ SEMI
    // **********
    private static void letExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "let expression")) {
            return;
        }

        boolean isModuleAlias = false;

        // enter LET
        Marker exprMarker = enter_section_(builder);

        // Might be recursive
        IElementType tokenType = advance(builder);
        if (tokenType == REC) {
            builder.advanceLexer();
        }

        // might be a module alias
        tokenType = builder.getTokenType();
        if (tokenType == MODULE) {
            isModuleAlias = true;
            builder.advanceLexer();
        }

        tokenType = builder.getTokenType();
        if (tokenType != SEMI) {
            if (tokenType == UNIT) {
                builder.advanceLexer();
            } else if (tokenType == LPAREN) {
                // we are dealing with destructuring
                advanceUntil(builder, recLevel + 1, RPAREN);
                builder.advanceLexer();
            } else if (tokenType == LBRACE) {
                // we are dealing with destructuring
                advanceUntil(builder, recLevel + 1, RBRACE);
                builder.advanceLexer();
            } else {
                // value name
                Marker nameMarker = enter_section_(builder);
                builder.advanceLexer();
                exit_section_(builder, nameMarker, VALUE_NAME, true);
            }
        }

        tokenType = builder.getTokenType();

        // COLON means we are dealing with a definition, = or => is not needed, we can end with ;
        boolean hasTypeDefinition = tokenType == COLON;

        // Anything before EQ|ARROW
        // anything but semi or start expression
        WhitespaceNotifier whitespace = new WhitespaceNotifier();
        builder.setWhitespaceSkippedCallback(whitespace::notify);

        while (true) {
            tokenType = builder.getTokenType();
            if ((whitespace.isSkipped() && (tokenType == EQ || tokenType == ARROW)) || isStartExpression(tokenType)) {
                break;
            } else {
                whitespace.setSkipped();
            }
            builder.advanceLexer();
        }

        builder.setWhitespaceSkippedCallback(null);

        tokenType = builder.getTokenType();
        if (EQ != tokenType && ARROW != tokenType) {
            if (!hasTypeDefinition) {
                fail(builder, "'=' or '=>' expected");
            }
        } else {
            boolean isFunction = ARROW == tokenType;

            builder.advanceLexer();
            Marker funMarker = enter_section_(builder);

            tokenType = builder.getTokenType();
            if (LBRACE == tokenType) {
                scopedExpression(builder, recLevel + 1);
            } else if (IF == tokenType) {
                ifExpression(builder, recLevel + 1, true);
            } else {
                advanceUntilNextStart(builder, recLevel + 1);
            }

            exit_section_(builder, funMarker, isFunction ? FUN_BODY : LET_BINDING, true);
        }

        // end of LET
        endExpression(builder);
        exit_section_(builder, exprMarker, LET_EXPRESSION, true);

    }

    private static void ifExpression(PsiBuilder builder, int recLevel, boolean containsIf) {
        if (!recursion_guard_(builder, recLevel, "if expression")) {
            return;
        }

        IElementType tokenType = builder.getTokenType();

        if (containsIf) {
            tokenType = advance(builder);
            if (tokenType != LPAREN) {
                fail(builder, "'(' expected");
                return;
            }

            parenExpression(builder, recLevel + 1);
            tokenType = builder.getTokenType();
        }

        if (tokenType == LBRACE) {
            scopedExpression(builder, recLevel + 1);
            tokenType = builder.getTokenType();
        }

        if (tokenType == ELSE) {
            tokenType = advance(builder);
            ifExpression(builder, recLevel + 1, tokenType == IF);
        }
    }

    // **********
    // Pattern: LBRACE expression* RBRACE
    // **********
    private static void scopedExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "scoped expression")) {
            return;
        }

        // Mark the start of the scoped expression
        Marker marker = enter_section_(builder);
        builder.advanceLexer();

        while (true) {
            IElementType tokenType = builder.getTokenType();
            if (tokenType == null || tokenType == RBRACE) {
                break;
            }

            // start expressions ?
            if (tokenType == OPEN) {
                openExpression(builder, recLevel + 1);
            } else if (tokenType == INCLUDE) {
                includeExpression(builder, recLevel + 1);
            } else if (tokenType == TYPE) {
                typeExpression(builder, recLevel + 1);
            } else if (tokenType == MODULE) {
                moduleExpression(builder, recLevel + 1);
            } else if (tokenType == EXTERNAL) {
                externalExpression(builder, recLevel + 1);
            } else if (tokenType == LET) {
                letExpression(builder, recLevel + 1);
            } else if (tokenType == LBRACE) {
                scopedExpression(builder, recLevel + 1);
            } else if (tokenType == LPAREN) {
                parenExpression(builder, recLevel + 1);
            } else {
                builder.advanceLexer();
            }
        }

        IElementType tokenType = builder.getTokenType();
        if (tokenType != RBRACE) {
            fail(builder, ERR_RBRACE_EXPECTED);
        } else {
            builder.advanceLexer();
        }

        exit_section_(builder, marker, SCOPED_EXPR, true);
    }

    private static void advanceUntilNextStart(PsiBuilder builder, int recLevel) {
        IElementType tokenType;
        while (true) {
            builder.advanceLexer();
            tokenType = builder.getTokenType();
            if (LBRACE == tokenType) {
                scopedExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            } else if (LPAREN == tokenType) {
                parenExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            }
            if (isStartExpression(tokenType) || tokenType == RBRACE) {
                break;
            }
        }
    }

    private static void parenExpression(PsiBuilder builder, int recLevel) {
        if (!recursion_guard_(builder, recLevel, "skip paren")) {
            return;
        }

        IElementType tokenType;
        while (true) {
            builder.advanceLexer();
            tokenType = builder.getTokenType();

            // If a new scope is found, recursively process it
            if (LBRACE == tokenType) {
                scopedExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            } else if (LPAREN == tokenType) {
                parenExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            }

            // Advance until a right paren is found, or nothing else is found
            if (RPAREN == tokenType || tokenType == null) {
                builder.advanceLexer();
                return;
            }
        }
    }

    private static IElementType advance(PsiBuilder builder) {
        builder.advanceLexer();
        return builder.getTokenType();
    }

    private static void advanceUntil(PsiBuilder builder, int recLevel, IElementType nextTokenType) {
        if (!recursion_guard_(builder, recLevel, "advance until")) {
            return;
        }

        IElementType tokenType;
        while (true) {
            builder.advanceLexer();
            tokenType = builder.getTokenType();
            if (LBRACE == tokenType) {
                scopedExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            } else if (LPAREN == tokenType) {
                parenExpression(builder, recLevel + 1);
                tokenType = builder.getTokenType();
            }

            if (tokenType == null || tokenType == SEMI || tokenType == nextTokenType) {
                break;
            }
        }
    }

    private static boolean isStartExpression(IElementType tokenType) {
        return tokenType == null || tokenType == SEMI || tokenType == MODULE || tokenType == OPEN || tokenType == TYPE || tokenType == LET;
    }

    private static void endExpression(PsiBuilder builder) {
        // Last expression in the file can omit semi
        if (builder.eof()) {
            return;
        }

        IElementType tokenType = builder.getTokenType();
        if (tokenType == SEMI) {
            builder.advanceLexer();
        } else if (tokenType != RBRACE) { // Last expression in a scope can also omit semi
            fail(builder, ERR_SEMI_EXPECTED);
        }
    }

    private static void fail(PsiBuilder builder, String message) {
        builder.mark().error(message);
    }

    private static class WhitespaceNotifier {
        private boolean skipped = true;

        @SuppressWarnings("unused")
        void notify(IElementType type, int start, int end) {
            this.skipped = true;
        }

        boolean isSkipped() {
            return this.skipped;
        }

        void setSkipped() {
            this.skipped = false;
        }
    }
}
