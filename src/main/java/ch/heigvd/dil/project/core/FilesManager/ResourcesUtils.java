package ch.heigvd.dil.project.core.FilesManager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

public class ResourcesUtils {
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

    public static String getFileFromJarAsString(final String sourcePath)
            throws URISyntaxException, IOException {
        return Files.readString(getPathFromJar(sourcePath));
    }
}
