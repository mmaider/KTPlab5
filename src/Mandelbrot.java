import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Mandelbrot extends FractalGenerator {


    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    public int numIterations(double x, double y) {
        int iterations = 0;
        double z = 0;
        double ix;
        double iy;
        double cx = 0;
        double cy = 0;
        while ((z < 4) && (iterations < MAX_ITERATIONS)) {
            ix = cx * cx - cy * cy + x;
            iy = 2 * cx * cy + y;
            cx = ix;
            cy = iy;
            z = cx * cx + cy * cy;
            iterations++;
        }
        if (iterations == MAX_ITERATIONS) {
            return -1;
        }
        return iterations;
    }

    public String toString() {
        return "Mandelbrot";
    }
}