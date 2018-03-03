package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;

public class AddFieldDialog extends DialogWrapper {

    private final AddFieldPanel addFieldPanel = new AddFieldPanel();

    public AddFieldDialog(Project project) {
        super(project);
        setTitle("Add Field");

        init();
    }

    public void setField(GenerateDtoTableRow field) {
        addFieldPanel.setName(field.getFieldName());
        addFieldPanel.setType(field.getType());
    }

    public GenerateDtoTableRow getField() {
        return new GenerateDtoTableRow(addFieldPanel.getName(), addFieldPanel.getType());
    }

    @Override
    public ValidationInfo doValidate() {
        return addFieldPanel.doValidate();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return addFieldPanel;
    }

}
