package edu.project4;

import edu.project4.transformation.SphericalTransformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SphericalTransformationTest {

    @Test
    @DisplayName("Сферическая трансформация null точки")
    void sphericalTransformationTest1() {
        //given
        Point point = null;

        // when
        SphericalTransformation sphericalTransformation = new SphericalTransformation();
        Point result = sphericalTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0, 0));
    }

    @Test
    @DisplayName("Сферическая трансформация (2, 2) точки")
    void sphericalTransformationTest2() {
        //given
        Point point = new Point(2, 2);

        // when
        SphericalTransformation sphericalTransformation = new SphericalTransformation();
        Point result = sphericalTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(0.25, 0.25));
    }

    @Test
    @DisplayName("Сферическая трансформация (-5, -5) точки")
    void sphericalTransformationTest3() {
        //given
        Point point = new Point(-5, -5);

        // when
        SphericalTransformation sphericalTransformation = new SphericalTransformation();
        Point result = sphericalTransformation.apply(point);

        // then
        assertThat(result).isEqualTo(new Point(-0.1, -0.1));
    }
}
