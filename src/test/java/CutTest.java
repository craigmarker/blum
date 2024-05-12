import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CutTest implements WithAssertions {

    @Test
    void testUnjoinedCutDoesNotModifyProvidedDimensions() {
        Cut cut = new Cut(3.0, 6.0, Material.THREE_QUARTER);

        assertThat(cut.getDimensions()).isEqualTo(new Cut.Dimensions(6.0, 3.0));
    }

    @Test
    void testWithOneJoinedDimensionAppliesOffsetToSingleDimension() {
        Cut cut = Cut.withOneJoinedDimension(3.0,
                new Joint(Material.THREE_QUARTER, Joint.JointType.BUTT), 6.0,
                Material.THREE_QUARTER);

        assertThat(cut.getDimensions()).isEqualTo(new Cut.Dimensions(6.0, 1.5));
    }

    @Test
    void testWithTwoJoinedDimensionsAppliesOffsetToBothDimension() {
        Cut cut = Cut.withTwoJoinedDimensions(3.0,
                new Joint(Material.THREE_QUARTER, Joint.JointType.BUTT), 6.0,
                new Joint(Material.HALF, Joint.JointType.DADO), Material.THREE_QUARTER);

        assertThat(cut.getDimensions()).isEqualTo(new Cut.Dimensions(5.5, 1.5));
    }

    @Test
    void testToStringIncludesDimensions() {
        Cut cut = new Cut(3.0, 6.0, Material.THREE_QUARTER);

        assertThat(cut.toString()).contains("dimensions=");
    }

    @Test
    void testToStringIncludesMaterial() {
        Cut cut = new Cut(3.0, 6.0, Material.THREE_QUARTER);

        assertThat(cut.toString()).contains("material=");
    }

    @Nested
    class DimensionsTest {

        @Test
        void testEquivalentDimensionsAreEqual() {
            assertThat(new Cut.Dimensions(3.0, 6.0)).isEqualTo(new Cut.Dimensions(3.0, 6.0));
        }

        @Test
        void testEqualsIsSymmetric() {
            assertThat(new Cut.Dimensions(3.0, 6.0)).isEqualTo(new Cut.Dimensions(6.0, 3.0));
        }

        @Test
        void testSelfIsEqualToSelf() {
            Cut.Dimensions dimensions = new Cut.Dimensions(3.0, 6.0);

            assertThat(dimensions).isEqualTo(dimensions);
        }

        @Test
        void testToStringFormatsDimensions() {
            Cut.Dimensions dimensions = new Cut.Dimensions(3.0, 6.0);

            assertThat(dimensions.toString()).contains("3.0x6.0");
        }
    }
}