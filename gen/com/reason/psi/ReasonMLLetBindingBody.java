// This is a generated file. Not intended for manual editing.
package com.reason.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ReasonMLLetBindingBody extends PsiElement {

  @NotNull
  List<ReasonMLFunArg> getFunArgList();

  @Nullable
  ReasonMLFunBody getFunBody();

  @Nullable
  ReasonMLSeqExpr getSeqExpr();

}