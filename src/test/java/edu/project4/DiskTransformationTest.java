package edu.project4;

import edu.project4.transformation.DiskTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiskTransformationTest {

    @Test
    @DisplayName("Диск трансформация null точки")
    void diskTransformationTest1() {
        //given
        Point point = null;

        // when
        DiskTransformation diskTransformation = new DiskTransformation();
        Point result = diskTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0, 0));
    }

    @Test
    @DisplayName("Диск трансформация (2, 2) точки")
    void diskTransformationTest2() {
        //given
        Point point = new Point(2, 2);

        // when
        DiskTransformation diskTransformation = new DiskTransformation();
        Point result = diskTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0.12832209928926547, -0.21455404641720438));
    }

    @Test
    @DisplayName("Диск трансформация (-5, -5) точки")
    void diskTransformationTest3() {
        //given
        Point point = new Point(-5, -5);

        // when
        DiskTransformation diskTransformation = new DiskTransformation();
        Point result = diskTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(-0.05535396184412049, -0.24379487055342172));
    }
}
