package edu.project4.processor;

import edu.project4.FractalImage;
import edu.project4.Pixel;

public class LogarithmicGammaProcessor implements ImageProcessor {

    @Override
    public void process(FractalImage image, double gamma) {
        if (image == null) {
            return;
        }
        double max = 0.0;
        Pixel[][] pixels = image.data();
        int width = image.width();
        int height = image.height();

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                Pixel pixel = pixels[row][col];
                if (pixel != null && pixel.getCounter() != 0) {
                    pixel.setNormal(Math.log10(pixel.getCounter()));
                    if (pixel.getNormal() > max) {
                        max = pixel.getNormal();
                    }
                }
            }
        }

        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                Pixel pixel = pixels[row][col];
                if (pixel != null && pixel.getCounter() != 0) {
                    pixel.setNormal(pixel.getNormal() / max);
                    pixel.setRed(
                        pixel.getRed() * Math.pow(pixel.getNormal(), (1.0 / gamma)));
                    pixel.setGreen(
                        pixel.getGreen() * Math.pow(pixel.getNormal(), (1.0 / gamma)));
                    pixel.setBlue(
                        pixel.getBlue() * Math.pow(pixel.getNormal(), (1.0 / gamma)));
                }
            }
        }

    }
}
