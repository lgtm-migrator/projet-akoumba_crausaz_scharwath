package ch.heigvd.dil.project.core.FilesManager;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Class used to make actions on file structures
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class FilesWatcher {
    private final WatchService watcher;
    private final FilesWatcherHandler handler;

    private final Path root;

    private final ArrayList<Path> ignoreFiles = new ArrayList<>();

    /**
     * Create a new FilesWatcher
     *
     * @param root    source structure
     * @param handler handler to use
     */
    public FilesWatcher(Path root, FilesWatcherHandler handler) throws IOException {
        this.handler = handler;
        this.root = root;
        watcher = FileSystems.getDefault().newWatchService();
    }


    private void createTree(Path from) {
        try {
            Files.walkFileTree(from, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (ignoreFiles.contains(dir)) {
                        return FileVisitResult.SKIP_SUBTREE;
                    }
                    System.out.println("Watching directory: " + dir.toAbsolutePath());
                    dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a file/folder to ignore list
     *
     * @param path - path of the file/folder to ignore
     */
    public void addIgnoreFile(String path) {
        var ignorePath = root.resolve(path);
        System.out.println("Ignoring file: " + ignorePath.toAbsolutePath());
        ignoreFiles.add(ignorePath);
    }

    /**
     * Start watching the source structure
     */
    public Thread watch() {
        this.createTree(root);
        var t = new Thread(() -> {
            WatchKey key;
            while (true) {
                try {
                    if ((key = watcher.take()) == null) break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (WatchEvent<?> event : key.pollEvents()) {
                    try {
                        var kind = event.kind();
                        var file = root.resolve(event.context().toString());
                        if (ignoreFiles.contains(file)) {
                            continue;
                        }
                        handler.onChange(file, kind);
                        if (kind == ENTRY_CREATE) {
                            createTree(file);
                            handler.onCreate(file);
                        } else if (kind == ENTRY_DELETE) {
                            handler.onDelete(file);
                        } else if (kind == ENTRY_MODIFY) {
                            handler.onModify(file);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                key.reset();
            }
        });
        t.start();
        return t;
    }

    /**
     * Stop watching the source structure
     */
    public void stop() throws IOException {
        watcher.close();
    }
}
