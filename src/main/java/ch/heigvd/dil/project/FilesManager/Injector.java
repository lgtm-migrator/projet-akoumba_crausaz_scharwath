package ch.heigvd.dil.project.FilesManager;

import ch.heigvd.dil.project.factories.Configuration;
import ch.heigvd.dil.project.factories.ConfigurationTemplate;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import java.io.IOException;

public class Injector {
    public String compile(String pageContent, Configuration config) throws IOException {
        Handlebars handlebars = new Handlebars();

        ConfigurationTemplate template = handlebars.compileInline(pageContent).as(ConfigurationTemplate.class);
        return template.apply(config);
    }
}
