package uk.co.mruoc.dto.plugin;

import javax.swing.JTextField;

class ClassNameField extends JTextField {

    private static final String DEFAULT_CLASS_NAME = "MyClass";

    ClassNameField() {
        setText(DEFAULT_CLASS_NAME);
    }

}
