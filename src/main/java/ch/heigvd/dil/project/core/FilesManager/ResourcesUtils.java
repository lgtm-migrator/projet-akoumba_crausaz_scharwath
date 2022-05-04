package ch.heigvd.dil.project.core.FilesManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

/**
 * Methods for resources management
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class ResourcesUtils {

    /**
     * Copy a resource to a destination

     * @param sourcePath wanted resources path
     * @param target path to the destination
     * @throws URISyntaxException if ressource not found
     * @throws IOException if destination path not found
     */
    public static void copyFromJar(final String sourcePath, final Path target)
            throws URISyntaxException, IOException {
        Path source = getPathFromJar(sourcePath);
        Files.walkFileTree(
                source,
                new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult preVisitDirectory(
                            final Path dir, final BasicFileAttributes attrs) throws IOException {
                        Path currentTarget = target.resolve(source.relativize(dir).toString());
                        Files.createDirectories(currentTarget);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(
                            final Path file, final BasicFileAttributes attrs) throws IOException {
                        Files.copy(
                                file,
                                target.resolve(source.relativize(file).toString()),
                                StandardCopyOption.REPLACE_EXISTING);
                        return FileVisitResult.CONTINUE;
                    }
                });
    }

    /**
     * Get path to a resource
     *
     * @param sourcePath wanted ressource
     * @return path of ressource
     * @throws URISyntaxException if ressource not found
     */
    public static Path getPathFromJar(final String sourcePath) throws URISyntaxException {
        Path source;
        try {
            FileSystem fileSystem =
                    FileSystems.newFileSystem(
                            ResourcesUtils.class.getResource("").toURI(),
                            Collections.<String, String>emptyMap());
            source = fileSystem.getPath(sourcePath);
        } catch (Exception e) {
            source = Path.of(ResourcesUtils.class.getClassLoader().getResource(sourcePath).toURI());
        }
        return source;
    }

    /**
     * Get a resource file content as string
     *
     * @param sourcePath wanted ressource
     * @return resource file content as string
     * @throws URISyntaxException if ressource not found
     * @throws IOException if source path not found
     */
    public static String getFileFromJarAsString(final String sourcePath)
            throws URISyntaxException, IOException {
        return Files.readString(getPathFromJar(sourcePath));
    }
}
