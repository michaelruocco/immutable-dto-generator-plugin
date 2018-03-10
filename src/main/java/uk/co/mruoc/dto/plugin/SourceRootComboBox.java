package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.vfs.VirtualFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SourceRootComboBox extends ComboBox<SourceRootComboBoxItem> {

    SourceRootComboBox(Project project) {
        this(toSourceRootComboBoxItems(project));
    }

    private SourceRootComboBox(SourceRootComboBoxItem[] items) {
        super(items);
    }

    public boolean hasSelectedSource() {
        return getSelectedIndex() != -1;
    }

    public Path getSelectedSourcePath() {
        SourceRootComboBoxItem item = (SourceRootComboBoxItem) getSelectedItem();
        VirtualFile file = Objects.requireNonNull(item).getVirtualFile();
        return Paths.get(file.getPresentableUrl());
    }

    private static SourceRootComboBoxItem[] toSourceRootComboBoxItems(Project project) {
        List<SourceRootComboBoxItem> items = new ArrayList<>();
        List<VirtualFile> sourceRoots = toSourceRoots(project);
        sourceRoots.forEach(sourceRoot -> items.add(new SourceRootComboBoxItem(project, sourceRoot)));
        return items.toArray(new SourceRootComboBoxItem[sourceRoots.size()]);
    }

    private static List<VirtualFile> toSourceRoots(Project project) {
        List<VirtualFile> sourceRoots = new ArrayList<>();
        List<Module> modules = toAllModules(project);
        modules.forEach(module -> sourceRoots.addAll(toSourceRoots(module)));
        return sourceRoots;
    }

    private static List<Module> toAllModules(Project project) {
        return Arrays.asList(ModuleManager.getInstance(project).getModules());
    }

    private static List<VirtualFile> toSourceRoots(Module module) {
        return Arrays.asList(ModuleRootManager.getInstance(module).getSourceRoots());
    }

}
