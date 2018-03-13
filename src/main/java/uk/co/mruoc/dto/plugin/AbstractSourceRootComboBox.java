package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ComboBox;

import java.nio.file.Path;

public abstract class AbstractSourceRootComboBox extends ComboBox<SourceRootComboBoxItem> {

    public AbstractSourceRootComboBox(SourceRootComboBoxItem[] items) {
        super(items);
    }

    abstract boolean hasSelectedSource();

    abstract Path getSelectedSourcePath();

}
