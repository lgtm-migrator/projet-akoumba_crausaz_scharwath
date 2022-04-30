package ch.heigvd.dil.project;

import ch.heigvd.dil.project.FilesManager.Injector;
import ch.heigvd.dil.project.factories.Configuration;
import org.junit.Test;

import java.io.IOException;

/**
 * Tests the template injection system
 */
public class InjectorTest {
    /**
     * Test the injection of a configuration in a template
     * @throws IOException
     */
    @Test
    public void shouldInjectConfiguration () throws IOException {
        Injector inj = new Injector();

        System.out.println(inj.compile("Hello {{ url }}, {{ author }}, {{ language }}",
                new Configuration("localhost", "Nicolas Crausaz", "fr")));
    }
}
