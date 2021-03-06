package com.reason.ide.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.reason.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.reason.lang.RmlTypes.*;

public class RmlFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        PsiTreeUtil.processElements(root, element -> {
            IElementType elementType = element.getNode().getElementType();
            if (COMMENT.equals(elementType)) {
                descriptors.add(fold(element));
            } else if (TYPE_EXPRESSION.equals(elementType)) {
                foldType(descriptors, (ReasonMLType) element);
            } else if (LET_EXPRESSION.equals(elementType)) {
                foldLet(descriptors, (ReasonMLLet) element);
            } else if (MODULE_EXPRESSION.equals(elementType)) {
                foldModule(descriptors, (ReasonMLModule) element);
            }
            return true;
        });

        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    private void foldType(List<FoldingDescriptor> descriptors, ReasonMLType typeExpression) {
        FoldingDescriptor fold = fold(typeExpression.getScopedExpression());
        if (fold != null) {
            descriptors.add(fold);
        }
    }

    private void foldLet(List<FoldingDescriptor> descriptors, ReasonMLLet letExpression) {
        ReasonMLFunBody functionBody = letExpression.getFunctionBody();
        if (functionBody != null) {
            FoldingDescriptor fold = fold(functionBody);
            if (fold != null) {
                descriptors.add(fold);
            }
        } else {
            ReasonMLLetBinding letBinding = letExpression.getLetBinding();
            FoldingDescriptor fold = fold(letBinding);
            if (fold != null) {
                descriptors.add(fold);
            }
        }
    }

    private void foldModule(List<FoldingDescriptor> descriptors, ReasonMLModule module) {
        FoldingDescriptor fold = fold(module.getModuleBody());
        if (fold != null) {
            descriptors.add(fold);
        }
        // PsiElement lBrace = RmlPsiTreeUtil.getNextSiblingOfType(element, LBRACE);
        // PsiElement rBrace = RmlPsiTreeUtil.getNextSiblingOfType(lBrace, RBRACE);
        // if (lBrace != null && rBrace != null) {
        //     FoldingDescriptor fold = foldBetween(element, lBrace, rBrace, 5);
        //     if (fold != null)
        //         descriptors.add(fold);
        // }
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getElementType().equals(COMMENT)) {
            return "/*...*/";
        }
        return "{...}";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

    // @Nullable
    // private FoldingDescriptor foldBetween(PsiElement element, PsiElement left, PsiElement right, int minWidth) {
    //     if (right.getTextOffset() - left.getTextOffset() < minWidth) {
    //         return null;
    //     }
    //     TextRange range = new TextRange(left.getTextOffset() + 1, right.getTextOffset());
    //     return new FoldingDescriptor(element, range);
    // }

    @Nullable
    private FoldingDescriptor fold(@Nullable PsiElement element) {
        if (element == null) {
            return null;
        }
        TextRange textRange = element.getTextRange();
        return textRange.getLength() > 5 ? new FoldingDescriptor(element, textRange) : null;
    }
}
