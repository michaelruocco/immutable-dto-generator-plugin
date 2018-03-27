package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class AddFieldPanel extends JPanel {

    private final JTextField nameField;
    private final TypeField typeField;

    AddFieldPanel() {
        this(new FieldNameField(), new TypeField());
    }

    AddFieldPanel(JTextField nameField, TypeField typeField) {
        this.nameField = nameField;
        this.typeField = typeField;

        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
        builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        builder.appendColumn("right:pref");
        builder.appendColumn("5dlu");
        builder.appendColumn("fill:max(pref; 200px)");
        builder.appendColumn("5dlu");

        builder.append("Name", nameField);
        builder.append("Type", typeField);

        add(builder.getPanel(), BorderLayout.CENTER);
    }

    public void setField(GenerateDtoField field) {
        setFieldName(field.getFieldName());
        setFieldType(field.getFieldType());
    }

    public GenerateDtoField getField() {
        return new GenerateDtoField(getFieldName(), getFieldType());
    }

    public ValidationInfo doValidate() {
        return typeField.doValidate();
    }

    private String getFieldName() {
        return nameField.getText();
    }

    private void setFieldName(String name) {
        this.nameField.setText(name);
    }

    private String getFieldType() {
        return typeField.getType();
    }

    private void setFieldType(String type) {
        this.typeField.setType(type);
    }

}
