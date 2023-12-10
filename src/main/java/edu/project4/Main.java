package edu.project4;

import edu.project4.processor.ImageProcessor;
import edu.project4.processor.LogarithmicGammaProcessor;
import edu.project4.renderer.MultiThreadedRenderer;
import edu.project4.renderer.Renderer;
import edu.project4.renderer.SingleThreadedRenderer;
import edu.project4.transformation.DiskTransformation;
import edu.project4.transformation.SinusoidalTransformation;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;

public class Main {

    private Main() {

    }

    @SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
    public static void main(String[] args) {
        int imagesCount = 1;
        ImageProcessor imageProcessor = new LogarithmicGammaProcessor();

        // Однопоточная версия
        long singleThreadedStartTime = System.currentTimeMillis();
        Renderer singleThreadedRenderer = new SingleThreadedRenderer();
        for (int imageIndex = 0; imageIndex < imagesCount; imageIndex++) {
            FractalImage fractalImage = singleThreadedRenderer.render(
                1000,
                800,
                800,
                2000,
                10,
                20,
                List.of(new SinusoidalTransformation(), new DiskTransformation())
            );
            imageProcessor.process(fractalImage, 2.2);

            Path filePath = Path.of("single_fractal_image_" + imageIndex + ".png");
            ImageUtils.save(fractalImage, filePath, ImageFormat.PNG);
        }
        long singleThreadedEndTime = System.currentTimeMillis();
        LogManager.getLogger().info(
            "Single-threaded rendering time: " + (singleThreadedEndTime - singleThreadedStartTime) + " ms");

        // Многопоточная версия
        long multiThreadedStartTime = System.currentTimeMillis();
        Renderer multiThreadedRenderer = new MultiThreadedRenderer(2);
        for (int imageIndex = 0; imageIndex < imagesCount; imageIndex++) {
            FractalImage fractalImage = multiThreadedRenderer.render(
                1000,
                800,
                800,
                2000,
                10,
                20,
                List.of(new SinusoidalTransformation(), new DiskTransformation())
            );
            imageProcessor.process(fractalImage, 2.2);

            Path filePath = Path.of("multi_fractal_image_" + imageIndex + ".png");
            ImageUtils.save(fractalImage, filePath, ImageFormat.PNG);
        }
        long multiThreadedEndTime = System.currentTimeMillis();
        LogManager.getLogger()
            .info("Multi-threaded rendering time: " + (multiThreadedEndTime - multiThreadedStartTime) + " ms");

    }
}
