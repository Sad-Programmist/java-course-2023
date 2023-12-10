package edu.project4.renderer;

import edu.project4.FractalImage;
import edu.project4.transformation.Transformation;
import java.util.List;

public interface Renderer {

    FractalImage render(
        int pointsCount,
        int xRes,
        int yRES,
        int iterationsCount,
        int eqCount,
        int skipIterations,
        List<Transformation> transformations
    );
}
