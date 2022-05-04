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

/**
 * Class for template injection & compilations methods
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class Injector {
    /**
     * Inject a configuration in a templated string
     *
     * @param pageContent templated string
     * @param config the configuration to inject
     * @return Injected string
     * @throws IOException on compilation error
     */
    public static String compile(String pageContent, Configuration config) throws IOException {
        Handlebars handlebars = new Handlebars();

        Template template = handlebars.compileInline(pageContent);
        return template.apply(config);
    }

    /**
     * Inject template with application scopes and file content
     * @param pathToLayout path to the main layout file
     * @param globalConfig global configuration
     * @param pageConfig   page configuration
     * @param fileContent  file content to inject
     * @return Injected content
     * @throws IOException in case of injection error
     */
    public static String injectLayout(
            Path pathToLayout,
            Configuration globalConfig,
            PageConfiguration pageConfig,
            String fileContent)
            throws IOException {
        FileTemplateLoader loader =
                new FileTemplateLoader(new File(String.valueOf(pathToLayout.getParent())));
        loader.setSuffix(".html");
        Handlebars handlebars = new Handlebars(loader);
        Template template = handlebars.compile("layout");

        Map<String, Object> scopes = new HashMap<>();
        scopes.put("site", globalConfig);
        scopes.put("page", pageConfig);
        scopes.put("content", fileContent);

        return template.apply(scopes);
    }
}
