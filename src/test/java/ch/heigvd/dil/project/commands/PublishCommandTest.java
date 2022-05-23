package ch.heigvd.dil.project.commands;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.junit.After;
import org.junit.Test;
import picocli.CommandLine;

public class PublishCommandTest {
    private static final String TEST_FOLDER = "./website";
    private static final String[] args = new String[] {TEST_FOLDER};

    @Test
    public void shouldSkipIfNoBuildFiles() {
        CommandLine cmd = new CommandLine(new PublishCommand());
        cmd.execute(args);
    }

    @Test(expected = AssertionError.class)
    public void shouldThrowIfInvalidConfiguration() {
        CommandLine cmd = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        CommandLine cmd3 = new CommandLine(new PublishCommand());
        cmd.execute(args);
        cmd2.execute(args);
        cmd3.execute(args);
    }

    @After
    public void clean() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }
}
