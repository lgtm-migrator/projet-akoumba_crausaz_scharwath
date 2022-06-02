package ch.heigvd.dil.project.commands;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.codehaus.plexus.util.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * ServerCommandTest class.
 * @author Maxime Scharwath
 * @author Nicolas Crausaz
 * @author Ludivine Akoumba
 */
public class ServerCommandTest {
    static final String TEST_FOLDER = "./website";

    private static final String[] args = new String[]{TEST_FOLDER};

    /**
     * Create a temporary folder for the tests.
     */
    @BeforeAll
    static void initAndBuild() {
        CommandLine cmd1 = new CommandLine(new InitCommand());
        CommandLine cmd2 = new CommandLine(new BuildCommand());
        cmd1.execute(args);
        cmd2.execute(args);
    }

    /**
     * Delete the temporary folder after the tests.
     */
    @AfterAll
    static void clean() throws IOException {
        FileUtils.deleteDirectory(new File(TEST_FOLDER));
    }

    /**
     * Should answer the GET request with a 200 status code.
     */
    @Test
    public void shouldAnswerOK() throws IOException {
        CommandLine cmd = new CommandLine(new ServeCommand());
        cmd.execute(args);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("http://localhost:8080").build();

        try (Response response = client.newCall(request).execute()) {
            assert (response.code() == 200);
            assert (Objects.requireNonNull(response.body()).toString().length() > 0);
        }
    }
}
