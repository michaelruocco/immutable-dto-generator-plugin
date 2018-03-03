package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ValidationInfo;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class AddFieldPanel extends JPanel {

    private final JTextField nameField = new FieldNameField();
    private final TypeField typeField = new TypeField();

    AddFieldPanel() {
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

    public void setName(String name) {
        this.nameField.setText(name);
    }

    public void setType(Class<?> type) {
        this.typeField.setType(type);
    }

    public String getName() {
        return nameField.getText();
    }

    public Class<?> getType() {
        return typeField.getType();
    }

    public ValidationInfo doValidate() {
        return typeField.doValidate();
    }

}
