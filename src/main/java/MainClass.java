import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static void main(String[] args) throws IOException, ExecutionException,
            InterruptedException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<RunnerConfiguration> runners = Arrays.asList(
                mapper.readValue(new File("src/main/resources/blum_runners.yaml"),
                        RunnerConfiguration[].class));

        CLIClient cliClient = new CLIClient();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(
                executorService);

        ListenableFuture<CabinetBox> cabinetBoxFuture = listeningExecutorService.submit(
                cliClient::promptScaffoldCabinet);
        CabinetBox cabinetBox = cabinetBoxFuture.get();

        ListenableFuture<Cabinet> cabinetFuture = listeningExecutorService.submit(
                () -> cliClient.promptBuildStorage(Cabinet.scaffold(cabinetBox)));
        Cabinet cabinet = cabinetFuture.get();
        System.out.println("You created a cabinet " + cabinet);
    }
}
