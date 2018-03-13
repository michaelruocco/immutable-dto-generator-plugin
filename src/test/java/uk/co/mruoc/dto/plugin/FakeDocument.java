package uk.co.mruoc.dto.plugin;

import javax.swing.event.DocumentListener;
import javax.swing.text.PlainDocument;

public class FakeDocument extends PlainDocument {

    private DocumentListener listener;

    public DocumentListener getListener() {
        return listener;
    }

    @Override
    public void addDocumentListener(DocumentListener listener) {
        this.listener = listener;
    }

}
