package ch.heigvd.dil.project;

import ch.heigvd.dil.project.commands.InitCommand;
import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.FilesManager.Injector;
import ch.heigvd.dil.project.core.PageConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.codehaus.plexus.util.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import picocli.CommandLine;

/** Tests the template injection system */
public class InjectorTest {

    private static final String TEST_FOLDER = "./website";
    private static final String LAYOUT_PATH = TEST_FOLDER + "/layouts/layout";

    @Before
    public void initMockProject() {
        // Here we use another command (init)
        String[] args = new String[] {TEST_FOLDER};
        CommandLine cmd = new CommandLine(new InitCommand());
        cmd.execute(args);
    }

    /**
     * Test the injection of a configuration in a template
     *
     * @throws IOException on compilation error Unit test
     */
    @Test
    public void shouldInjectConfiguration() throws IOException {
        Injector inj = new Injector();

        String res =
                inj.compile(
                        "Hello {{ url }}, {{ title }}, {{ language }}",
                        new Configuration("localhost", "fr", "Mon super site"));

        Assert.assertEquals(res, "Hello localhost, Mon super site, fr");
    }

    /** Test the injection of variables Unit test */
    @Test
    public void shouldInjectVariables() throws IOException {
        Injector inj = new Injector();

        Configuration siteConfig = new Configuration("http://localhost:8080", "fr", "super site");
        PageConfiguration pageConfig =
                new PageConfiguration("mon titre de page", "Nicolas Crausaz", "2022-05-02");

        System.out.println(inj.injectLayout(Path.of(LAYOUT_PATH), siteConfig, pageConfig));
    }

    /** Test page building with layout Integration test */
    @Test
    public void shouldBuildPageFromDefaultLayout() {}

    @After
    public void clearProject() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }
}
