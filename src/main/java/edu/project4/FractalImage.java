package edu.project4;

public record FractalImage(Pixel[][] data, int width, int height) {

    boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    Pixel pixel(int x, int y) {
        if (contains(x, y)) {
            return data[x][y];
        } else {
            return new Pixel();
        }
    }
}
