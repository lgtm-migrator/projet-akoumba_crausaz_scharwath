package ch.heigvd.dil.project.factories;

import com.github.jknack.handlebars.TypeSafeTemplate;

/**
 * Defines a template definition for injection Configuration
 */
public interface ConfigurationTemplate extends TypeSafeTemplate<Configuration> {

    public ConfigurationTemplate setUrl(String url);

    public ConfigurationTemplate setAuthor(String url);

    public ConfigurationTemplate setLanguage(String language);
}
