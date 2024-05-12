import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class JointTest implements WithAssertions {

    @Test
    void testHalfDadoJointOffsetIsMaterialThickness() {
        assertThat(new Joint(Material.HALF,
                Joint.JointType.DADO).getJoinedDimensionOffset()).isEqualTo(0.5);
    }

    @Test
    void testHalfSingleSideDadoJointOffsetIsHalfMaterialThickness() {
        assertThat(new Joint(Material.HALF,
                Joint.JointType.SINGLE_SIDE_DADO).getJoinedDimensionOffset()).isEqualTo(0.25);
    }

    @Test
    void testThreeQuarterButtJointDoublesMaterialForOffset() {
        assertThat(new Joint(Material.THREE_QUARTER,
                Joint.JointType.BUTT).getJoinedDimensionOffset()).isEqualTo(1.5);
    }

    @Test
    void testQuarterButtJointDoublesMaterialForOffset() {
        assertThat(new Joint(Material.QUARTER,
                Joint.JointType.BUTT).getJoinedDimensionOffset()).isEqualTo(0.5);
    }
}