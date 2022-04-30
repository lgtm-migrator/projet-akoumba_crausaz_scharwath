package ch.heigvd.dil.project.core.FilesManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;

public class TreeBuilder {
    private static final Logger LOG = Logger.getLogger(TreeBuilder.class.getName());
    private final File root;
    private final File dest;

    public TreeBuilder(File root, File dest) {
        this.root = root;
        this.dest = dest;
    }

    public void build() throws IOException {
        var files =
                new ArrayList<>(
                        FileUtils.listFilesAndDirs(
                                root, FileFileFilter.INSTANCE, DirectoryFileFilter.INSTANCE));
        Collections.reverse(files);
        for (File file : files) {
            if (file == root) continue;
            var relativePath = root.toPath().relativize(file.toPath());
            var destFile = new File(dest, relativePath.toString());
            if (file.getName().endsWith(".md")) {
                var htmlFile =
                        new File(
                                destFile.getParentFile(),
                                destFile.getName().replace(".md", ".html"));
                new FileBuilder(file, htmlFile).build();
            } else {
                if (file.isDirectory()) {
                    destFile.mkdirs();
                } else {
                    FileUtils.copyFile(file, destFile);
                }
            }
            LOG.info("Copied " + file.getAbsolutePath() + " to " + destFile.getAbsolutePath());
        }
    }
}
