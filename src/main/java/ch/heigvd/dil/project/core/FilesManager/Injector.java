package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.ConfigurationTemplate;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import java.io.IOException;
import java.util.Map;

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

    public String injectLayout(String layoutName, Map<String, Configuration> scopes) throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader();
        loader.setPrefix("./website/layouts");
        loader.setSuffix(".html");
        Handlebars handlebars = new Handlebars(loader);
        Template temp = handlebars.compile(layoutName);
        return temp.apply(scopes.get("site"));
    }
}
