package ch.heigvd.dil.project.core;


import java.io.File;
import java.io.IOException;

//TODO add the argument to relative path to cmd path
public class App {
    //singleton
    private static App instance = null;

    private App(){}

    public static App getInstance(){
        if(instance == null){
            instance = new App();
        }
        return instance;
    }

    private Configuration rootConfig = null;

    public Configuration getRootConfig() {
        if(rootConfig == null){
            try {
                rootConfig = Configuration.getFromFile(new File(getRootDir(), "config.yml"));
            } catch (IOException e) {
                rootConfig = Configuration.defaultConfiguration();
            }
        }
        return rootConfig;
    }

    public File getRootDir(){
        return new File("");
    }

    public String getRootPath(){
        return getRootDir().getAbsolutePath();
    }
}