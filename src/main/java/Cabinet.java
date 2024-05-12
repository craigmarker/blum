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
    private final double width;
    private final double height;
    private final double depth;

    /**
     * The side panel that makes up the left and the right of a cabinet when looking at the front.
     * Cabinet construction will require two sides of equal size
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
        this.width = width;
        this.height = height;
        this.depth = depth;

        this.side = new Cut(height, depth, sideMaterial);
        this.bottom = Cut.withOneJoinedDimension(width,
                new Joint(sideMaterial, Joint.JointType.DADO), depth, sideMaterial);
        this.back = Cut.withTwoJoinedDimensions(width,
                new Joint(sideMaterial, Joint.JointType.DADO), height,
                new Joint(sideMaterial, Joint.JointType.SINGLE_SIDE_DADO), backMaterial);
        this.runner = Cut.withOneJoinedDimension(width,
                new Joint(sideMaterial, Joint.JointType.BUTT), 3, sideMaterial);
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
                "Cabinet{dimensions=%sx%sx%s WxHxD\nside=%s\nbottom=%s\nback=%s\nrunner=%s}",
                this.width, this.height, this.depth, this.side, this.bottom, this.back,
                this.runner);
    }
}
