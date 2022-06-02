package ch.heigvd.dil.project.commands;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
 * Test for 'new' command
 *
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class InitCommandTest {

    static final String TEST_FOLDER = "./website";

    /** Delete the temporary folder after the tests. */
    @BeforeAll
    @AfterAll
    static void clearProject() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /** Delete the temporary folder after each test. */
    @AfterEach
    void clearProjectEach() throws IOException {
        clearProject();
    }

    /**
     * When we create a new project, the project folder should be created. And the project should be
     * initialized. So we check that the project folder exists and some files are created.
     */
    @Test
    public void shouldCreateAFolder() {
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
        var projectFolder = new File(TEST_FOLDER);
        assertTrue(projectFolder.exists());
        assertTrue(projectFolder.isDirectory());
        var files = projectFolder.listFiles();
        assertNotNull(files);
        assertTrue(files.length > 0);
    }

    /** The configuration file should be created. */
    @Test
    public void shouldCreateAConfigFile() throws IOException {
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER, "config.yml").exists());
    }

    /** The project should have an index.md file. */
    @Test
    public void shouldCreateAnMarkdownIndexFile() throws IOException {
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER, "index.md").exists());
    }

    /** The project should have a page folder with a page.md file. */
    @Test
    public void shouldCreateAExamplePageWithMarkdown() throws IOException {
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
        assertTrue(new File(TEST_FOLDER + "/page/page.md").exists());
    }
}
