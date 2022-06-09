package ch.heigvd.dil.project.commands;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

/**
 * PublishCommandTest class.
 *
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class PublishCommandTest {
    private static final String TEST_FOLDER = "./website";
    private static final String[] args = new String[] {TEST_FOLDER};

    /** Create a temporary folder for the tests. */
    @BeforeAll
    @AfterAll
    static void cleanAll() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /** Delete the temporary folder after each test. */
    @AfterEach
    void clean() throws IOException {
        cleanAll();
    }

    /** If the folder does not exist, the command should not fail. */
    @Test
    public void shouldSkipIfNoBuildFiles() {
        CommandLine cmd = new CommandLine(new PublishCommand());
        assertDoesNotThrow(() -> cmd.execute(args));
    }

    /** If configuration id invalid, the command should throw an exception. */
    @Test
    public void shouldThrowIfInvalidConfiguration() {
        CommandLine cmd = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        CommandLine cmd3 = new CommandLine(new PublishCommand());
        assertThrows(
                AssertionError.class,
                () -> {
                    cmd.execute(args);
                    cmd2.execute(args);
                    cmd3.execute(args);
                });
    }
}
