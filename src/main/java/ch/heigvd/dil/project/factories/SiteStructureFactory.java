package ch.heigvd.dil.project.factories;

public class SiteStructureFactory {
    public Configuration generateBaseConfiguration() {
        return new Configuration("localhost", "Nicolas Crausaz", "fr");
    }
}
