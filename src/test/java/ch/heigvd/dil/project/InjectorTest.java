package ch.heigvd.dil.project;

import ch.heigvd.dil.project.FilesManager.Injector;
import ch.heigvd.dil.project.factories.Configuration;
import org.junit.Test;

import java.io.IOException;

public class InjectorTest {
    @Test
    public void test () throws IOException {
        Injector inj = new Injector();

        System.out.println(inj.compile("Hello {{ url }}, {{ author }}, {{ language }}",
                new Configuration("localhost", "Nicolas Crausaz", "fr")));
    }
}
