package ch.heigvd.dil.project.core.FilesManager;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

/**
 * Class used to make actions on file structures
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public abstract class FilesWatcherHandler {
    /**
     * Called when a file change ( create, delete or modify )
     * @param path - path of the file
     * @param kind - kind of the event
     */
    public void onChange(Path path, WatchEvent.Kind<?> kind){}

    /**
     * Called when a file is created
     * @param path - path of the file
     */
    public void onCreate(Path path){}

    /**
     * Called when a file is deleted
     * @param path - path of the file
     */
    public void onDelete(Path path){}

    /**
     * Called when a file is modified
     * @param path - path of the file
     */
    public void onModify(Path path){}
}
