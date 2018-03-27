package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;
import java.nio.file.Path;

public class ClassNamesPanel extends JPanel {

    private final AbstractSourceRootComboBox sourceComboBox;
    private final AbstractSourceRootComboBox testComboBox;

    private final JTextField packageNameField;
    private final JTextField classNameField;

    private final JCheckBox isApiClassCheckBox;

    ClassNamesPanel(Project project) {
        this(new PackageNameField(),
                new ClassNameField(),
                new SourceRootComboBox(project),
                new TestSourceRootComboBox(project),
                new JCheckBox());
    }

    ClassNamesPanel(JTextField packageNameField,
                    JTextField classNameField,
                    AbstractSourceRootComboBox sourceComboBox,
                    AbstractSourceRootComboBox testComboBox,
                    JCheckBox isApiClassCheckBox) {
        this.packageNameField = packageNameField;
        this.classNameField = classNameField;
        this.sourceComboBox = sourceComboBox;
        this.testComboBox = testComboBox;
        this.isApiClassCheckBox = isApiClassCheckBox;

        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
        builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        builder.appendColumn("right:pref");
        builder.appendColumn("5dlu");
        builder.appendColumn("fill:max(pref; 300px)");
        builder.appendColumn("5dlu");

        builder.append("Production Source", sourceComboBox);
        builder.append("Test Source", testComboBox);
        builder.append("Package Name", packageNameField);
        builder.append("Class Name", classNameField);
        builder.append("API Class", isApiClassCheckBox);

        add(builder.getPanel());
    }

    public void addItemListener(ItemListener listener) {
        sourceComboBox.addItemListener(listener);
        testComboBox.addItemListener(listener);
    }

    public void addDocumentListener(DocumentListener listener) {
        packageNameField.getDocument().addDocumentListener(listener);
        classNameField.getDocument().addDocumentListener(listener);
    }

    public boolean isCompleted() {
        if (!sourceComboBox.hasSelectedSource()) {
            return false;
        }
        if (!testComboBox.hasSelectedSource()) {
            return false;
        }
        return !getClassName().isEmpty();
    }

    public Path getSourcePath() {
        return sourceComboBox.getSelectedSourcePath();
    }

    public Path getTestSourcePath() {
        return testComboBox.getSelectedSourcePath();
    }

    public String getPackageName() {
        return packageNameField.getText().trim();
    }

    public String getClassName() {
        return classNameField.getText().trim();
    }

    public boolean isApiClass() {
        return isApiClassCheckBox.isSelected();
    }

}
