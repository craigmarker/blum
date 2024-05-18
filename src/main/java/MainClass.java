import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CLIClient cliClient = new CLIClient();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(
                executorService);

        ListenableFuture<CabinetBox> cabinetBoxFuture = listeningExecutorService.submit(
                cliClient::promptScaffoldCabinet);
        CabinetBox cabinetBox = cabinetBoxFuture.get();
        System.out.println("You created a cabinet box " + cabinetBox);
    }
}
