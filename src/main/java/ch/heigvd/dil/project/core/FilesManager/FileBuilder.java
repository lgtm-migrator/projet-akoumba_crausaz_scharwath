package ch.heigvd.dil.project.core.FilesManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/** Class used to build the files */
public class FileBuilder {
    private final File fileSource;
    private final File fileDestination;

    private String bodyContent = "";
    private String headerContent = "";
    private boolean isCompiled = false;

    public FileBuilder(File fileSource, File fileDestination) {
        this.fileSource = fileSource;
        this.fileDestination = fileDestination;
    }

    private void parseYaml(String yaml) throws JsonProcessingException {
        var mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        var headerBuilder = mapper.readValue(yaml, HeaderBuilder.class);
        headerContent = headerBuilder.build();
    }

    private void parseMarkdown(String markdown) {
        markdown = markdown.replaceAll(".md", ".html");
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
        bodyContent = htmlRenderer.render(document);
    }

    public void compile() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileSource));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }
        br.close();
        String[] parts = sb.toString().split("---", 2);
        if (parts.length != 2) {
            throw new IOException("File is not well formatted");
        }
        parseYaml(parts[0]);
        parseMarkdown(parts[1]);
        isCompiled = true;
    }

    /**
     * Compile and write html file to fileDestination
     *
     * @throws IOException if the file cannot be written
     */
    public void build() throws IOException {
        if (!isCompiled) {
            compile();
        }
        var build =
                String.format(
                        "<!DOCTYPE html>\n"
                                + "<html lang=\"en\">\n"
                                + // TODO Get language from config
                                "<head>\n%s\n</head>\n"
                                + "<body>\n%s\n</body>\n"
                                + "</html>",
                        headerContent, bodyContent);
        FileUtils.createParentDirectories(fileDestination);
        var writer = new FileWriter(fileDestination);
        writer.write(build);
        writer.close();
    }
}
