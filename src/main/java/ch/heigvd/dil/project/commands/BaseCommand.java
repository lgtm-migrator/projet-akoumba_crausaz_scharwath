package ch.heigvd.dil.project.commands;

import ch.heigvd.dil.project.core.App;
import java.util.logging.Logger;

/**
 * This class is the base class for all commands. It used to init the root path in App setting to
 * the correct project path.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public abstract class BaseCommand implements Runnable {
    private static final Logger LOG = Logger.getLogger(BaseCommand.class.getName());

    /** The root path of the project. */
    protected abstract String getRootPath();

    /** This method is the main method of the command. */
    protected abstract void execute();

    /**
     * This method is called when the command is executed. It init the root path and call the
     * execute method.
     */
    @Override
    public final void run() {
        App.getInstance().setRootPath(getRootPath());
        try {
            this.execute();
        } catch (Exception e) {
            LOG.severe("Error while executing the command");
            throw new RuntimeException(e);
        }
    }
}
