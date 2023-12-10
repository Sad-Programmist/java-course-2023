package edu.project4.transformation;

import edu.project4.Point;

public class HeartTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        if (point == null) {
            return new Point(0, 0);
        }
        double x = point.x();
        double y = point.y();
        double sqrt = Math.sqrt(x * x + y * y);
        double arctan = sqrt + Math.atan(y / x);
        double newX = sqrt * Math.sin(arctan);
        double newY = -sqrt * Math.cos(arctan);
        return new Point(newX, newY);
    }
}
