package edu.project4;

import edu.project4.transformation.SinusoidalTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SinusoidalTransformationTest {

    @Test
    @DisplayName("Синусоидальная трансформация null точки")
    void sinusoidalTransformationTest1() {
        //given
        Point point = null;

        // when
        SinusoidalTransformation sinusoidalTransformation = new SinusoidalTransformation();
        Point result = sinusoidalTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0, 0));
    }

    @Test
    @DisplayName("Синусоидальная трансформация (2, 2) точки")
    void sinusoidalTransformationTest2() {
        //given
        Point point = new Point(2, 2);

        // when
        SinusoidalTransformation sinusoidalTransformation = new SinusoidalTransformation();
        Point result = sinusoidalTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0.9092974268256817, 0.9092974268256817));
    }

    @Test
    @DisplayName("Синусоидальная трансформация (-5, -5) точки")
    void sinusoidalTransformationTest3() {
        //given
        Point point = new Point(-5, -5);

        // when
        SinusoidalTransformation sinusoidalTransformation = new SinusoidalTransformation();
        Point result = sinusoidalTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0.9589242746631385, 0.9589242746631385));
    }
}
