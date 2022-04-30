package ch.heigvd.dil.project.factories;

import ch.heigvd.dil.project.core.Configuration;

public class SiteStructureFactory {
    public Configuration generateBaseConfiguration() {
        return new Configuration("localhost", "Nicolas Crausaz", "fr");
    }
}
