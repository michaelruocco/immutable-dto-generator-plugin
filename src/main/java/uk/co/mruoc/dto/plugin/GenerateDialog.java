package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import uk.co.mruoc.code.DefaultGenerationParams;
import uk.co.mruoc.code.GenerationParams;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.file.Path;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

public class GenerateDialog extends DialogWrapper implements DocumentListener, ItemListener, TableModelListener {

    private final JPanel panel;
    private final ClassNamesPanel classNamesPanel;
    private final FieldTablePanel fieldsPanel;

    GenerateDialog(Project project) {
        super(project);
        setTitle("Generate DTO");

        classNamesPanel = new ClassNamesPanel(project);
        fieldsPanel = new FieldTablePanel(project);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(classNamesPanel, NORTH);
        panel.add(fieldsPanel, CENTER);

        init();

        classNamesPanel.addDocumentListener(this);
        classNamesPanel.addItemListener(this);
        fieldsPanel.addTableModelListener(this);
        updateOkActionEnabled();
    }

    public GenerationParams getGenerationParams() {
        DefaultGenerationParams params = new DefaultGenerationParams();
        params.setPackageName(classNamesPanel.getPackageName());
        params.setDtoClassName(classNamesPanel.getClassName());
        for (GenerateDtoTableRow row : fieldsPanel.getData()) {
            params.addFieldDefinition(row.getFieldName(), row.getType());
        }
        return params;
    }

    public Path getSourcePath() {
        return classNamesPanel.getSourcePath();
    }

    public Path getTestSourcePath() {
        return classNamesPanel.getTestSourcePath();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        updateOkActionEnabled();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateOkActionEnabled();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateOkActionEnabled();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateOkActionEnabled();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        updateOkActionEnabled();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return panel;
    }

    private void updateOkActionEnabled() {
        setOKActionEnabled(isCompleted());
    }

    private boolean isCompleted() {
        return classNamesPanel.isCompleted() && fieldsPanel.hasAtLeastOneField();
    }

}
