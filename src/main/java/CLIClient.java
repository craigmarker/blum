import java.util.Scanner;

public class CLIClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How wide is your cabinet?");
        String cabinetWidth = scanner.nextLine();

        System.out.println("How tall is your cabinet?");
        String cabinetHeight = scanner.nextLine();

        System.out.println("How deep is your cabinet?");
        String cabinetDepth = scanner.nextLine();

        Cabinet cabinet = new Cabinet(
                Material.THREE_QUARTER,
                Material.QUARTER,
                Double.parseDouble(cabinetWidth),
                Double.parseDouble(cabinetHeight),
                Double.parseDouble(cabinetDepth)
        );

        System.out.println("You created a cabinet: " + cabinet);
    }
}

// Cabinet width
// Cabinet box material getThickness
// Drawer material getThickness
// Drawer construction type (butt joint/other)
