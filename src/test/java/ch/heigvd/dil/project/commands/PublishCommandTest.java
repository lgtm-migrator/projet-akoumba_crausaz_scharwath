package ch.heigvd.dil.project.commands;

import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PublishCommandTest {
    private static final String TEST_FOLDER = "./website";
    private static final String[] args = new String[]{TEST_FOLDER};

    @BeforeAll
    @AfterAll
    static void cleanAll() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @AfterEach
    void clean() throws IOException {
        cleanAll();
    }

    @Test
    public void shouldSkipIfNoBuildFiles() {
        CommandLine cmd = new CommandLine(new PublishCommand());
        assertDoesNotThrow(() -> cmd.execute(args));
    }

    @Test
    public void shouldThrowIfInvalidConfiguration() {
        CommandLine cmd = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        CommandLine cmd3 = new CommandLine(new PublishCommand());
        assertThrows(AssertionError.class, () -> {
            cmd.execute(args);
            cmd2.execute(args);
            cmd3.execute(args);
        });
    }
}
