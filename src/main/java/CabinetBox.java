import org.assertj.core.util.Preconditions;

/**
 * A <code>CabinetBox</code> the container for a storage system with three-dimensional
 * measurements: width, height, and depth. The cabinet box construction cuts are generated from the
 * provided dimensions. The cabinet box construction follows Bent's Woodworking's method.
 * Notably, a <code>CabinetBox</code> does not include any drawers, shelves, or internal storage
 * mechanisms common to cabinets. These mechanisms are added separately.
 *
 * @author Craig Marker
 * @see
 * <a href="https://www.youtube.com/watch?v=KmM6DOy0aMc&ab_channel=Bent%27sWoodworking%26Mor">Bent's Woodworking cabinet construction guide</a>
 */
public class CabinetBox {
    private final double width;
    private final double height;
    private final double depth;

    /**
     * The side panel that makes up the left and the right of a cabinet when looking at the front.
     * CabinetBox construction will require two sides of equal size
     */
    private final Cut side;

    /**
     * The back panel of the cabinet
     */
    private final Cut back;
    /**
     * The bottom panel of the cabinet
     */
    private final Cut bottom;
    /**
     * The runner <code>Cut<code> used to strengthen the construction of a cabinet
     */
    private final Cut runner;

    /**
     * Constructs a <code>CabinetBox</code> and the required cuts to build that cabinet box in
     * the real world
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
    public CabinetBox(Material sideMaterial, Material backMaterial, double width, double height,
            double depth) throws IllegalArgumentException {
        Preconditions.checkArgument(width > sideMaterial.getThickness() * 2,
                "Expected CabinetBox width greater than 2x side material thickness, %.4f, but " + "received %.4f",
                sideMaterial.getThickness() * 2, width);

        Preconditions.checkArgument(height > sideMaterial.getThickness() * 2,
                "Expected CabinetBox height greater than 2x side material thickness, %.4f, but " + "received %.4f",
                sideMaterial.getThickness() * 2, height);

        Preconditions.checkArgument(
                depth > sideMaterial.getThickness() + backMaterial.getThickness(),
                "Expected CabinetBox depth greater than side material thickness plus back " +
                        "material " + "thickness, %.4f, but received %.4f",
                sideMaterial.getThickness() + backMaterial.getThickness(), depth);

        this.width = width;
        this.height = height;
        this.depth = depth;

        this.side = Cut.withNoJoinedDimensions(height, depth, sideMaterial);
        this.bottom = Cut.withOneJoinedDimension(width,
                Joint.create(sideMaterial, Joint.JointType.DADO), depth, sideMaterial);
        this.back = Cut.withTwoJoinedDimensions(width,
                Joint.create(sideMaterial, Joint.JointType.DADO), height,
                Joint.create(sideMaterial, Joint.JointType.SINGLE_SIDE_DADO), backMaterial);
        this.runner = Cut.withOneJoinedDimension(width,
                Joint.create(sideMaterial, Joint.JointType.BUTT), 3, sideMaterial);
    }

    public Cut getSide() {
        return side;
    }

    public Cut getBack() {
        return back;
    }

    public Cut getBottom() {
        return bottom;
    }

    public Cut getRunner() {
        return runner;
    }

    @Override
    public String toString() {
        return String.format(
                "CabinetBox{dimensions=%sx%sx%s WxHxD\nside=%s\nbottom=%s\nback=%s\nrunner=%s}",
                this.width, this.height, this.depth, this.side, this.bottom, this.back,
                this.runner);
    }
}
