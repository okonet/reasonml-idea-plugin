package com.reason.ide.hints;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.psi.PsiFile;
import com.reason.merlin.MerlinService;
import com.reason.merlin.types.MerlinPosition;
import com.reason.merlin.types.MerlinType;
import com.reason.psi.ReasonMLLet;

import java.util.Collection;
import java.util.List;

class MerlinQueryTypesTask implements Runnable {

    private final Collection<ReasonMLLet> m_letStatements;
    private final List<LogicalPosition> m_positions;
    private final PsiFile m_psiFile;

    MerlinQueryTypesTask(PsiFile psiFile, Collection<ReasonMLLet> letStatements, List<LogicalPosition> positions) {
        m_psiFile = psiFile;
        m_letStatements = letStatements;
        m_positions = positions;
    }

    @Override
    public void run() {
        MerlinService merlin = ApplicationManager.getApplication().getComponent(MerlinService.class);
        if (merlin == null) {
            return;
        }

        String filename = m_psiFile.getVirtualFile().getCanonicalPath();

        // Update merlin buffer
        String source = m_psiFile.getText();

        int i = 0;
        for (ReasonMLLet letStatement : m_letStatements) {
            LogicalPosition position = m_positions.get(i);
            if (position != null) {
                List<MerlinType> types = merlin.typeExpression(filename, source, new MerlinPosition(position));
                if (!types.isEmpty()) {
                    // System.out.println(letStatement.getLetName().getText() + ": " + types.stream().map(merlinType -> merlinType.type).reduce("", (s, s2) -> s + s2.replaceAll("\n", "").replaceAll("\\s+", "") + ", "));
                    // Display only the first one, might be wrong !?
                    letStatement.setInferredType(types.get(0).type.replaceAll("\n", "").replaceAll("\\s+", " "));
                }
            }
            i++;
        }
    }
}
