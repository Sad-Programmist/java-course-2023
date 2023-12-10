package edu.project4;

import edu.project4.transformation.HeartTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeartTransformationTest {

    @Test
    @DisplayName("Сердце трансформация null точки")
    void heartTransformationTest1() {
        //given
        Point point = null;

        // when
        HeartTransformation heartTransformation = new HeartTransformation();
        Point result = heartTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0, 0));
    }

    @Test
    @DisplayName("Сердце трансформация (2, 2) точки")
    void heartTransformationTest2() {
        //given
        Point point = new Point(2, 2);

        // when
        HeartTransformation heartTransformation = new HeartTransformation();
        Point result = heartTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(-1.2865827715256053, 2.518869740977785));
    }

    @Test
    @DisplayName("Сердце трансформация (-5, -5) точки")
    void heartTransformationTest3() {
        //given
        Point point = new Point(-5, -5);

        // when
        HeartTransformation heartTransformation = new HeartTransformation();
        Point result = heartTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(7.071045990732419, 0.01756692764799703));
    }
}
