package ch.heigvd.dil.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ch.heigvd.dil.project.core.FilesManager.TreeBuilder;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Unit test for simple App. */
public class TreeBuilderTest {

    @Before
    @After
    public void before() {
        File buildFolder = new File("./data/build");
        try {
            FileUtils.deleteDirectory(buildFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myTest() throws IOException {
        var src = new File("./data/site/");
        var dest = new File("./data/build/");
        var treeBuilder = new TreeBuilder(src, dest);
        treeBuilder.build();
        assertTrue(dest.exists());
        assertEquals(
                FileUtils.listFilesAndDirs(
                                dest, FileFileFilter.INSTANCE, DirectoryFileFilter.INSTANCE)
                        .size(),
                FileUtils.listFilesAndDirs(
                                        src, FileFileFilter.INSTANCE, DirectoryFileFilter.INSTANCE)
                                .size()
                        - 1);
    }
}
