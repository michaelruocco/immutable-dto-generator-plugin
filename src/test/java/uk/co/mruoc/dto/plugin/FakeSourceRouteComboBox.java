package uk.co.mruoc.dto.plugin;

import java.nio.file.Path;

public class FakeSourceRouteComboBox extends AbstractSourceRootComboBox {

    private Path path;
    private boolean selectedSource;

    FakeSourceRouteComboBox() {
        super(new SourceRootComboBoxItem[0]);
    }

    @Override
    public boolean hasSelectedSource() {
        return selectedSource;
    }

    @Override
    public Path getSelectedSourcePath() {
        return path;
    }

    public void setHasSelectedSource(boolean selectedSource) {
        this.selectedSource = selectedSource;
    }

    public void setSelectedSourcePath(Path path) {
        this.path = path;
    }

}
