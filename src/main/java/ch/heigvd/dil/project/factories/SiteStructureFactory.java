package ch.heigvd.dil.project.factories;

public class SiteStructureFactory {
    public Configuration generateBaseConfiguration() {
        return new Configuration("Nicolas Crausaz", "localhost", "fr");
    }
}
