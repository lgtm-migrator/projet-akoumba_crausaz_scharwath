package ch.heigvd.dil.project.core;

import java.io.File;
import java.io.IOException;

/**
 * Define an app instance
 *
 * Helps to access to the command context
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class App {
    // Singleton
    private static App instance = null;

    private File rootDir = new File("");

    private Configuration rootConfig = null;

    private App() {
    }

    /**
     * Get the instance of the app
     */
    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    /**
     * Get the root configuration of the app
     */
    public Configuration getRootConfig() {
        if (rootConfig == null) {
            try {
                rootConfig = Configuration.getFromFile(new File(getRootDir(), "config.yml"));
            } catch (IOException e) {
                System.err.println("Error while loading configuration file");
                e.printStackTrace();
                rootConfig = Configuration.defaultConfiguration();
            }
        }
        return rootConfig;
    }

    /**
     * Get the root directory of the app
     */
    public File getRootDir() {
        return rootDir;
    }

    /**
     * Set the root directory of the app
     * 
     * @param rootPath the root directory
     */
    public void setRootPath(String rootPath) {
        this.rootDir = new File(rootPath);
    }

    /**
     * Get the root directory of the app
     * @return path of the root directory
     */
    public String getRootPath() {
        return getRootDir().getAbsolutePath();
    }
}
