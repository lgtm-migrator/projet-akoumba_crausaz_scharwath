package ch.heigvd.dil.project.commands;

import org.codehaus.plexus.util.FileUtils;
import org.junit.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

/**
 * Test for 'new' command
 */
public class InitCommandTest {

    static final String TEST_FOLDER = "./testsite";

    @Test
    public void shouldCreateAFolder () throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER).exists());

        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @Test
    public void shouldCreateAConfigFile () throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER + "/config.yml").exists());

        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @Test(expected = FileAlreadyExistsException.class)
    public void shouldThrowIfFolderAlreadyExists() throws IOException {
        Files.createDirectory(Paths.get(TEST_FOLDER));

        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }


    @Test
    public void shouldCreateAnMarkdownIndexFile () throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER + "/index.md").exists());

        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @Test
    public void shouldCreateAExamplePageWithMarkdown () throws IOException {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);

        assertTrue(new File(TEST_FOLDER + "/page/page.md").exists());

        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }
}