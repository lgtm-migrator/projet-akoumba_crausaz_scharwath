package ch.heigvd.dil.project.core.FilesManager;

import ch.heigvd.dil.project.core.Configuration;
import ch.heigvd.dil.project.core.PageConfiguration;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.FileTemplateLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
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

        Template template =
                handlebars.compileInline(pageContent);
        return template.apply(config);
    }

    public String injectLayout(Path pathToLayout, Configuration globalConfig, PageConfiguration pageConfig) throws IOException {
        FileTemplateLoader loader = new FileTemplateLoader(new File(String.valueOf(pathToLayout.getParent())));
        loader.setSuffix(".html");
        Handlebars handlebars = new Handlebars(loader);
        Template temp = handlebars.compile("layout");

        Map scopes = new HashMap();
        scopes.put("site", globalConfig);
        scopes.put("page", pageConfig);

        return temp.apply(scopes);
    }
}
