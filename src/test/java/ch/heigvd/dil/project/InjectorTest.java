package ch.heigvd.dil.project;

import ch.heigvd.dil.project.commands.InitCommand;
import ch.heigvd.dil.project.core.FilesManager.Injector;
import ch.heigvd.dil.project.core.Configuration;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import picocli.CommandLine;

/**
 * Tests the template injection system
 */
public class InjectorTest {

    private static final String TEST_FOLDER = "./website";

    @Before
    public void initMockProject() {
        // Here we use another command (init)
        String[] args = new String[]{TEST_FOLDER};
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

        System.out.println(
                inj.compile(
                        "Hello {{ url }}, {{ author }}, {{ language }}",
                        new Configuration("localhost", "Nicolas Crausaz", "fr")));
    }

    /**
     * Test the injection of site variables
     */
    @Test
    public void shouldInjectVariablesWithSiteScope() {

    }

    /**
     * Test the injection of page variables
     */
    @Test
    public void shouldInjectVariablesWithPageScope() {

    }

    /**
     * Test the injection of variables
     */
    @Test
    public void shouldInjectVariables() {

    }

    /**
     * Test page building with layout
     */
    @Test
    public void shouldBuildPageFromDefaultLayout() {

    }
}
