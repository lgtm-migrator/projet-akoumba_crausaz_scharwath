package ch.heigvd.dil.project.factories;

import com.github.jknack.handlebars.TypeSafeTemplate;

/**
 * Defines a template definition for injection Configuration
 */
public interface ConfigurationTemplate extends TypeSafeTemplate<Configuration> {

    ConfigurationTemplate setUrl(String url);

    ConfigurationTemplate setAuthor(String url);

    ConfigurationTemplate setLanguage(String language);
}
