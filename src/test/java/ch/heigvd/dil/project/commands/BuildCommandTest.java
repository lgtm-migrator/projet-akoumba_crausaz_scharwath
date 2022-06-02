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


public class BuildCommandTest {

    private static final String TEST_FOLDER = "./website";

    @BeforeAll
    static void initMockProject() {
        // Here we use another command (init)
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
    }

    @BeforeAll
    @AfterAll
    static void clearProject() throws IOException {
        System.out.println("clearing mock project " + TEST_FOLDER);
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @AfterEach
    void clearBuildFolder() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    @Test
    public void shouldBuildProject() {
        String[] args = new String[]{TEST_FOLDER};
        CommandLine cmd = new CommandLine(new BuildCommand());
        cmd.execute(args);
        File buildFolder = new File(TEST_FOLDER, "build");
        assertTrue(buildFolder.exists());
    }
}
