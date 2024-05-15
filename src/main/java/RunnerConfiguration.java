import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of configuration for building drawers and cabinets with a particular runner model.
 *
 * @author Craig Marker
 * @see
 * <a href="https://static.richelieu.com/documents/docsGr/119/652/9/1196529/1400703.pdf?_gl=1*1bkmt6v*_ga*NTI5MzQ4MjM3LjE3MTU4MTIyNDI.*_ga_DYF9GSYHN9*MTcxNTgxMjI0Mi4xLjAuMTcxNTgxMjI0Mi42MC4wLjY5MTM3NTM3">Example blum drawer installation specifications</a>
 */
public class RunnerConfiguration {
    private final String sku;
    private final int maxLoad;
    private final double minDrawerSideThickness;
    private final double maxDrawerSideThickness;
    private final int drawerLength;
    private final double minCabinetDepth;
    private final double minTopClearance;
    private final double bottomClearance;
    private final double interiorOffset;

    /**
     * @param sku                    The product ID/sku (stock keeping unit) for the runner model
     * @param maxLoad                Max static load (in pounds) the runners can support
     * @param minDrawerSideThickness Minimum drawer side material thickness {@link Material}
     *                               supported by the runner
     * @param maxDrawerSideThickness Maximum drawer side material thickness (@link Material)
     *                               supported by the runner
     * @param drawerLength           Drawer length supported by the runner. For instance, a
     *                               full-extension 18" runner will support an 18" drawer
     * @param minCabinetDepth        The minimum cabinet depth supported by this runner. For
     *                               example, an 18" runner will not fit a 17" drawer
     * @param minTopClearance        The required space between the top of the drawer and the
     *                               bottom of the next drawer or top of the cabinet
     * @param bottomClearance        Required clearance between bottom of the drawer and top of
     *                               another drawer or bottom of the cabinet
     * @param interiorOffset         Measurement between interior of cabinet and interior of
     *                               drawer box required for runner
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    private RunnerConfiguration(@JsonProperty("sku") String sku,
            @JsonProperty("max_load") int maxLoad,
            @JsonProperty("min_drawer_side_thickness") double minDrawerSideThickness,
            @JsonProperty("max_drawer_side_thickness") double maxDrawerSideThickness,
            @JsonProperty("drawer_length") int drawerLength,
            @JsonProperty("min_cabinet_depth") double minCabinetDepth, @JsonProperty(
                    "min_top_clearance") double minTopClearance,
            @JsonProperty("bottom_clearance") double bottomClearance, @JsonProperty(
                    "interior_offset") double interiorOffset) {
        this.sku = sku;
        this.maxLoad = maxLoad;
        this.minDrawerSideThickness = minDrawerSideThickness;
        this.maxDrawerSideThickness = maxDrawerSideThickness;
        this.drawerLength = drawerLength;
        this.minCabinetDepth = minCabinetDepth;
        this.minTopClearance = minTopClearance;
        this.bottomClearance = bottomClearance;
        this.interiorOffset = interiorOffset;
    }

    public String getSku() {
        return sku;
    }


    public int getMaxLoad() {
        return maxLoad;
    }


    public double getMinDrawerSideThickness() {
        return minDrawerSideThickness;
    }


    public double getMaxDrawerSideThickness() {
        return maxDrawerSideThickness;
    }


    public int getDrawerLength() {
        return drawerLength;
    }


    public double getMinCabinetDepth() {
        return minCabinetDepth;
    }

    public double getMinTopClearance() {
        return minTopClearance;
    }


    public double getBottomClearance() {
        return bottomClearance;
    }


    public double getInteriorOffset() {
        return interiorOffset;
    }


    @Override
    public String toString() {
        return "RunnerConfiguration{" + "sku='" + sku + '\'' + ", maxLoad=" + maxLoad + ", " +
                "minDrawerSideThickness=" + minDrawerSideThickness + ", maxDrawerSideThickness=" + maxDrawerSideThickness + ", drawerLength=" + drawerLength + ", minCabinetDepth=" + minCabinetDepth + ", minTopClearance=" + minTopClearance + ", bottomClearance=" + bottomClearance + ", interiorOffset=" + interiorOffset + '}';
    }
}
