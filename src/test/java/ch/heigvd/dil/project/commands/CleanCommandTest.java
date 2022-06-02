package ch.heigvd.dil.project.commands;

import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test class for the CleanCommand class.
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class CleanCommandTest {

    private static final String TEST_FOLDER = "./website";

    /**
     * Create a temporary folder for the tests. And init a project.
     */
    @BeforeAll
    static void initMockProject() {
        // Here we use another command (init)
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
    }

    /**
     * Delete the temporary folder after the tests.
     */
    @BeforeAll
    @AfterAll
    static void clearProject() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /**
     * Delete the temporary folder after each test.
     */
    @Test
    public void shouldCleanBuildFolder() {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new CleanCommand());
        cmd.execute(args);

        assertFalse(new File(TEST_FOLDER, "build").exists());
    }

    /**
     * If the folder does not exist, the command should not fail.
     */
    @Test
    public void shouldIgnoreIfNoBuildFolder() {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new CleanCommand());
        assertDoesNotThrow(() -> cmd.execute(args));
        assertFalse(new File(TEST_FOLDER, "build").exists());
    }
}
