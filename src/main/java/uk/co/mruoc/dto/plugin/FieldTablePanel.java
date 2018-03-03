package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.ui.AddEditRemovePanel;
import org.jetbrains.annotations.Nullable;

public class FieldTablePanel extends AddEditRemovePanel<GenerateDtoTableRow> {

    private final Project project;

    FieldTablePanel(Project project) {
        this(project, new GenerateDtoTableModel());
    }

    private FieldTablePanel(Project project, GenerateDtoTableModel tableModel) {
        super(tableModel, tableModel.getData(), "Fields");
        this.project = project;
    }

    @Nullable
    @Override
    protected GenerateDtoTableRow addItem() {
        AddFieldDialog dialog = new AddFieldDialog(project);
        return show(dialog);
    }

    @Override
    protected boolean removeItem(GenerateDtoTableRow row) {
        return true;
    }

    @Nullable
    @Override
    protected GenerateDtoTableRow editItem(GenerateDtoTableRow row) {
        AddFieldDialog dialog = new AddFieldDialog(project);
        dialog.setField(row);
        return show(dialog);
    }

    private GenerateDtoTableRow show(AddFieldDialog dialog) {
        boolean ok = dialog.showAndGet();
        if(ok) {
            //try {
                return dialog.getField();
            /*} catch (InvalidTypeException e) {
                DialogBuilder errorBuilder = new DialogBuilder(project);
                errorBuilder.setTitle("Invalid Type");
                errorBuilder.setErrorText("Cannot convert " + e.getMessage() + " to primitive type or class");
                errorBuilder.show();
                ok = dialog.showAndGet();
            }*/
        }
        return null;
    }

}
