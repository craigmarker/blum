import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class CabinetBoxTest implements WithAssertions {

    @Nested
    class LargeCabinetBoxTest {
        private CabinetBox largeCabinetBox;

        @BeforeEach
        void setUp() {
            this.largeCabinetBox = new CabinetBox(Material.THREE_QUARTER, Material.QUARTER, 24,
                    30.5, 18);
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(largeCabinetBox.getRunner().getMaterial()).isEqualTo(Material.THREE_QUARTER);
        }

        @Test
        void testRunnerSizeUsesCabinetWidth() {
            assertThat(largeCabinetBox.getRunner().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(22.5, 3));
        }

        @Test
        void testSideSizeEqualToCabinetHeightDepth() {
            assertThat(largeCabinetBox.getSide().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(30.5, 18));
        }

        @Test
        void testBackSizeUsesCabinetHeightWidth() {
            assertThat(largeCabinetBox.getBack().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(30.125, 23.25));
        }

        @Test
        void testBottomSizeUsesCabinetWidthDepth() {
            assertThat(largeCabinetBox.getBottom().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(18, 23.25));
        }

        @Nested
        class CabinetBoxToStringTest {
            @Test
            void testToStringFormatsDimensions() {
                assertThat(largeCabinetBox.toString()).contains("24.0x30.5x18.0 WxHxD");
            }

            // The toString value for panels is delegated to Cut, so testing that the panel instance
            // variables are include in the toString but not testing the value
            @Test
            void testToStringIncludesSidePanel() {
                assertThat(largeCabinetBox.toString()).contains("side=");
            }

            @Test
            void testToStringIncludesBackPanel() {
                assertThat(largeCabinetBox.toString()).contains("back=");
            }

            @Test
            void testToStringIncludesBottomPanel() {
                assertThat(largeCabinetBox.toString()).contains("bottom=");
            }

            @Test
            void testToStringIncludesRunner() {
                assertThat(largeCabinetBox.toString()).contains("runner=");
            }
        }

    }

    @Nested
    class SmallCabinetBoxTest {
        private CabinetBox smallCabinetBox;

        @BeforeEach
        void setUp() {
            this.smallCabinetBox = new CabinetBox(Material.THREE_QUARTER, Material.QUARTER, 6, 6,
                    10);
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(smallCabinetBox.getRunner().getMaterial()).isEqualTo(Material.THREE_QUARTER);
        }

        @Test
        void testRunnerSizeUsesCabinetWidth() {
            assertThat(smallCabinetBox.getRunner().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(4.5, 3));
        }

        @Test
        void testSideSizeEqualToCabinetHeightDepth() {
            assertThat(smallCabinetBox.getSide().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(6, 10));
        }

        @Test
        void testBackSizeUsesCabinetHeightWidth() {
            assertThat(smallCabinetBox.getBack().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(5.25, 5.625));
        }

        @Test
        void testBottomSizeUsesCabinetWidthDepth() {
            assertThat(smallCabinetBox.getBottom().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(5.25, 10));
        }
    }

    @Nested
    class HalfInchCabinetBoxTest {
        private CabinetBox halfInchCabinetBox;

        @BeforeEach
        void setUp() {
            this.halfInchCabinetBox = new CabinetBox(Material.HALF, Material.HALF, 10, 10.5, 20);
        }


        @Test
        void testRunnerSizeUsesCabinetWidth() {
            assertThat(this.halfInchCabinetBox.getRunner().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(9, 3));
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(this.halfInchCabinetBox.getRunner().getMaterial()).isEqualTo(Material.HALF);
        }

        @Test
        void testSideSizeEqualToCabinetHeightDepth() {
            assertThat(halfInchCabinetBox.getSide().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(10.5, 20));
        }

        @Test
        void testBackSizeUsesCabinetHeightWidth() {
            assertThat(halfInchCabinetBox.getBack().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(9.5, 10.25));
        }

        @Test
        void testBottomSizeUsesCabinetWidthDepth() {
            assertThat(halfInchCabinetBox.getBottom().getDimensions()).isEqualTo(
                    Cut.Dimensions.valueOf(20, 9.5));
        }
    }

    @Nested
    class CabinetBoxValidationTest {

        @Test
        void testCabinetCanNotHaveNegativeWidth() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new CabinetBox(Material.THREE_QUARTER, Material.QUARTER, -1.0, 6.0,
                            6.0)).withMessageContaining(
                    "Expected Cabinet width greater than 2x side material thickness, 1.5000, but" + " received -1.0000");
        }

        @Test
        void testCabinetWidthMustBeGreaterThanDoubleSideMaterial() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new CabinetBox(Material.HALF, Material.QUARTER, 1.0, 6.0,
                            6.0)).withMessageContaining(
                    "Expected Cabinet width greater than 2x side material thickness, 1.0000, but" + " received 1.0000");
        }

        @Test
        void testCabinetCanNotHaveNegativeHeight() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new CabinetBox(Material.THREE_QUARTER, Material.QUARTER, -1.0, 6.0,
                            6.0)).withMessageContaining(
                    "Expected Cabinet width greater than 2x side material thickness, 1.5000, but" + " received -1.0000");
        }

        @Test
        void testCabinetHeightMustBeGreaterThanDoubleSideMaterial() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new CabinetBox(Material.QUARTER, Material.QUARTER, 10.0, 0.3,
                            6.0)).withMessageContaining(
                    "Expected Cabinet height greater than 2x side material thickness, 0.5000, " + "but" + " received 0.3000");
        }

        @Test
        void testCabinetCanNotHaveNegativeDepth() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new CabinetBox(Material.THREE_QUARTER, Material.QUARTER, 10.0, 6.0,
                            -1.0)).withMessageContaining(
                    "Expected Cabinet depth greater than side material thickness plus back " + "material thickness, 1.0000, but received -1.0000");
        }

        @Test
        void testCabinetDepthMustBeGreaterThanSideMaterialPlusBackMaterial() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new CabinetBox(Material.THREE_QUARTER, Material.QUARTER, 10.0, 6.0,
                            0.75)).withMessageContaining(
                    "Expected Cabinet depth greater than side material thickness plus back " + "material thickness, 1.0000, but received 0.7500");
        }
    }
}