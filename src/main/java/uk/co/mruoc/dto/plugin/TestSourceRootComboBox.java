package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;

class TestSourceRootComboBox extends SourceRootComboBox {

    TestSourceRootComboBox(Project project) {
        super(project);
        setSelectedIndex(getTestItemIndex());
    }

    private int getTestItemIndex() {
        SourceRootComboBoxItem[] items = super.getItems();
        for (int i = 0; i < items.length; i++) {
            SourceRootComboBoxItem item = items[i];
            if (item.isTestSourceItem()) {
                return i;
            }
        }
        return 0;
    }

}
