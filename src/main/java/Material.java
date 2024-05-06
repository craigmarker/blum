public enum Material {
    QUARTER(0.25), HALF(0.5), THREE_QUARTER(0.75);

    private final double thickness;

    Material(double thickness) {
        this.thickness = thickness;
    }

    public double thickness() {
        return this.thickness;
    }

    @Override
    public String toString() {
        return "Material{" +
                "thickness=" + thickness +
                '}';
    }
}
