package uk.co.mruoc.dto.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFileManager;
import uk.co.mruoc.code.*;

import java.nio.file.Path;

public class GenerateDtoAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getProject();
        GenerateDialog dialog = new GenerateDialog(project);
        boolean ok = dialog.showAndGet();
        if (ok) {
            generateClasses(dialog);
        }
    }

    private void generateClasses(GenerateDialog dialog) {
        Path productionPath = dialog.getSourcePath();
        Path testPath = dialog.getTestSourcePath();
        GenerationParams params = dialog.getGenerationParams();
        FilesGenerator generator = new FilesGenerator(productionPath, testPath, params);

        FileDocumentManager.getInstance().saveAllDocuments();
        generator.generate();
        VirtualFileManager.getInstance().refreshWithoutFileWatcher(false);
    }

}
