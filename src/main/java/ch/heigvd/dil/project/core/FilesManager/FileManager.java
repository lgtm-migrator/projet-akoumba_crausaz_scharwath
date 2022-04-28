package ch.heigvd.dil.project.core.FilesManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class FileManager {

    public static String parserMarkdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
        return htmlRenderer.render(document);
    }

    public static String[] parseFile(File file) {
        StringBuilder body = new StringBuilder();
        try (BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                body.append(line);
                body.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = body.toString();
        return text.split("---", 2);
    }
}
