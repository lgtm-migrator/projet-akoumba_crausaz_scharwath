package ch.heigvd.dil.project;

import picocli.CommandLine;

public class ManifestVersionProvider implements CommandLine.IVersionProvider {
    static final String FALLBACK_VERSION = "0.0.0";

    static boolean isPackageVersionAvailable() {
        return ManifestVersionProvider.class.getPackage().getImplementationVersion() != null;
    }

    @Override
    public String[] getVersion() {
        String version = getClass().getPackage().getImplementationVersion();
        if (version == null) {
            version = FALLBACK_VERSION;
        }
        return new String[]{version};
    }
}
