package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiJavaParserFacade;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiType;
import com.intellij.psi.impl.PsiJavaParserFacadeImpl;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.nio.file.Path;

public class ClassNamesPanel extends JPanel {

    private SourceRootComboBox sourceComboBox;
    private SourceRootComboBox testComboBox;

    private JTextField packageNameField = new PackageNameField();
    private JTextField classNameField = new ClassNameField();

    public ClassNamesPanel(Project project) {
        sourceComboBox = new SourceRootComboBox(project);
        testComboBox = new TestSourceRootComboBox(project);

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

        add(builder.getPanel());
    }

    public Path getSourcePath() {
        return sourceComboBox.getSelectedSourcePath();
    }

    public Path getTestSourcePath() {
        return testComboBox.getSelectedSourcePath();
    }

    public String getPackageName() {
        return packageNameField.getText();
    }

    public String getClassName() {
        return classNameField.getText();
    }

}
