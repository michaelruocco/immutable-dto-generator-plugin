package uk.co.mruoc.dto.plugin;

import javax.swing.JTextField;

class FieldNameField extends JTextField {

    private static final String DEFAULT_FIELD_NAME = "myField";

    FieldNameField() {
        setText(DEFAULT_FIELD_NAME);
    }

}
