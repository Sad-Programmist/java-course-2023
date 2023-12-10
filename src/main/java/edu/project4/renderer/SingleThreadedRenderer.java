package edu.project4.renderer;

import edu.project4.FractalImage;
import edu.project4.Pixel;
import edu.project4.Point;
import edu.project4.transformation.Transformation;
import java.util.List;

public class SingleThreadedRenderer implements Renderer {

    // Границы мира
    private final static double X_MIN = -1;
    private final static double X_MAX = 1;
    private final static double Y_MIN = -1;
    private final static double Y_MAX = 1;

    // Метод для генерации случайных чисел в заданном диапазоне
    private double rand(double min, double max) {
        return min + Math.random() * (max - min);
    }

    // Метод для округления числа
    private int trunc(double value) {
        return (int) value;
    }

    // Метод для инициализации массива пикселей
    private void initializePixels(Pixel[][] pixels) {
        if (pixels == null) {
            return;
        }
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                pixels[i][j] = new Pixel();
            }
        }
    }

    // Основной метод для рендеринга фрактального пламени
    @Override
    @SuppressWarnings({"MagicNumber", "CyclomaticComplexity"})
    public FractalImage render(
        int pointsCount,
        int xRes,
        int yRes,
        int iterationsCount,
        int eqCount,
        int skipIterations,
        List<Transformation> transformations
    ) {
        Pixel[][] pixels = new Pixel[xRes][yRes];
        initializePixels(pixels);

        // Генерация аффинных преобразований со стартовыми цветами
        Coefficients[] coefficients = new Coefficients[eqCount];
        for (int eqIndex = 0; eqIndex < eqCount; eqIndex++) {
            coefficients[eqIndex] = new Coefficients(
                rand(-1.5, 1.5),
                rand(-1.5, 1.5),
                rand(-0.5, 0.5),
                rand(-1.5, 1.5),
                rand(-1.5, 1.5),
                rand(-0.5, 0.5),
                rand(0.0, 1.0),
                rand(0.0, 1.0),
                rand(0.0, 1.0)
            );
        }

        // Основной цикл рендеринга
        for (int pointIndex = 0; pointIndex < pointsCount; pointIndex++) {
            double newX = rand(X_MIN, X_MAX);
            double newY = rand(Y_MIN, Y_MAX);

            for (int iterationIndex = -skipIterations; iterationIndex < iterationsCount; iterationIndex++) {
                // Применение афинного преобразования
                int eqIndex = (int) rand(0, eqCount);
                double x = coefficients[eqIndex].a * newX + coefficients[eqIndex].b * newY + coefficients[eqIndex].c;
                double y = coefficients[eqIndex].d * newX + coefficients[eqIndex].e * newY + coefficients[eqIndex].f;
                Point point = new Point(x, y);

                // Применение нелинейного преобразования
                if (transformations != null && !transformations.isEmpty()) {
                    int transformationIndex = (int) rand(0, transformations.size());
                    Transformation transformation = transformations.get(transformationIndex);
                    if (transformation != null) {
                        point = transformation.apply(point);
                        x = point.x();
                        y = point.y();
                    }
                }

                if (iterationIndex >= 0 && newX >= X_MIN && newX <= X_MAX && newY >= Y_MIN && newY <= Y_MAX) {
                    int x1 = trunc(((x - X_MIN) / (X_MAX - X_MIN)) * (xRes - 1));
                    int y1 = trunc(((y - Y_MIN) / (Y_MAX - Y_MIN)) * (yRes - 1));

                    if (x1 < xRes && y1 < yRes && x1 >= 0 && y1 >= 0) {
                        Pixel pixel = pixels[x1][y1];
                        Coefficients eq = coefficients[eqIndex];
                        if (pixel.getCounter() == 0) {
                            pixel.setRed(eq.red * 255);
                            pixel.setGreen(eq.green * 255);
                            pixel.setBlue(eq.blue * 255);

                        } else {
                            pixel.setRed((pixel.getRed() + eq.red * 255) / 2);
                            pixel.setGreen((pixel.getGreen() + eq.green * 255) / 2);
                            pixel.setBlue((pixel.getBlue() + eq.blue * 255) / 2);

                        }
                        pixel.setCounter(pixel.getCounter() + 1);
                    }
                }
                // Обновление newX и newY для следующей итерации
                newX = x;
                newY = y;
            }
        }

        return new FractalImage(pixels, xRes, yRes);
    }

    // Коэффициенты аффинных преобразований
    private static class Coefficients {
        double a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double red;
        double green;
        double blue;

        @SuppressWarnings("ParameterNumber") Coefficients(
            double a, double b, double c, double d, double e, double f, double red, double green, double blue
        ) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

}
