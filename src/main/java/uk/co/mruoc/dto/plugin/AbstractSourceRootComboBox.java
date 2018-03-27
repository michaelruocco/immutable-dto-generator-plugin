package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.ui.ComboBox;

import java.nio.file.Path;

public abstract class AbstractSourceRootComboBox extends ComboBox<SourceRootComboBoxItem> {

    public AbstractSourceRootComboBox(SourceRootComboBoxItem[] items) {
        super(items);
    }

    protected abstract boolean hasSelectedSource();

    protected abstract Path getSelectedSourcePath();

}
