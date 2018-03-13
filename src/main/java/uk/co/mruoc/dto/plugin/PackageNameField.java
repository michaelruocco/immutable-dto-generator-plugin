package uk.co.mruoc.dto.plugin;

import javax.swing.JTextField;

class PackageNameField extends JTextField {

    private static final String DEFAULT_PACKAGE_NAME = "uk.co.temp";

    PackageNameField() {
        setText(DEFAULT_PACKAGE_NAME);
    }

}
