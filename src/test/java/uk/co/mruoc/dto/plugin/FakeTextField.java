package uk.co.mruoc.dto.plugin;

import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

public class FakeTextField extends JTextField {

    private final FakeDocument document = new FakeDocument();

    public FakeTextField() {
        setDocument(document);
    }

    public DocumentListener getDocumentListener() {
        return document.getListener();
    }

}
