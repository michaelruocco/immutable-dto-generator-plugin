package uk.co.mruoc.dto.plugin;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FakeDocumentListener implements DocumentListener {

    private boolean updated = false;

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insertUpdate");
        this.updated = true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("removeUpdate");
        this.updated = true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("changedUpdate");
        this.updated = true;
    }

    public boolean isUpdated() {
        return updated;
    }

}
