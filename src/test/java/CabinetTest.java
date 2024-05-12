import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class CabinetTest implements WithAssertions {

    @InjectSoftAssertions
    private SoftAssertions softly;

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
        void testRunnerSizing() {
            assertThat(largeCabinet.getRunner().getDimensions()).isEqualTo(
                    new Cut.Dimensions(22.5, 3));
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
        void testRunnerSizing() {
            assertThat(smallCabinet.getRunner().getDimensions()).isEqualTo(
                    new Cut.Dimensions(4.5, 3));
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
        void testRunnerSizing() {
            assertThat(this.halfInchCabinet.getRunner().getDimensions()).isEqualTo(
                    new Cut.Dimensions(9, 3));
        }

        @Test
        void testRunnerUsesCabinetSideMaterial() {
            assertThat(this.halfInchCabinet.getRunner().getMaterial()).isEqualTo(Material.HALF);
        }
    }
}