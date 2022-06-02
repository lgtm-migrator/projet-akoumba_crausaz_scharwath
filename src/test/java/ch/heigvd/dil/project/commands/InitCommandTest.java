package ch.heigvd.dil.project.commands;

import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for 'new' command
 */
public class InitCommandTest {

    static final String TEST_FOLDER = "./website";

    @BeforeAll
    @AfterAll
    static void clearProject() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @AfterEach
    void clearProjectEach() throws IOException {
        clearProject();
    }

    @Test
    public void shouldCreateAFolder() throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER).exists());
    }

    @Test
    public void shouldCreateAConfigFile() throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER, "config.yml").exists());
    }

    @Test
    public void shouldCreateAnMarkdownIndexFile() throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER, "index.md").exists());
    }

    @Test
    public void shouldCreateAExamplePageWithMarkdown() throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
        assertTrue(new File(TEST_FOLDER + "/page/page.md").exists());
    }
}
