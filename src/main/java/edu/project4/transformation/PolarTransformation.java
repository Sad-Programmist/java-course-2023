package edu.project4.transformation;

import edu.project4.Point;

public class PolarTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        if (point == null) {
            return new Point(0, 0);
        }
        double x = point.x();
        double y = point.y();
        double newX = Math.atan(y / x) / Math.PI;
        double newY = Math.sqrt(x * x + y * y) - 1;
        return new Point(newX, newY);
    }
}
