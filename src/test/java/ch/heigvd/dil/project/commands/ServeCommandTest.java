package ch.heigvd.dil.project.commands;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;

/**
 * ServeCommandTest class.
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class ServeCommandTest {
    private static final String TEST_FOLDER = "./website";
    private static final String[] args = new String[]{TEST_FOLDER};

    /**
     * Create a temporary folder for the tests.
     */
    @BeforeAll
    public static void initAndBuild() {
        CommandLine cmd = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        cmd.execute(args);
        cmd2.execute(args);
    }

    /**
     * Delete the temporary folder after the tests.
     */
    @AfterAll
    public static void clean() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /**
     * The server should be running on localhost:8080 and answer 200 status code.
     */
    @Test
    public void shouldAnswerOk() throws IOException {
        CommandLine cmd3 = new CommandLine(new ServeCommand());
        cmd3.execute(args);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8080").build();

        try (Response response = client.newCall(request).execute()) {
            assert (response.code() == 200);
            assert (response.body() != null);
            assert (response.body().toString().length() > 0);
        }
    }
}
