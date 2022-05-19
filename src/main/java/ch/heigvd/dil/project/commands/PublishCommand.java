package ch.heigvd.dil.project.commands;

import picocli.CommandLine;

@CommandLine.Command(
        name = "publish",
        description = "Publish builded files to a remove server",
        version = "1.0",
        mixinStandardHelpOptions = true)
public class PublishCommand extends BaseCommand {
    @CommandLine.Parameters(index = "0", description = "Path to the site to publish")
    String creationPath;

    @Override
    protected String getRootPath() {
        return creationPath;
    }

    @Override
    protected void execute() {

    }
}
