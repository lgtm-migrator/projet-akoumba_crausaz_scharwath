package ch.heigvd.dil.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch.heigvd.dil.project.commands.InitCommand;
import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.FilesManager.Injector;
import ch.heigvd.dil.project.core.PageConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

/**
 * Tests the template injection system
 *
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class InjectorTest {

    private static final String TEST_FOLDER = "./website";
    private static final String LAYOUT_PATH = TEST_FOLDER + "/layouts/layout";

    /** Initialize the test folder with init command */
    @BeforeAll
    static void initMockProject() {
        // Here we use another command (init)
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
    }

    /** Delete the temporary folder after the tests. */
    @AfterAll
    static void clearProject() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /**
     * Test the injection of a configuration in a template
     *
     * @throws IOException on compilation error Unit test
     */
    @Test
    public void shouldInjectConfiguration() throws IOException {
        String res =
                Injector.compile(
                        "Hello {{ url }}, {{ title }}, {{ language }}",
                        new Configuration("localhost", "fr", "Mon super site"));

        assertEquals(res, "Hello localhost, Mon super site, fr");
    }

    /** Test the injection of variables Unit test */
    @Test
    public void shouldInjectVariablesAndPartialsInLayout() throws IOException {
        Configuration siteConfig = new Configuration("localhost:8080", "fr", "super site");
        PageConfiguration pageConfig =
                new PageConfiguration("mon titre de page", "Nicolas Crausaz", "2022-05-02");

        Injector.injectLayout(Path.of(LAYOUT_PATH), siteConfig, pageConfig, "le contenu");
    }
}
