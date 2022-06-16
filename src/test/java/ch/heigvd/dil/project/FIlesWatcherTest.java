package ch.heigvd.dil.project;

import ch.heigvd.dil.project.core.FilesManager.FilesWatcher;
import ch.heigvd.dil.project.core.FilesManager.FilesWatcherHandler;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.HashSet;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 * Test class for the FilesWatcher class.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class FIlesWatcherTest {
    private static final Path rootPath = Path.of("./data/watcher");

    /** Delete the temporary folder after and before the tests. */
    @AfterAll
    static void tearDown() throws IOException {
        FileUtils.deleteDirectory(rootPath.toFile());
    }

    /** Should copy files when they are created in a watched directory. */
    @Test
    public void shouldCopyFileToDestWhenCreated() throws IOException, InterruptedException {
        rootPath.toFile().mkdirs();
        // create set of files
        HashSet<Path> files =
                new HashSet<>() {
                    {
                        add(rootPath.resolve("file1.txt"));
                        add(rootPath.resolve("file2.txt"));
                        add(rootPath.resolve("file3.txt"));
                    }
                };
        HashSet<Path> testFiles = new HashSet<>();
        var filesWatcher =
                new FilesWatcher(
                        rootPath,
                        new FilesWatcherHandler() {
                            @Override
                            public void onChange(Path path, WatchEvent.Kind<?> kind) {
                                testFiles.add(path);
                            }
                        });
        filesWatcher.watch();
        // create files
        for (Path file : files) {
            System.out.println("Creating file " + file.toAbsolutePath());
            FileUtils.writeStringToFile(file.toFile(), file.toString(), "UTF-8");
        }
        // wait for the files to be created
        Thread.sleep(1000);
        filesWatcher.stop();
        // check if all files have been created
        assert (testFiles.size() == files.size());
    }
}
