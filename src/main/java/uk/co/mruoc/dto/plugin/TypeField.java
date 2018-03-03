package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.diagnostic.Logger;

import javax.swing.JTextField;

class TypeField extends JTextField {

    private static final Logger LOGGER = Logger.getInstance(TypeField.class);
    private static final String DEFAULT_TYPE = "java.lang.String";

    TypeField() {
        setText(DEFAULT_TYPE);
    }

    public void setType(Class<?> type) {
        setText(type.getTypeName());
    }

    public Class<?> getType() {
        try {
            return Class.forName(getText());
        } catch (ClassNotFoundException e) {
            String message = buildErrorMessage();
            throw new InvalidTypeException(message, e);
        }
    }

    public ValidationInfo doValidate() {
        if (hasValidType())
            return null;

        String message = buildErrorMessage();
        return new ValidationInfo(message, this);
    }

    private boolean hasValidType() {
        String text = getText();
        try {
            Class.forName(text);
            return true;
        } catch (ClassNotFoundException e) {
            LOGGER.debug(text, e);
            return false;
        }
    }

    private String buildErrorMessage() {
        return "Invalid type " + getText();
    }

}
