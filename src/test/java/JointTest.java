import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class JointTest implements WithAssertions {

    @Test
    void testHalfDadoJointOffsetIsMaterialThickness() {
        assertThat(Joint.create(Material.HALF,
                Joint.JointType.DADO).getJoinedDimensionOffset()).isEqualTo(0.5);
    }

    @Test
    void testHalfSingleSideDadoJointOffsetIsHalfMaterialThickness() {
        assertThat(Joint.create(Material.HALF,
                Joint.JointType.SINGLE_SIDE_DADO).getJoinedDimensionOffset()).isEqualTo(0.25);
    }

    @Test
    void testThreeQuarterButtJointDoublesMaterialForOffset() {
        assertThat(Joint.create(Material.THREE_QUARTER,
                Joint.JointType.BUTT).getJoinedDimensionOffset()).isEqualTo(1.5);
    }

    @Test
    void testQuarterButtJointDoublesMaterialForOffset() {
        assertThat(Joint.create(Material.QUARTER,
                Joint.JointType.BUTT).getJoinedDimensionOffset()).isEqualTo(0.5);
    }
}