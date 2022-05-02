package ch.heigvd.dil.project;

import ch.heigvd.dil.project.commands.InitCommand;
import ch.heigvd.dil.project.core.FilesManager.Injector;
import ch.heigvd.dil.project.core.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import picocli.CommandLine;

/** Tests the template injection system */
public class InjectorTest {

    private static final String TEST_FOLDER = "./website";

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
     * @throws IOException on compilation error
     */
    @Test
    public void shouldInjectConfiguration() throws IOException {
        Injector inj = new Injector();

        String res = inj.compile(
                "Hello {{ url }}, {{ author }}, {{ language }}",
                new Configuration("localhost", "Nicolas Crausaz", "fr"));

        Assert.assertEquals(res, "Hello localhost, Nicolas Crausaz, fr");
    }

    /**
     * Test the injection of variables
     * Unit test
     */
    @Test
    public void shouldInjectVariables() throws IOException {
        Injector inj = new Injector();

        Map<String, Configuration> scopes = new HashMap<>();
        Configuration siteConfig = new Configuration("http://localhost:8080", "Nicolas Crausaz", "fr");
        scopes.put("site", siteConfig);
        // scopes.put("page", pageConfig);

        String result = inj.injectLayout("layout", scopes);

        System.out.println(result);

    }

    /**
     * Test page building with layout
     * Integration test
     */
    @Test
    public void shouldBuildPageFromDefaultLayout() {}
}
