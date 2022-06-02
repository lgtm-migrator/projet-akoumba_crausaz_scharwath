package ch.heigvd.dil.project.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

/**
 * Test class for the BuildCommand class.
 *
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class BuildCommandTest {

    private static final String TEST_FOLDER = "./website";

    /** Create a temporary folder for the tests. */
    @BeforeAll
    static void initMockProject() {
        // Here we use another command (init)
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
    }

    /** Delete the temporary folder after the tests. */
    @BeforeAll
    @AfterAll
    static void clearProject() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /** Delete the temporary folder after each test. */
    @AfterEach
    void clearBuildFolder() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /** Test the build command. */
    @Test
    public void shouldBuildProject() {
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new BuildCommand());
        cmd.execute(args);
        File buildFolder = new File(TEST_FOLDER, "build");
        assertTrue(buildFolder.exists());
    }
}
