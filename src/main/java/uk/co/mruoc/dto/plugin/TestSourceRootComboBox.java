package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;

import javax.swing.ComboBoxModel;

class TestSourceRootComboBox extends SourceRootComboBox {

    TestSourceRootComboBox(Project project) {
        super(project);
        setSelectedIndex(getTestItemIndex());
    }

    private int getTestItemIndex() {
        ComboBoxModel<SourceRootComboBoxItem> model = getModel();
        for (int i = 0; i < model.getSize(); i++) {
            SourceRootComboBoxItem item = model.getElementAt(i);
            if (item.isTestSourceItem()) {
                return i;
            }
        }
        if (model.getSize() > 0) {
            return 0;
        }
        return -1;
    }

}
