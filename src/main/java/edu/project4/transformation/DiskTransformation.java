package edu.project4.transformation;

import edu.project4.Point;

public class DiskTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        if (point == null) {
            return new Point(0, 0);
        }
        double x = point.x();
        double y = point.y();
        double sqrt = Math.PI * Math.sqrt(x * x + y * y);
        double newX = 1 / Math.PI * Math.atan(y / x) * Math.sin(sqrt);
        double newY = 1 / Math.PI * Math.atan(y / x) * Math.cos(sqrt);
        return new Point(newX, newY);
    }
}
