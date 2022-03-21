import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import java.awt.Graphics;

public class JImageDisplay extends javax.swing.JComponent {


    private BufferedImage ScreenImage;

    public BufferedImage getImage() {
        return ScreenImage;
    }

    public int width;

    public int height;

    public JImageDisplay(int target_width, int target_height) {
        this.ScreenImage = new BufferedImage(target_width, target_height, BufferedImage.TYPE_INT_RGB);
        Dimension size = new Dimension(target_width, target_height);
        setPreferredSize(size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ScreenImage, 0, 0, ScreenImage.getWidth(), ScreenImage.getHeight(), null);
    }

    public void clearImage() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.ScreenImage.setRGB(x, y, 0);
            }
        }
    }

    public void drawPixel(int x, int y, int rgbColor) {
        this.ScreenImage.setRGB(x, y, rgbColor);
    }
}
