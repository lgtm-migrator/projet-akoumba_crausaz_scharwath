package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.FilesWatcher;
import ch.heigvd.dil.project.core.FilesManager.FilesWatcherHandler;
import ch.heigvd.dil.project.core.FilesManager.TreeBuilder;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.logging.Logger;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * This class represents the command line interface for the build command.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
@Command(
        name = "build",
        description = "Build the project in a build folder destination",
        version = "1.0")
public class BuildCommand extends BaseCommand {
    private static final Logger LOG = Logger.getLogger(BuildCommand.class.getName());

    @CommandLine.Parameters(index = "0", description = "Path to the site to build")
    String creationPath;

    @CommandLine.Option(
            names = {"-w", "--watch"},
            description = "Watch the site for changes")
    boolean watch;

    @Override
    protected String getRootPath() {
        return creationPath;
    }

    @Override
    public void execute() {
        // Check if the source projet exists
        var srcDir = new File(creationPath);
        var destDir = new File(srcDir, "build");
        if (!srcDir.exists()) {
            LOG.severe("The source directory does not exist");
            return;
        }

        // Build the site into build folder
        var treeBuilder = new TreeBuilder(srcDir, destDir);
        try {
            treeBuilder.build();
        } catch (IOException e) {
            LOG.severe("An error occurred while building the site: " + e.getMessage());
            e.printStackTrace();
        }

        if (watch) {
            try {
                var watcher =
                        new FilesWatcher(
                                srcDir.toPath(),
                                new FilesWatcherHandler() {
                                    @Override
                                    public void onChange(Path path, WatchEvent.Kind<?> kind) {
                                        LOG.info("File " + path.toAbsolutePath() + " has changed");
                                        try {
                                            treeBuilder.build();
                                        } catch (IOException e) {
                                            LOG.severe(
                                                    "An error occurred while building the site: "
                                                            + e.getMessage());
                                            e.printStackTrace();
                                        }
                                    }
                                });
                watcher.addIgnoreFile("build");
                watcher.watch();
            } catch (Exception e) {
                LOG.severe("An error occurred while watching the build folder: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
