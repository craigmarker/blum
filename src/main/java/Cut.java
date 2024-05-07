/**
 * A <code>Cut</code> is a representation of work done in woodworking to make a material piece
 * smaller. For example, cutting down a sheet of plywood into panels that can be joined together
 * to create a cabinet
 *
 * @author Craig Marker
 */
public class Cut {
    private final double firstDimension;
    private final double secondDimension;
    private final Material material;
    private final String name;

    /**
     * Creates a basic <code>Cut</code>
     *
     * @param firstDimension  The first dimension measurement
     * @param secondDimension The second dimension measurement
     * @param material        The material to be used in the <code>Cut</code>
     * @param name            The name of the <code>Cut</code>. This can help organize work
     *                        when there are multiple <code>Cut</code>s
     * @return a <code>Cut</code>
     */
    public Cut(double firstDimension, double secondDimension, Material material, String name) {
        this.firstDimension = firstDimension;
        this.secondDimension = secondDimension;
        this.material = material;
        this.name = name;
    }

    /**
     * Creates a <code>Cut</code> that includes one dimension that is joined to another piece of
     * wood and one dimension that is <i>not</i> joined to another piece of wood. For example, a
     * cabinet bottom is joined to a cabinet side along its width dimension, but has no joint
     * along its depth dimension.
     *
     * @param joinedDimension   The joined dimension measurement. This measurement should
     *                          <i>not</i> account for any measurement offset by the joint.
     * @param joint             The <code>Joint</code> that is used to connect the joined
     *                          dimension to the other piece of wood. This <code>Joint</code>
     *                          specification is leveraged to offset the
     *                          <code>joinedDimension</code> and produce the final cut to make
     * @param unJoinedDimension The unjoined dimension measurement. This will be returned as is
     *                          in the final <code>Cut</code> specification
     * @param material          The material to be used in the <code>Cut</code>
     * @param name              The name of the <code>Cut</code>. This can help organize work
     *                          when there are multiple <code>Cut</code>s
     * @return a <code>Cut</code> that has factored all joints in the final measurements
     */
    public static Cut withOneJoinedDimension(double joinedDimension, Joint joint,
                                             double unJoinedDimension, Material material,
                                             String name) {
        return new Cut(
                joinedDimension - joint.getJoinedDimensionOffset(),
                unJoinedDimension,
                material,
                name
        );
    }

    /**
     * Creates a <code>Cut</code> where both dimensions are joined to another piece of wood. For
     * example, a cabinet back is joined to a cabinet side along its width dimension <i>and</i> a
     * cabinet bottom along its height dimension.
     *
     * @param firstDimension       The first measurement of the cut. This measurement should
     *                             <i>not</i> account for any measurement offset by the joint.
     * @param firstDimensionJoint  The <code>Joint</code> that is used to connect the
     *                             <code>firstDimension</code>
     *                             to the other piece of wood. This <code>Joint</code>
     *                             specification is leveraged to offset the
     *                             <code>firstDimension</code> and produce the final
     *                             <code>Cut</code> measurement
     * @param secondDimension      The second dimension of the cut. This measurement should
     *                             <i>not</i> account for any measurement offset by the joint.
     * @param secondDimensionJoint The <code>Joint</code> that is used to connect the
     *                             <code>secondDimension</code>
     *                             to the other piece of wood. This <code>Joint</code>
     *                             specification is leveraged to offset the
     *                             <code>secondDimension</code> and produce the final
     *                             <code>Cut</code> measurement
     * @param material             The material to be used in the <code>Cut</code>
     * @param name                 The name of the <code>Cut</code>. This can help organize work
     *                             when there are multiple <code>Cut</code>s
     * @return a <code>Cut</code> that has factored all joints in the final measurements
     */
    public static Cut withTwoJoinedDimensions(double firstDimension, Joint firstDimensionJoint,
                                              double secondDimension, Joint secondDimensionJoint,
                                              Material material, String name) {

        return new Cut(
                firstDimension - firstDimensionJoint.getJoinedDimensionOffset(),
                secondDimension - secondDimensionJoint.getJoinedDimensionOffset(),
                material,
                name
        );
    }

    @Override
    public String toString() {
        return "Cut{" + "name=" + name + ",  dimensions=" + firstDimension + "x" + secondDimension + ", material=" + material + '}';
    }
}
