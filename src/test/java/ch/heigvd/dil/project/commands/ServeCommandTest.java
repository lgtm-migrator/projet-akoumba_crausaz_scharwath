package ch.heigvd.dil.project.commands;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

/**
 * ServeCommandTest class.
 *
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class ServeCommandTest {
    private static final String TEST_FOLDER = "./website";
    private static final String[] args = new String[]{TEST_FOLDER};

    /**
     * Delete the temporary folder
     */
    @AfterEach()
    @BeforeEach()
    public void clean() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /**
     * The server should be running on localhost:8080 and answer 200 status code.
     */
    @Test
    public void shouldAnswerOk() throws IOException {
        new CommandLine(new InitCommand()).execute(args);
        new CommandLine(new BuildCommand()).execute(args);
        new CommandLine(new ServeCommand()).execute(args);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8080").build();

        try (Response response = client.newCall(request).execute()) {
            assert (response.code() == 200);
            assert (response.body() != null);
            assert (response.body().toString().length() > 0);
        }
    }

    /**
     * Command should exit with code 0 if the server can't find the build folder.
     */
    @Test
    public void shouldReturnErrorWhenNoBuildFolderFound() {
        new CommandLine(new InitCommand()).execute(args);
        assert (new CommandLine(new ServeCommand()).execute(args) == 1);
    }
}
