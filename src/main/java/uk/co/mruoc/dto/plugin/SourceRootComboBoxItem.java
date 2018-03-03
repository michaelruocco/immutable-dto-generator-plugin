package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.util.Objects;

public class SourceRootComboBoxItem {

    private Project project;
    private VirtualFile virtualFile;

    SourceRootComboBoxItem(Project project, VirtualFile virtualFile) {
        this.project = project;
        this.virtualFile = virtualFile;
    }

    @Override
    public String toString() {
        String basePath = Objects.requireNonNull(project.getBasePath());
        String fileUrl = virtualFile.getPresentableUrl();
        return fileUrl.replace(basePath, "");
    }

    public boolean isTestSourceItem() {
        return toString().toLowerCase().contains("test");
    }

    public VirtualFile getVirtualFile() {
        return virtualFile;
    }

}
