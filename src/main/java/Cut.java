import java.util.Objects;

/**
 * A <code>Cut</code> is a representation of work done in woodworking to make a material piece
 * smaller. For example, cutting down a sheet of plywood into panels that can be joined together
 * to create a cabinet
 *
 * @author Craig Marker
 */
public class Cut {
    private final Dimensions dimensions;
    private final Material material;

    /**
     * Creates a basic <code>Cut</code>
     *
     * @param firstDimension  The first dimension measurement
     * @param secondDimension The second dimension measurement
     * @param material        The material to be used in the <code>Cut</code>
     * @return a <code>Cut</code>
     */
    private Cut(double firstDimension, double secondDimension, Material material) {
        this.dimensions = Dimensions.valueOf(firstDimension, secondDimension);
        this.material = material;
    }

    /**
     * Creates a <code>Cut</code> whose dimensions are not joined with another piece of wood
     *
     * @param firstDimension  The first dimension measurement
     * @param secondDimension The second dimension measurement
     * @param material        The material to be used in the <code>Cut</code>
     * @return a <code>Cut</code>
     */
    public static Cut withNoJoinedDimensions(double firstDimension, double secondDimension,
            Material material) {
        return new Cut(firstDimension, secondDimension, material);
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
     * @return a <code>Cut</code> that has factored all joints in the final measurements
     */
    public static Cut withOneJoinedDimension(double joinedDimension, Joint joint,
            double unJoinedDimension, Material material) {
        return new Cut(joinedDimension - joint.getJoinedDimensionOffset(), unJoinedDimension,
                material);
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
     * @return a <code>Cut</code> that has factored all joints in the final measurements
     */
    public static Cut withTwoJoinedDimensions(double firstDimension, Joint firstDimensionJoint,
            double secondDimension, Joint secondDimensionJoint, Material material) {

        return new Cut(firstDimension - firstDimensionJoint.getJoinedDimensionOffset(),
                secondDimension - secondDimensionJoint.getJoinedDimensionOffset(), material);
    }

    public Material getMaterial() {
        return material;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return "Cut{ dimensions=" + dimensions + ", material=" + material + '}';
    }

    /**
     * Object representation of two dimensions, for example width x height
     */
    static class Dimensions {
        private final double first;
        private final double second;

        /**
         * Creates a Dimensions object. The measurements are interchangeable. For instance,
         * first=4.0 and second=3.0 is the same as first=3.0 and second=4.0
         *
         * @param first  the first measurement
         * @param second the second measurement
         */
        private Dimensions(double first, double second) {
            this.first = first;
            this.second = second;
        }

        /**
         * Creates a Dimensions object. The measurements are interchangeable. For instance,
         * first=4.0 and second=3.0 is the same as first=3.0 and second=4.0
         *
         * @param first  the first measurement
         * @param second the second measurement
         * @return A <code>Dimensions</code> object with <code>first</code> and
         * <code>second</code> as its measurements
         */
        public static Dimensions valueOf(double first, double second) {
            return new Dimensions(first, second);

        }

        /**
         * Overrides Object equals such that provided measurement order is interchangeable. For
         * example, <code>Dimensions(4.0. 3.0).equals(Dimensions(3.0, 4.0)</code>
         *
         * @param o the Dimensions object being compared to
         * @return true if Dimensions are logically equivalent
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Dimensions)) return false;

            Dimensions that = (Dimensions) o;
            return Double.compare(first, that.first) == 0 && Double.compare(second,
                    that.second) == 0 || Double.compare(first, that.second) == 0 && Double.compare(
                    second, that.first) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "Dimensions{" + first + "x" + second + '}';
        }
    }
}
