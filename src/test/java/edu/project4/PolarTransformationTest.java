package edu.project4;

import edu.project4.transformation.PolarTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PolarTransformationTest {

    @Test
    @DisplayName("Полярная трансформация null точки")
    void polarTransformationTest1() {
        //given
        Point point = null;

        // when
        PolarTransformation polarTransformation = new PolarTransformation();
        Point result = polarTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0, 0));
    }

    @Test
    @DisplayName("Полярная трансформация (2, 2) точки")
    void polarTransformationTest2() {
        //given
        Point point = new Point(2, 2);

        // when
        PolarTransformation polarTransformation = new PolarTransformation();
        Point result = polarTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0.25, 1.8284271247461903));
    }

    @Test
    @DisplayName("Полярная трансформация (-5, -5) точки")
    void polarTransformationTest3() {
        //given
        Point point = new Point(-5, -5);

        // when
        PolarTransformation polarTransformation = new PolarTransformation();
        Point result = polarTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0.25, 6.0710678118654755));
    }
}
