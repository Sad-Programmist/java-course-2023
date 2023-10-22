package edu.hw2.task2;

public class Rectangle {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }
        if (width < 0) {
            this.width = 0;
        } else {
            this.width = width;
        }
    }

    public final void setHeight(double height) {
        if (height >= 0) {
            this.height = height;
        }
    }

    public final void setWidth(double width) {
        if (width >= 0) {
            this.width = width;
        }
    }

    public double area() {
        return height * width;
    }
}
