package ch.heigvd.dil.project.core.FilesManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;

public class TreeBuilder {
    private static final Logger LOG = Logger.getLogger(TreeBuilder.class.getName());
    private final File root;
    private final File dest;

    private ArrayList<File> ignoreFiles;

    public TreeBuilder(File root, File dest) {
        this.root = root;
        this.dest = dest;
        ignoreFiles = new ArrayList<>();
        addIgnoreFile(Path.of("build"));
        addIgnoreFile(Path.of("config.yml"));
    }

    private void addIgnoreFile(Path path) {
        ignoreFiles.add(root.toPath().resolve(path).toFile());
    }

    private ArrayList<File> getFiles(File file){
        ArrayList<File> files = new ArrayList<>();
        var childrenFiles = file.listFiles();
        if (childrenFiles == null) return files;
        for (File childFile : childrenFiles) {
            if (ignoreFiles.contains(childFile)) continue;
            files.add(childFile);
            files.addAll(getFiles(childFile));
        }
        return files;
    }

    public void build() throws IOException {
        var files = getFiles(root);
        for (File file : files) {
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
