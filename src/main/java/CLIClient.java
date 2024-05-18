import java.util.Scanner;

/**
 * Class for constructing a cabinet with user command line input
 */
public class CLIClient {

    private final Scanner scanner;

    public CLIClient() {
        scanner = new Scanner(System.in);
    }

    /**
     * Uses user input for cabinet dimensions to construct a <code>CabinetBox</code>. This
     * <code>CabinetBox</code> can then be filled with various storage mechanisms like shelves
     * and drawers
     *
     * @return <code>CabinetBox</code> with user-provided dimensions
     */
    public CabinetBox promptScaffoldCabinet() {
        System.out.println("How wide is your cabinet?");
        String cabinetWidth = scanner.nextLine();

        System.out.println("How tall is your cabinet?");
        String cabinetHeight = scanner.nextLine();

        System.out.println("How deep is your cabinet?");
        String cabinetDepth = scanner.nextLine();

        return new CabinetBox(Material.THREE_QUARTER, Material.QUARTER,
                Double.parseDouble(cabinetWidth), Double.parseDouble(cabinetHeight),
                Double.parseDouble(cabinetDepth));
    }
}