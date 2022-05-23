package ch.heigvd.dil.project;
import ch.heigvd.dil.project.core.FilesManager.FilesWatcher;
import ch.heigvd.dil.project.core.FilesManager.FilesWatcherHandler;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.HashSet;
public class FIlesWatcherTest {
    private final Path rootPath = Path.of("./data/watcher");
    @Test
    public void shouldCreateInstance() throws IOException, InterruptedException {
        rootPath.toFile().mkdirs();
        //create set of files
        HashSet<Path> files = new HashSet<>(){
            {
                add(rootPath.resolve("file1.txt"));
                add(rootPath.resolve("file2.txt"));
                add(rootPath.resolve("file3.txt"));
            }
        };
        HashSet<Path> testFiles = new HashSet<>();
        var filesWatcher = new FilesWatcher(rootPath, new FilesWatcherHandler() {
            @Override
            public void onChange(Path path, WatchEvent.Kind<?> kind) {
                testFiles.add(path);
            }
        });
        filesWatcher.watch();
        //create files
        for (Path file : files) {
            System.out.println("Creating file " + file.toAbsolutePath());
            FileUtils.writeStringToFile(file.toFile(), file.toString(), "UTF-8");
        }
        //wait for the files to be created
        Thread.sleep(1000);
        filesWatcher.stop();
        //check if all files have been created
        assert(testFiles.size() == files.size());
    }

    @After
    public void tearDown() throws IOException {
        FileUtils.deleteDirectory(rootPath.toFile());
    }
}
