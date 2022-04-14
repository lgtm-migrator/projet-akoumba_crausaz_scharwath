package ch.heigvd.dil.project.commands;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import picocli.CommandLine;

/** Test for 'new' command */
public class InitCommandTest {

    static final String TEST_FOLDER = "./website";

    @Before
    public void initProject () {
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
    }

    @Test
    public void shouldCreateAFolder() {
        assertTrue(new File(TEST_FOLDER).exists());
    }

    @Test
    public void shouldCreateAConfigFile() {
        assertTrue(new File(TEST_FOLDER + "/config.yml").exists());
    }

    @Test
    public void shouldCreateAnMarkdownIndexFile() {
        assertTrue(new File(TEST_FOLDER + "/index.md").exists());
    }

    @Test
    public void shouldCreateAExamplePageWithMarkdown() {
        assertTrue(new File(TEST_FOLDER + "/page/page.md").exists());
    }

    @After
    public void deleteProject () throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }
}
