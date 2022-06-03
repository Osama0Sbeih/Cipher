
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.imageio.ImageIO;

public class ReadImageAndHideText {

    private static String path = System.getenv("HOME");

    public static void main(String[] args) throws IOException {
        String text = "My name is osama sbaih.";
        int[] n = new int[text.length() * 2];
        for (int i = 0, j = 0; i < n.length; i += 2, j++) {
            char c = text.charAt(j);
            n[i] = c >> 4;
            n[i + 1] = (n[i] << 4) - c;
        }

        BufferedImage image = ImageIO.read(new File(path + "/Desktop/main.jpg")); // "pathpicorginal"
        int width = image.getWidth();
        int height = image.getHeight();

        if (n.length <= width + height) {
            int k = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (k == n.length) {
                        File file = new File(path + "/Desktop/main_encoded.jpg"); // "path to the new image"
                        OutputStream output = new FileOutputStream(file);
                        ImageIO.write(image, "jpg",output);
                        output.close();
                        System.exit(0);
                    }

                    int rgb = image.getRGB(i, j);
                    int shift = (rgb >>> 4) << 4;
                    shift += n[k++];
                    image.setRGB(i, j, shift);
                }
            }
        }
    }
}
