package ch.heigvd.dil.project.FilesManager;

import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.ConfigurationTemplate;
import com.github.jknack.handlebars.Handlebars;
import java.io.IOException;

/** Class for template injection & compilations methods */
public class Injector {
    /**
     * Inject a configuration in a templated string
     *
     * @param pageContent templated string
     * @param config the configuration to inject
     * @return Injected string
     * @throws IOException on compilation error
     */
    public String compile(String pageContent, Configuration config) throws IOException {
        Handlebars handlebars = new Handlebars();

        ConfigurationTemplate template =
                handlebars.compileInline(pageContent).as(ConfigurationTemplate.class);
        return template.apply(config);
    }
}
