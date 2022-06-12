package ch.heigvd.dil.project;

import picocli.CommandLine;

/**
 * Class to retrieve the version of the application
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class ManifestVersionProvider implements CommandLine.IVersionProvider {
    public static final String FALLBACK_VERSION = "0.0.0";

    /**
     * Check if the version is available in the package
     *
     * @return true if version is accessible, else false
     */
    public static boolean isPackageVersionAvailable() {
        return ManifestVersionProvider.class.getPackage().getImplementationVersion() != null;
    }

    /**
     * Get the version of the application
     *
     * @return version of the application
     */
    @Override
    public String[] getVersion() {
        String version = getClass().getPackage().getImplementationVersion();
        if (version == null) {
            version = FALLBACK_VERSION;
        }
        return new String[] {version};
    }
}
