package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.diagnostic.Logger;
import com.squareup.javapoet.TypeName;
import uk.co.mruoc.code.StringToTypeNameConverter;

import javax.swing.JTextField;

class TypeField extends JTextField {

    private static final Logger LOGGER = Logger.getInstance(TypeField.class);
    private static final String DEFAULT_TYPE = "java.lang.String";

    TypeField() {
        setText(DEFAULT_TYPE);
    }

    public void setType(String type) {
        setText(type);
    }

    public String getType() {
        try {
            TypeName typeName = StringToTypeNameConverter.toTypeName(getText());
            return typeName.toString();
        } catch (IllegalArgumentException e) {
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
            StringToTypeNameConverter.toTypeName(text);
            return true;
        } catch (IllegalArgumentException e) {
            LOGGER.debug(text, e);
            return false;
        }
    }

    private String buildErrorMessage() {
        return "Invalid type " + getText();
    }

}
