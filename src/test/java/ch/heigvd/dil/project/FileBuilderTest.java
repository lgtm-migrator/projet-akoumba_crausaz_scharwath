package ch.heigvd.dil.project;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import ch.heigvd.dil.project.core.App;
import ch.heigvd.dil.project.core.FilesManager.FileBuilder;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test class for the FileBuilder class.
 *
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class FileBuilderTest {

    /** Delete the temporary folder after and before the tests. */
    @BeforeAll
    @AfterAll
    static void clean() {
        File buildFolder = new File("./data/site/build");
        try {
            FileUtils.deleteDirectory(buildFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Should build a file */
    @Test
    public void shouldBuildFile() {
        var srcFile = new File("./data/site/index.md");
        var destFile = new File("./data/site/build/index.html");
        var fileBuilder = new FileBuilder(srcFile, destFile);

        App.getInstance().setRootPath("data/site");

        try {
            fileBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Should not throw IOException");
        }

        assertTrue(destFile.exists());
        assertTrue(destFile.length() > 0);
    }
}
