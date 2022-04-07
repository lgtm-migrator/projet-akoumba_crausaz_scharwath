package ch.heigvd.dil.project;

import ch.heigvd.dil.project.core.FilesManager.FileBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Unit test for simple App.
 */
public class FileBuilderTest {

    @Before
    public void before() {
        File buildFolder = new File("./data/build");
        try {
            FileUtils.deleteDirectory(buildFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldBuildFile() {
        var srcFile = new File("./data/test.md");
        var destFile = new File("./data/build/test.html");
        var fileBuilder = new FileBuilder(srcFile, destFile);
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
