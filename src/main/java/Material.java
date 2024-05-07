/**
 * Woodworking material, for example 3/4" plywood, that is used in construction of woodworking
 * projects
 *
 * @author Craig Marker
 */
public enum Material {
    /**
     * 1/4" thick material (usually plywood)
     */
    QUARTER(0.25),

    /**
     * 1/2" thick material
     */
    HALF(0.5),

    /**
     * 3/4" thick material
     */
    THREE_QUARTER(0.75);

    private final double thickness;

    /**
     * Constructs a new <code>Material</code> type
     *
     * @param thickness the actual thickness of the material, for example 3/4" plywood has a
     *                  thickness of 0.75. A framing 2x4 has 1.75 thickness because the "2" in
     *                  2x4 is a nominal thickness
     */
    Material(double thickness) {
        this.thickness = thickness;
    }

    public double getThickness() {
        return this.thickness;
    }

    @Override
    public String toString() {
        return "Material{" + this.name() + '}';
    }
}
