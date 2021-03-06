package com.reason.ide;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.util.messages.MessageBusConnection;
import com.reason.ide.hints.RmlDocumentListener;

public class RmlProjectTracker extends AbstractProjectComponent {

    private RmlDocumentListener m_documentListener;
    private MessageBusConnection m_messageBusConnection;

    protected RmlProjectTracker(Project project) {
        super(project);
    }

    @Override
    public void projectOpened() {
        m_documentListener = new RmlDocumentListener(myProject);
        EditorFactory.getInstance().getEventMulticaster().addDocumentListener(m_documentListener);

        m_messageBusConnection = myProject.getMessageBus().connect();
        m_messageBusConnection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new RmlFileEditorListener(myProject));
    }

    @Override
    public void projectClosed() {
        EditorFactory.getInstance().getEventMulticaster().removeDocumentListener(m_documentListener);
        m_documentListener.projectClosed();
        m_messageBusConnection.disconnect();
    }
}
