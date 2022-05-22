package ch.heigvd.dil.project.commands;

import org.junit.Test;
import picocli.CommandLine;

public class PublishCommandTest {

    private static final String TEST_FOLDER = "./website";
    private static final String[] args = new String[]{TEST_FOLDER};

    @Test
    public void shouldSkipIfNoBuildFiles() {

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowIfInvalidConfiguration() {
        CommandLine cmd = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        CommandLine cmd3 = new CommandLine(new PublishCommand());
        cmd.execute(args);
        cmd2.execute(args);
        cmd3.execute(args);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowIfConnectionFailed() {
        CommandLine cmd = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        CommandLine cmd3 = new CommandLine(new PublishCommand());
        cmd.execute(args);
        cmd2.execute(args);
        cmd3.execute(args);
    }
}
