/**
 * A <code>Joint</code> is the method for putting two pieces of wood together. Joints impact the
 * strength of construction in addition to the cut measurements required to build a final product
 * with particular dimensions.
 *
 * @author Craig Marker
 * @see
 * <a href="https://www.thesprucecrafts.com/wood-joinery-types-3536631">13 Types of Wood Joinery</a>
 */
public class Joint {

    private final Material materialJoinedTo;
    private final JointType type;

    /**
     * Construct a new <code>Joint</code>
     *
     * @param materialJoinedTo The <code>Material</code> that is joined to. This material's
     *                         thickness contributes to the cut measurement that will be made for
     *                         this joint
     * @param type             The <code>JointType</code> used to connect a workpiece to the
     *                         <code>materialJoinedTo</code>
     */
    public Joint(Material materialJoinedTo, JointType type) {
        this.materialJoinedTo = materialJoinedTo;
        this.type = type;
    }

    /**
     * Joinery requires consideration of material thickness in order for the final construction
     * to meet the desired measurement requirements. For example, given a piece of wood joined to
     * another piece of wood in an L (<code>JointType.BUTT</code>), the thickness of the | must
     * be factored in when cutting the _, such that the measurement from the outside of the | to
     * the end of the _ equals the desired measurement
     *
     * @return the offset to apply to the final, jointed measurement to account for material
     * thickness during construction
     */
    public double getJoinedDimensionOffset() {
        return this.materialJoinedTo.getThickness() * this.type.getOuterMaterialMultiplier();
    }

    /**
     * The supported joinery methods for cabinet construction
     *
     * @see
     * <a href="https://www.thesprucecrafts.com/wood-joinery-types-3536631">13 Types of Wood Joinery</a>
     */
    public enum JointType {
        /**
         * a butt joint is the connection of two pieces of wood, often at a right angle, where
         * the two pieces are secured with mechanical fasteners. This is common in construction
         * framing.
         */
        BUTT(2),

        /**
         * a Dado joint is square-grooved slot on one board where another board fits
         */
        DADO(1),

        /**
         * a single-sided Dado is the same joinery method as {@link #DADO} where only one side of
         * the wood is joined via a Dado. The other side has not joint
         */
        SINGLE_SIDE_DADO(0.5);

        private final double outerMaterialMultiplier;

        /**
         * @param outerMaterialMultiplier the factor to multiply the outer material by to
         *                                determine how much to remove from the <i>inner</i>
         *                                material measurement. For example, if the inner
         *                                material overlaps one half of the outer material, the
         *                                multiplier would be 0.5. If this same overlap applies
         *                                to both sides of the joint, the multiplier would be 1.
         */
        JointType(double outerMaterialMultiplier) {
            this.outerMaterialMultiplier = outerMaterialMultiplier;
        }

        public double getOuterMaterialMultiplier() {
            return this.outerMaterialMultiplier;
        }
    }
}
