import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class CabinetTest implements WithAssertions {

    @Nested
    class LargeCabinetTest {
        private Cabinet largeCabinet;

        @BeforeEach
        void setUp() {
            this.largeCabinet = new Cabinet(Material.THREE_QUARTER, Material.QUARTER, 24, 30.5, 18);
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(largeCabinet.getRunner().getMaterial()).isEqualTo(Material.THREE_QUARTER);
        }

        @Test
        void testRunnerSizeUsesCabinetWidth() {
            assertThat(largeCabinet.getRunner().getDimensions()).isEqualTo(
                    new Cut.Dimensions(22.5, 3));
        }

        @Test
        void testSideSizeEqualToCabinetHeightDepth() {
            assertThat(largeCabinet.getSide().getDimensions()).isEqualTo(
                    new Cut.Dimensions(30.5, 18));
        }

        @Test
        void testBackSizeUsesCabinetHeightWidth() {
            assertThat(largeCabinet.getBack().getDimensions()).isEqualTo(
                    new Cut.Dimensions(30.125, 23.25));
        }

        @Test
        void testBottomSizeUsesCabinetWidthDepth() {
            assertThat(largeCabinet.getBottom().getDimensions()).isEqualTo(
                    new Cut.Dimensions(18, 23.25));
        }

        @Nested
        class CabinetToStringTest {
            @Test
            void testToStringFormatsDimensions() {
                assertThat(largeCabinet.toString()).contains("24.0x30.5x18.0 WxHxD");
            }

            // The toString value for panels is delegated to Cut, so testing that the panel instance
            // variables are include in the toString but not testing the value
            @Test
            void testToStringIncludesSidePanel() {
                assertThat(largeCabinet.toString()).contains("side=");
            }

            @Test
            void testToStringIncludesBackPanel() {
                assertThat(largeCabinet.toString()).contains("back=");
            }

            @Test
            void testToStringIncludesBottomPanel() {
                assertThat(largeCabinet.toString()).contains("bottom=");
            }

            @Test
            void testToStringIncludesRunner() {
                assertThat(largeCabinet.toString()).contains("runner=");
            }
        }

    }

    @Nested
    class SmallCabinetTest {
        private Cabinet smallCabinet;

        @BeforeEach
        void setUp() {
            this.smallCabinet = new Cabinet(Material.THREE_QUARTER, Material.QUARTER, 6, 6, 10);
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(smallCabinet.getRunner().getMaterial()).isEqualTo(Material.THREE_QUARTER);
        }

        @Test
        void testRunnerSizeUsesCabinetWidth() {
            assertThat(smallCabinet.getRunner().getDimensions()).isEqualTo(
                    new Cut.Dimensions(4.5, 3));
        }

        @Test
        void testSideSizeEqualToCabinetHeightDepth() {
            assertThat(smallCabinet.getSide().getDimensions()).isEqualTo(new Cut.Dimensions(6, 10));
        }

        @Test
        void testBackSizeUsesCabinetHeightWidth() {
            assertThat(smallCabinet.getBack().getDimensions()).isEqualTo(
                    new Cut.Dimensions(5.25, 5.625));
        }

        @Test
        void testBottomSizeUsesCabinetWidthDepth() {
            assertThat(smallCabinet.getBottom().getDimensions()).isEqualTo(
                    new Cut.Dimensions(5.25, 10));
        }
    }

    @Nested
    class HalfInchCabinetTest {
        private Cabinet halfInchCabinet;

        @BeforeEach
        void setUp() {
            this.halfInchCabinet = new Cabinet(Material.HALF, Material.HALF, 10, 10.5, 20);
        }


        @Test
        void testRunnerSizeUsesCabinetWidth() {
            assertThat(this.halfInchCabinet.getRunner().getDimensions()).isEqualTo(
                    new Cut.Dimensions(9, 3));
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(this.halfInchCabinet.getRunner().getMaterial()).isEqualTo(Material.HALF);
        }

        @Test
        void testSideSizeEqualToCabinetHeightDepth() {
            assertThat(halfInchCabinet.getSide().getDimensions()).isEqualTo(
                    new Cut.Dimensions(10.5, 20));
        }

        @Test
        void testBackSizeUsesCabinetHeightWidth() {
            assertThat(halfInchCabinet.getBack().getDimensions()).isEqualTo(
                    new Cut.Dimensions(9.5, 10.25));
        }

        @Test
        void testBottomSizeUsesCabinetWidthDepth() {
            assertThat(halfInchCabinet.getBottom().getDimensions()).isEqualTo(
                    new Cut.Dimensions(20, 9.5));
        }
    }

    @Nested
    class CabinetValidationTest {

        @Test
        void testCabinetCanNotHaveNegativeWidth() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Cabinet(Material.THREE_QUARTER, Material.QUARTER, -1.0, 6.0,
                            6.0)).withMessageContaining(
                    "Expected Cabinet width greater than 2x side material thickness, 1.5000, but" + " received -1.0000");
        }

        @Test
        void testCabinetWidthMustBeGreaterThanDoubleSideMaterial() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Cabinet(Material.HALF, Material.QUARTER, 1.0, 6.0,
                            6.0)).withMessageContaining(
                    "Expected Cabinet width greater than 2x side material thickness, 1.0000, but" + " received 1.0000");
        }

        @Test
        void testCabinetCanNotHaveNegativeHeight() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Cabinet(Material.THREE_QUARTER, Material.QUARTER, -1.0, 6.0,
                            6.0)).withMessageContaining(
                    "Expected Cabinet width greater than 2x side material thickness, 1.5000, but" + " received -1.0000");
        }

        @Test
        void testCabinetHeightMustBeGreaterThanDoubleSideMaterial() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Cabinet(Material.QUARTER, Material.QUARTER, 10.0, 0.3,
                            6.0)).withMessageContaining(
                    "Expected Cabinet height greater than 2x side material thickness, 0.5000, " + "but" + " received 0.3000");
        }

        @Test
        void testCabinetCanNotHaveNegativeDepth() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Cabinet(Material.THREE_QUARTER, Material.QUARTER, 10.0, 6.0,
                            -1.0)).withMessageContaining(
                    "Expected Cabinet depth greater than side material thickness plus back " +
                            "material thickness, 1.0000, but received -1.0000");
        }

        @Test
        void testCabinetDepthMustBeGreaterThanSideMaterialPlusBackMaterial() {
            assertThatIllegalArgumentException().isThrownBy(
                    () -> new Cabinet(Material.THREE_QUARTER, Material.QUARTER, 10.0, 6.0,
                            0.75)).withMessageContaining(
                    "Expected Cabinet depth greater than side material thickness plus back " +
                            "material thickness, 1.0000, but received 0.7500");
        }
    }
}