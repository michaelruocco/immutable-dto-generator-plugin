package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.ui.AddEditRemovePanel;
import org.jetbrains.annotations.Nullable;

import javax.swing.event.TableModelListener;

public class FieldTablePanel extends AddEditRemovePanel<GenerateDtoField> {

    private final Project project;

    FieldTablePanel(Project project) {
        this(project, new GenerateDtoTableModel());
    }

    private FieldTablePanel(Project project, GenerateDtoTableModel tableModel) {
        super(tableModel, tableModel.getData(), "Fields");
        this.project = project;
    }

    public void addTableModelListener(TableModelListener listener) {
        getTable().getModel().addTableModelListener(listener);
    }

    public boolean hasAtLeastOneField() {
        return getData().size() > 0;
    }

    @Nullable
    @Override
    protected GenerateDtoField addItem() {
        AddFieldDialog dialog = new AddFieldDialog(project);
        return show(dialog);
    }

    @Override
    protected boolean removeItem(GenerateDtoField row) {
        return true;
    }

    @Nullable
    @Override
    protected GenerateDtoField editItem(GenerateDtoField row) {
        AddFieldDialog dialog = new AddFieldDialog(project);
        dialog.setField(row);
        return show(dialog);
    }

    private GenerateDtoField show(AddFieldDialog dialog) {
        boolean ok = dialog.showAndGet();
        if (ok) {
            return dialog.getField();
        }
        return null;
    }

}
