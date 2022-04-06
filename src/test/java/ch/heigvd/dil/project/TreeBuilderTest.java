package ch.heigvd.dil.project;

import ch.heigvd.dil.project.FilesManager.TreeBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


/**
 * Unit test for simple App.
 */
public class TreeBuilderTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void myTest() throws IOException {
        var treeBuilder = new TreeBuilder(new File("./data/site/"), new File("./data/build/"));
        treeBuilder.build();
    }
}
