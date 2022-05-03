package ch.heigvd.dil.project;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import ch.heigvd.dil.project.core.App;
import ch.heigvd.dil.project.core.FilesManager.FileBuilder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class FileBuilderTest {

    @Before
    public void before() {
        File buildFolder = new File("./data/site/build");
        try {
            FileUtils.deleteDirectory(buildFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
