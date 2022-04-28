package ch.heigvd.dil.project;

import static ch.heigvd.dil.project.core.FilesManager.FileManager.parserMarkdownToHtml;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for simple App. */
public class FileManagerTest {
    /** Rigorous Test :-) */
    @Test
    public void shouldReturnHtmlObject() {
        String[][] tests = {
            {"A\\_B\\_C", "<p>A_B_C</p>\n"},
            {"_A\\_B\\_C_", "<p><em>A_B_C</em></p>\n"},
            {"A_B\\_C", "<p>A_B_C</p>\n"},
            {"A\\_B_C", "<p>A_B_C</p>\n"},
            {"\\__AB\\__", "<p>_<em>AB_</em></p>\n"},
            {"\\\\_AB\\_\\\\_", "<p>\\<em>AB_\\</em></p>\n"},
            {"A\\*B\\*C", "<p>A*B*C</p>\n"},
            {"*A\\*B\\*C*", "<p><em>A*B*C</em></p>\n"},
            {"A*B\\*C", "<p>A*B*C</p>\n"},
            {"A*B*C", "<p>A<em>B</em>C</p>\n"},
            {"\\**AB\\**", "<p>*<em>AB*</em></p>\n"},
            {"\\\\*AB\\*\\\\*", "<p>\\<em>AB*\\</em></p>\n"},
            {"\\a\\ b\\*c\\d\\_e", "<p>\\a\\ b*c\\d_e</p>\n"},
            {"\\#1", "<p>#1</p>\n"},
            {"\\#\\# 2", "<p>## 2</p>\n"},
            {"works \\#when not required too", "<p>works #when not required too</p>\n"},
            {"\\", "<p>\\</p>\n"},
            {"\\\\", "<p>\\</p>\n"},
            {"\\\\\\", "<p>\\\\</p>\n"}
        };
        for (String[] testCase : tests) {
            Assert.assertEquals(testCase[1], parserMarkdownToHtml(testCase[0]));
        }
    }
}
