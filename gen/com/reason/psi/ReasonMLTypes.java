// This is a generated file. Not intended for manual editing.
package com.reason.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.reason.psi.impl.*;

public interface ReasonMLTypes {

  IElementType ARGUMENT = new ReasonMLElementType("ARGUMENT");
  IElementType BS_DIRECTIVE = new ReasonMLElementType("BS_DIRECTIVE");
  IElementType CONSTANT = new ReasonMLElementType("CONSTANT");
  IElementType END_TAG = new ReasonMLElementType("END_TAG");
  IElementType EXPR = new ReasonMLElementType("EXPR");
  IElementType EXPR_STATEMENT = new ReasonMLElementType("EXPR_STATEMENT");
  IElementType EXTERNAL_ALIAS = new ReasonMLElementType("EXTERNAL_ALIAS");
  IElementType EXTERNAL_STATEMENT = new ReasonMLElementType("EXTERNAL_STATEMENT");
  IElementType FIELD = new ReasonMLElementType("FIELD");
  IElementType FIELD_DECL = new ReasonMLElementType("FIELD_DECL");
  IElementType FIELD_NAME = new ReasonMLElementType("FIELD_NAME");
  IElementType FIELD_TYPE_DECL = new ReasonMLElementType("FIELD_TYPE_DECL");
  IElementType FUN_DECL = new ReasonMLElementType("FUN_DECL");
  IElementType INCLUDE_STATEMENT = new ReasonMLElementType("INCLUDE_STATEMENT");
  IElementType JSX = new ReasonMLElementType("JSX");
  IElementType JSX_CONTENT = new ReasonMLElementType("JSX_CONTENT");
  IElementType LET_BINDING = new ReasonMLElementType("LET_BINDING");
  IElementType LET_BINDING_BODY = new ReasonMLElementType("LET_BINDING_BODY");
  IElementType LET_STATEMENT = new ReasonMLElementType("LET_STATEMENT");
  IElementType MODULE_BODY = new ReasonMLElementType("MODULE_BODY");
  IElementType MODULE_EXPR = new ReasonMLElementType("MODULE_EXPR");
  IElementType MODULE_NAME = new ReasonMLElementType("MODULE_NAME");
  IElementType MODULE_PATH = new ReasonMLElementType("MODULE_PATH");
  IElementType MODULE_STATEMENT = new ReasonMLElementType("MODULE_STATEMENT");
  IElementType OPEN_STATEMENT = new ReasonMLElementType("OPEN_STATEMENT");
  IElementType PARAMETER = new ReasonMLElementType("PARAMETER");
  IElementType PATTERN_EXPR = new ReasonMLElementType("PATTERN_EXPR");
  IElementType POLY_TYPE_EXPR = new ReasonMLElementType("POLY_TYPE_EXPR");
  IElementType RECORD_DECL = new ReasonMLElementType("RECORD_DECL");
  IElementType RECORD_TYPE_DECL = new ReasonMLElementType("RECORD_TYPE_DECL");
  IElementType START_TAG = new ReasonMLElementType("START_TAG");
  IElementType TAG_NAME = new ReasonMLElementType("TAG_NAME");
  IElementType TAG_PROPERTY = new ReasonMLElementType("TAG_PROPERTY");
  IElementType TUPLE_TYPE_DECL = new ReasonMLElementType("TUPLE_TYPE_DECL");
  IElementType TUPLE_TYPE_FIELD_DECL = new ReasonMLElementType("TUPLE_TYPE_FIELD_DECL");
  IElementType TYPE_CONSTR = new ReasonMLElementType("TYPE_CONSTR");
  IElementType TYPE_CONSTR_NAME = new ReasonMLElementType("TYPE_CONSTR_NAME");
  IElementType TYPE_EXPR = new ReasonMLElementType("TYPE_EXPR");
  IElementType TYPE_INFORMATION = new ReasonMLElementType("TYPE_INFORMATION");
  IElementType TYPE_STATEMENT = new ReasonMLElementType("TYPE_STATEMENT");
  IElementType VALUE_EXPR = new ReasonMLElementType("VALUE_EXPR");
  IElementType VALUE_NAME = new ReasonMLElementType("VALUE_NAME");
  IElementType VALUE_PATH = new ReasonMLElementType("VALUE_PATH");

  IElementType ARROW = new ReasonMLTokenType("ARROW");
  IElementType AUTO_CLOSE_TAG = new ReasonMLTokenType("AUTO_CLOSE_TAG");
  IElementType BBS = new ReasonMLTokenType("BBS");
  IElementType BS = new ReasonMLTokenType("BS");
  IElementType CARRET = new ReasonMLTokenType("CARRET");
  IElementType CLOSE_TAG = new ReasonMLTokenType("CLOSE_TAG");
  IElementType COLON = new ReasonMLTokenType("COLON");
  IElementType COMMA = new ReasonMLTokenType("COMMA");
  IElementType COMMENT = new ReasonMLTokenType("COMMENT");
  IElementType DOT = new ReasonMLTokenType("DOT");
  IElementType EQUAL = new ReasonMLTokenType("EQUAL");
  IElementType EXTERNAL = new ReasonMLTokenType("EXTERNAL");
  IElementType FALSE = new ReasonMLTokenType("FALSE");
  IElementType FLOAT = new ReasonMLTokenType("FLOAT");
  IElementType FUN = new ReasonMLTokenType("FUN");
  IElementType GT = new ReasonMLTokenType("GT");
  IElementType INCLUDE = new ReasonMLTokenType("INCLUDE");
  IElementType INT = new ReasonMLTokenType("INT");
  IElementType LBRACE = new ReasonMLTokenType("LBRACE");
  IElementType LBRACKET = new ReasonMLTokenType("LBRACKET");
  IElementType LET = new ReasonMLTokenType("LET");
  IElementType LIDENT = new ReasonMLTokenType("LIDENT");
  IElementType LPAREN = new ReasonMLTokenType("LPAREN");
  IElementType LT = new ReasonMLTokenType("LT");
  IElementType MODULE = new ReasonMLTokenType("MODULE");
  IElementType NONE = new ReasonMLTokenType("NONE");
  IElementType OPEN = new ReasonMLTokenType("OPEN");
  IElementType OPTION = new ReasonMLTokenType("OPTION");
  IElementType PLUS = new ReasonMLTokenType("PLUS");
  IElementType QUESTION_MARK = new ReasonMLTokenType("QUESTION_MARK");
  IElementType RBRACE = new ReasonMLTokenType("RBRACE");
  IElementType RBRACKET = new ReasonMLTokenType("RBRACKET");
  IElementType RPAREN = new ReasonMLTokenType("RPAREN");
  IElementType SEMI = new ReasonMLTokenType("SEMI");
  IElementType SHARP = new ReasonMLTokenType("SHARP");
  IElementType SHORTCUT = new ReasonMLTokenType("SHORTCUT");
  IElementType SOME = new ReasonMLTokenType("SOME");
  IElementType STRING = new ReasonMLTokenType("STRING");
  IElementType TRUE = new ReasonMLTokenType("TRUE");
  IElementType TYPE = new ReasonMLTokenType("TYPE");
  IElementType UIDENT = new ReasonMLTokenType("UIDENT");
  IElementType UNIT = new ReasonMLTokenType("UNIT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGUMENT) {
        return new ReasonMLArgumentImpl(node);
      }
      else if (type == BS_DIRECTIVE) {
        return new ReasonMLBsDirectiveImpl(node);
      }
      else if (type == CONSTANT) {
        return new ReasonMLConstantImpl(node);
      }
      else if (type == END_TAG) {
        return new ReasonMLEndTagImpl(node);
      }
      else if (type == EXPR) {
        return new ReasonMLExprImpl(node);
      }
      else if (type == EXPR_STATEMENT) {
        return new ReasonMLExprStatementImpl(node);
      }
      else if (type == EXTERNAL_ALIAS) {
        return new ReasonMLExternalAliasImpl(node);
      }
      else if (type == EXTERNAL_STATEMENT) {
        return new ReasonMLExternalStatementImpl(node);
      }
      else if (type == FIELD) {
        return new ReasonMLFieldImpl(node);
      }
      else if (type == FIELD_DECL) {
        return new ReasonMLFieldDeclImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new ReasonMLFieldNameImpl(node);
      }
      else if (type == FIELD_TYPE_DECL) {
        return new ReasonMLFieldTypeDeclImpl(node);
      }
      else if (type == FUN_DECL) {
        return new ReasonMLFunDeclImpl(node);
      }
      else if (type == INCLUDE_STATEMENT) {
        return new ReasonMLIncludeStatementImpl(node);
      }
      else if (type == JSX) {
        return new ReasonMLJsxImpl(node);
      }
      else if (type == JSX_CONTENT) {
        return new ReasonMLJsxContentImpl(node);
      }
      else if (type == LET_BINDING) {
        return new ReasonMLLetBindingImpl(node);
      }
      else if (type == LET_BINDING_BODY) {
        return new ReasonMLLetBindingBodyImpl(node);
      }
      else if (type == LET_STATEMENT) {
        return new ReasonMLLetStatementImpl(node);
      }
      else if (type == MODULE_BODY) {
        return new ReasonMLModuleBodyImpl(node);
      }
      else if (type == MODULE_EXPR) {
        return new ReasonMLModuleExprImpl(node);
      }
      else if (type == MODULE_NAME) {
        return new ReasonMLModuleNameImpl(node);
      }
      else if (type == MODULE_PATH) {
        return new ReasonMLModulePathImpl(node);
      }
      else if (type == MODULE_STATEMENT) {
        return new ReasonMLModuleStatementImpl(node);
      }
      else if (type == OPEN_STATEMENT) {
        return new ReasonMLOpenStatementImpl(node);
      }
      else if (type == PARAMETER) {
        return new ReasonMLParameterImpl(node);
      }
      else if (type == PATTERN_EXPR) {
        return new ReasonMLPatternExprImpl(node);
      }
      else if (type == POLY_TYPE_EXPR) {
        return new ReasonMLPolyTypeExprImpl(node);
      }
      else if (type == RECORD_DECL) {
        return new ReasonMLRecordDeclImpl(node);
      }
      else if (type == RECORD_TYPE_DECL) {
        return new ReasonMLRecordTypeDeclImpl(node);
      }
      else if (type == START_TAG) {
        return new ReasonMLStartTagImpl(node);
      }
      else if (type == TAG_NAME) {
        return new ReasonMLTagNameImpl(node);
      }
      else if (type == TAG_PROPERTY) {
        return new ReasonMLTagPropertyImpl(node);
      }
      else if (type == TUPLE_TYPE_DECL) {
        return new ReasonMLTupleTypeDeclImpl(node);
      }
      else if (type == TUPLE_TYPE_FIELD_DECL) {
        return new ReasonMLTupleTypeFieldDeclImpl(node);
      }
      else if (type == TYPE_CONSTR) {
        return new ReasonMLTypeConstrImpl(node);
      }
      else if (type == TYPE_CONSTR_NAME) {
        return new ReasonMLTypeConstrNameImpl(node);
      }
      else if (type == TYPE_EXPR) {
        return new ReasonMLTypeExprImpl(node);
      }
      else if (type == TYPE_INFORMATION) {
        return new ReasonMLTypeInformationImpl(node);
      }
      else if (type == TYPE_STATEMENT) {
        return new ReasonMLTypeStatementImpl(node);
      }
      else if (type == VALUE_EXPR) {
        return new ReasonMLValueExprImpl(node);
      }
      else if (type == VALUE_NAME) {
        return new ReasonMLValueNameImpl(node);
      }
      else if (type == VALUE_PATH) {
        return new ReasonMLValuePathImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
