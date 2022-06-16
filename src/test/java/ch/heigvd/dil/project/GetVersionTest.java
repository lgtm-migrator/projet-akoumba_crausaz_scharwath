package ch.heigvd.dil.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for Version Provider.
 *
 * @author Akoumba Ludivine
 * @author Crausaz Nicolas
 * @author Scharwath Maxime
 */
public class GetVersionTest {
    /** Should return the version of the project. */
    @Test
    public void shouldGetAVersionArray() {
        ManifestVersionProvider provider = new ManifestVersionProvider();
        assertTrue(provider.getVersion().length > 0);
    }

    /** Should return the version of the project as a string. */
    @Test
    public void shouldGetAVersionString() {
        ManifestVersionProvider provider = new ManifestVersionProvider();
        assertNotNull(provider.getVersion()[0]);
    }

    /** Should return the version same as FallbackVersion */
    @Test
    public void shouldGetTheSameVersion() {
        ManifestVersionProvider provider = new ManifestVersionProvider();
        String[] version = provider.getVersion();
        if (!ManifestVersionProvider.isPackageVersionAvailable()) {
            assertEquals(version[0], ManifestVersionProvider.FALLBACK_VERSION);
        }
    }
}
