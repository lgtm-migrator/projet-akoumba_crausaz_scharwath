package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.App;
import java.util.logging.Logger;

public abstract class BaseCommand implements Runnable {
    private static final Logger LOG = Logger.getLogger(BaseCommand.class.getName());

    public void run(String rootPath) {
        App.getInstance().setRootPath(rootPath);
    }
}
