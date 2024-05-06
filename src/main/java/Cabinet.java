public class Cabinet {
    private final Material sideMaterial;
    private final Material backMaterial;
    private final double height;
    private final double width;
    private final double depth;


    public Cabinet(Material sideMaterial, Material backMaterial, double height, double width, double depth) {
        this.sideMaterial = sideMaterial;
        this.backMaterial = backMaterial;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "side material=" + sideMaterial +
                ", back material=" + backMaterial +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }
}
