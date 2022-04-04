package ch.heigvd.dil.project;

import ch.heigvd.dil.project.commands.BuildCommand;
import ch.heigvd.dil.project.commands.CleanCommand;
import ch.heigvd.dil.project.commands.NewCommand;
import ch.heigvd.dil.project.commands.ServeCommand;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/** Main for picocli */
@Command(
        mixinStandardHelpOptions = true,
        name = "dil",
        description = "DIL project",
        versionProvider = ManifestVersionProvider.class,
        subcommands = {
            NewCommand.class,
            CleanCommand.class,
            BuildCommand.class,
            ServeCommand.class
        })
public class Main implements Callable<Integer> {

    public static void main(String[] args) {
        
            
            System.exit(new CommandLine(new Main()).execute(args));
    }

    @Override
    public Integer call() {return 0;
    }
}
