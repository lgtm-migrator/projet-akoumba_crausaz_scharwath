package ch.heigvd.dil.project;

import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.FilesManager.Injector;
import ch.heigvd.dil.project.core.PageConfiguration;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

/**
 * Class for performance evaluation of the template injection
 */
public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    /**
     * Defines our evaluation
     * @throws IOException
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void evaluate() throws IOException {
        Configuration siteConfig = new Configuration("localhost:8080", "fr", "super site");
        PageConfiguration pageConfig =
                new PageConfiguration("mon titre de page", "Nicolas Crausaz", "2022-05-02");

        Injector.injectLayout(Path.of("./website/layouts/layout"), siteConfig, pageConfig, "le contenu");
    }
}
