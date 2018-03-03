package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.AddEditRemovePanel;
import org.jetbrains.annotations.Nullable;
import uk.co.mruoc.code.DefaultGenerationParams;
import uk.co.mruoc.code.GenerationParams;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

public class GenerateDialog extends DialogWrapper {

    private final JPanel panel;
    private final ClassNamesPanel classNamesPanel;
    private final AddEditRemovePanel<GenerateDtoTableRow> tablePanel;

    GenerateDialog(Project project) {
        super(project);
        setTitle("Generate DTO");

        classNamesPanel = new ClassNamesPanel(project);
        tablePanel = new FieldTablePanel(project);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(classNamesPanel, NORTH);
        panel.add(tablePanel, CENTER);

        init();
    }

    public GenerationParams getGenerationParams() {
        DefaultGenerationParams params = new DefaultGenerationParams();
        params.setPackageName(classNamesPanel.getPackageName());
        params.setDtoClassName(classNamesPanel.getClassName());
        for (GenerateDtoTableRow row : tablePanel.getData()) {
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

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return panel;
    }

}
