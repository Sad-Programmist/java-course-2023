package edu.project4.transformation;

import edu.project4.Point;

public class SphericalTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        if (point == null) {
            return new Point(0, 0);
        }
        double x = point.x();
        double y = point.y();
        double newX = x / (x * x + y * y);
        double newY = y / (x * x + y * y);
        return new Point(newX, newY);
    }
}
