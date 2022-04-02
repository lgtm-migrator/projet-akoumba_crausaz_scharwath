package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.Main;
import org.junit.Test;
import picocli.CommandLine;

/**
 * Test for 'new' command
 */
public class InitCommandTest {

    @Test
    public void shouldRun() {
        new InitCommand();
    }

    @Test
    public void shouldCreateAConfigFile () {

        String[] args = new String[]{"/home/nicolas/Downloads/test"};
        CommandLine cmd = new CommandLine(new InitCommand());

        cmd.execute(args);
    }


    @Test
    public void shouldCreateAnMarkdownIndexFile () {

    }

    @Test
    public void shouldCreateAExamplePageWithMarkdown () {

    }

    @Test
    public void shouldCreateAExamplePageWithPicture () {

    }
}