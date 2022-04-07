package ch.heigvd.dil.project.core.FilesManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to build and compile the tree of files.
 */
public class TreeBuilder {
    private final File root;
    private final File dest;

    public TreeBuilder(File root, File dest) {
        this.root = root;
        this.dest = dest;
    }

    /**
     * This method is used to build the tree of files.
     */
    public void build() {
        //TODO: Check if the root is a valid project directory
        //TODO: use Configuration
        //TODO: logs errors and info

        var files = new ArrayList<>(
                FileUtils.listFilesAndDirs(root, FileFileFilter.INSTANCE, DirectoryFileFilter.INSTANCE)
        );
        Collections.reverse(files); // reverse the list to have the root at first
        for (File file : files) {
            if (file == root) continue; // skip the root
            if (!file.exists()) continue; // skip the non-existing files

            var relativePath = root.toPath().relativize(file.toPath()); // get the relative path
            var destFile = new File(dest, relativePath.toString()); // get the destination file

            if (file.isDirectory()) { // if it's a directory create it
                if (!destFile.mkdirs()) {
                    //TODO use logger
                    System.out.println("Error while creating directory " + destFile.getName());
                }
            } else if (file.getName().endsWith(".md")) { // if it's a markdown file compile it
                // rename the file to .html
                var htmlFile = new File(
                        destFile.getParentFile(),
                        destFile.getName().replace(".md", ".html")
                );
                try {
                    new FileBuilder(file, htmlFile).build();
                } catch (Exception e) {
                    //TODO use logger
                    System.out.println("Error while building file " + file.getName());
                    e.printStackTrace();
                }
            } else { // if it's not a markdown file copy it
                try {
                    FileUtils.copyFile(file, destFile);
                } catch (Exception e) {
                    //TODO use logger
                    System.out.println("Error while copying file " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}
