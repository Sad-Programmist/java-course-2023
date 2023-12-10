package edu.project4;

import edu.project4.renderer.SingleThreadedRenderer;
import edu.project4.transformation.Transformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingleThreadedRendererTest {

    @Test
    @DisplayName("Отрисовка в 1 поток с пустым списком преобразований")
    void singleThreadedRendererTest1() {
        //given
        int pointsCount = 100;
        int xRes = 10;
        int yRes = 10;
        int iterationsCount = 3;
        int eqCount = 10;
        int skipIterations = 2;
        List<Transformation> transformations = new ArrayList<>();

        // when
        SingleThreadedRenderer singleThreadedRenderer = new SingleThreadedRenderer();
        FractalImage result = singleThreadedRenderer.render(pointsCount, xRes, yRes, iterationsCount, eqCount, skipIterations, transformations);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    @DisplayName("Отрисовка в 1 поток с null списком преобразований")
    void singleThreadedRendererTest2() {
        //given
        int pointsCount = 100;
        int xRes = 10;
        int yRes = 10;
        int iterationsCount = 3;
        int eqCount = 10;
        int skipIterations = 2;
        List<Transformation> transformations = null;

        // when
        SingleThreadedRenderer singleThreadedRenderer = new SingleThreadedRenderer();
        FractalImage result = singleThreadedRenderer.render(pointsCount, xRes, yRes, iterationsCount, eqCount, skipIterations, transformations);

        // then
        assertThat(result).isNotNull();
    }
}
