import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A <code>Cabinet</code> is a storage system with three-dimensional measurements: width, height,
 * and depth. The real cabinet construction is generated from the provided dimensions. The
 * cabinet construction follows Bent's Woodworking's method.
 *
 * @author Craig Marker
 * @see
 * <a href="https://www.youtube.com/watch?v=KmM6DOy0aMc&ab_channel=Bent%27sWoodworking%26Mor">Bent's Woodworking cabinet construction guide</a>
 */
public class Cabinet {
    private final Material sideMaterial;
    private final Material backMaterial;
    private final double width;
    private final double height;
    private final double depth;

    /**
     * The panel <code>Cut<code>s required to construct the outside of a cabinet. For example,
     * the bottom, two sides, and back panel. The construction method assumes the cabinets do not
     * need a top, since the top of the cabinet will be covered by some other material, for
     * example, a countertop.
     */
    private final Cut[] panels;

    /**
     * The runners <code>Cut<code>s required to strengthen the construction of a cabinet. These
     * are thin strips that support the joined panels
     */
    private final Cut[] runners;

    /**
     * Constructs a <code>Cabinet</code> and the required cuts to build that cabinet in the real
     * world
     *
     * @param sideMaterial The <code>Material</code> that will be used to create the cabinet
     *                     sides <i>and</i> runners
     * @param backMaterial The <code>Material</code> that will be used to create the cabinet back
     * @param width        The width of the cabinet, measured when looking at the cabinet front
     *                     from the outside of the left side to the outside of the right side
     * @param height       The height of the cabinet, measured when looking at the cabinet front
     *                     from the outside of the bottom to the outside of the top
     * @param depth        The depth of the cabinet, measured when looking at the <i>side</i> of
     *                     the cabinet from the outside of the back of the cabinet to the outside
     *                     of the front of the cabinet
     */
    public Cabinet(Material sideMaterial, Material backMaterial, double width, double height,
                   double depth) {
        this.sideMaterial = sideMaterial;
        this.backMaterial = backMaterial;
        this.width = width;
        this.height = height;
        this.depth = depth;

        Cut side = new Cut(height, depth, sideMaterial, "side");
        Cut bottom = Cut.withOneJoinedDimension(width, new Joint(sideMaterial,
                Joint.JointType.DADO), depth, sideMaterial, "bottom");
        Cut back = Cut.withTwoJoinedDimensions(width, new Joint(sideMaterial,
                Joint.JointType.DADO), height, new Joint(sideMaterial,
                Joint.JointType.SINGLE_SIDE_DADO), backMaterial, "back");
        this.panels = new Cut[]{side, side, bottom, back};

        Cut runner = Cut.withOneJoinedDimension(width, new Joint(sideMaterial,
                Joint.JointType.BUTT), 3, sideMaterial, "runner");
        this.runners = new Cut[]{runner, runner, runner, runner};
    }

    @Override
    public String toString() {
        return "Cabinet{" + "dimensions=" + this.width + "x" + this.height + "x" + this.depth +
                ", sideMaterial=" + sideMaterial + ", " + "backMaterial=" + backMaterial + ", " + "panels=" + Arrays.stream(panels).map(Cut::toString).collect(Collectors.joining(", ")) + ", runners" + "=" + Arrays.stream(runners).map(Cut::toString).collect(Collectors.joining(", ")) + '}';
    }
}
