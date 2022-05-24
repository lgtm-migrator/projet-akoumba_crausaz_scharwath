package ch.heigvd.dil.project;

import ch.heigvd.dil.project.commands.BuildCommand;
import ch.heigvd.dil.project.commands.CleanCommand;
import ch.heigvd.dil.project.commands.InitCommand;
import ch.heigvd.dil.project.commands.ServeCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        mixinStandardHelpOptions = true,
        name = "dil",
        description = "DIL project",
        versionProvider = ManifestVersionProvider.class,
        subcommands = {
            InitCommand.class,
            CleanCommand.class,
            BuildCommand.class,
            ServeCommand.class
        })

public class Main {
    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);

    }
}
