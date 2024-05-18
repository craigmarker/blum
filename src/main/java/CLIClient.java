import java.io.IOException;
import java.util.Scanner;

public class CLIClient {

    public static void main(String[] args) throws IOException {
        /** Reading RunnerConfiguration and printing, TODO add back and use for drawer construction
         ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
         List<RunnerConfiguration> runners = Arrays.asList(
         mapper.readValue(new File("src/main/resources/blum_runners.yaml"),
         RunnerConfiguration[].class));
         System.out.println(runners);
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("How wide is your cabinet?");
        String cabinetWidth = scanner.nextLine();

        System.out.println("How tall is your cabinet?");
        String cabinetHeight = scanner.nextLine();

        System.out.println("How deep is your cabinet?");
        String cabinetDepth = scanner.nextLine();

        CabinetBox cabinetBox = new CabinetBox(Material.THREE_QUARTER, Material.QUARTER,
                Double.parseDouble(cabinetWidth), Double.parseDouble(cabinetHeight),
                Double.parseDouble(cabinetDepth));

        System.out.println("You created a cabinet box: " + cabinetBox);
    }
}

// Cabinet width
// Cabinet box material getThickness
// Drawer material getThickness
// Drawer construction type (butt joint/other)
