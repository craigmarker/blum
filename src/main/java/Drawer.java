import java.util.List;

/**
 * A storage system installed with runners that allow it to be extended and collapsed back into
 * the cabinet. Usually, drawers are used to store lighter items, since runner systems can only
 * support so much load. Drawers are not good options for tall installations, since most will not
 * be able to see the drawer contents.
 */
public class Drawer implements CabinetStorage {
    private final double width;
    private final double height;
    private final double depth;
    private final Material sideMaterial;
    private final Material bottomMaterial;

    private Drawer(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;

        this.sideMaterial = Material.HALF;
        this.bottomMaterial = Material.QUARTER;
    }

    public static Drawer construct(double width, double height, double depth) {
        return new Drawer(width, height, depth);
    }

    @Override
    public List<Cut> getCuts() {
        return List.of();
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Drawer{" + "width=" + width + ", height=" + height + ", depth=" + depth + '}';
    }
}
