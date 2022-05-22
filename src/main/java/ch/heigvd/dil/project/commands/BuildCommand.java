package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.FilesManager.TreeBuilder;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
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
@Benchmark
@BenchmarkMode(Mode.AverageTime)
public class BuildCommand extends BaseCommand {
    private static final Logger LOG = Logger.getLogger(BuildCommand.class.getName());

    @CommandLine.Parameters(index = "0", description = "Path to the site to build")
    String creationPath;

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
    }
}
