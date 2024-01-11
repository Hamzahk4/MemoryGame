import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ImageSwitcher extends Frame {
    private Image image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13;
    private Image[] flics = new Image[13];
    private Image[] inUseFlics = new Image[24];
    private final ArrayList<Image> possibleUseFlics = new ArrayList<>();
    private int[] xCoords = {370, 635, 900, 1165, 1430, 1695}; // Adjusted x coordinates for 4 columns
    private int[] yCoords = {7, 282, 557, 832};               // Adjusted y coordinates for 4 rows
    private int imageCount = 1;

    public ImageSwitcher() {
        loadImages();
        initializeArrays();

        setVisible(true);
        setSize(1920, 1080);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        shuffle(inUseFlics);
        repaint(); // Trigger the paint method after loading the images
    }

    private void loadImages() {
        image0 = Toolkit.getDefaultToolkit().getImage(".idea/Image0.jpg");
        image1 = Toolkit.getDefaultToolkit().getImage(".idea/Image1.jpg");
        image2 = Toolkit.getDefaultToolkit().getImage(".idea/Image2.jpg");
        image3 = Toolkit.getDefaultToolkit().getImage(".idea/Image3.jpg");
        image4 = Toolkit.getDefaultToolkit().getImage(".idea/Image4.jpg");
        image5 = Toolkit.getDefaultToolkit().getImage(".idea/Image5.jpg");
        image6 = Toolkit.getDefaultToolkit().getImage(".idea/Image6.jpg");
        image7 = Toolkit.getDefaultToolkit().getImage(".idea/Image7.jpg");
        image8 = Toolkit.getDefaultToolkit().getImage(".idea/Image8.jpg");
        image9 = Toolkit.getDefaultToolkit().getImage(".idea/Image9.jpg");
        image10 = Toolkit.getDefaultToolkit().getImage(".idea/Image10.jpg");
        image11 = Toolkit.getDefaultToolkit().getImage(".idea/Image11.jpg");
        image12 = Toolkit.getDefaultToolkit().getImage(".idea/Image12.jpg");
        image13 = Toolkit.getDefaultToolkit().getImage(".idea/Image13.jpg");
    }

    private void initializeArrays() {
        flics = new Image[]{image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13};
        for (int i = 0; i < flics.length; i++) {
            possibleUseFlics.add(flics[i]);
        }

        for (int i = 0; i < 23; i += 2) {
            int num = (int) (Math.random() * possibleUseFlics.size());
            inUseFlics[i] = possibleUseFlics.get(num);
            inUseFlics[i + 1] = possibleUseFlics.get(num);
            possibleUseFlics.remove(num);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image0, 100, 100, 265, 265, null);
        printBoard(inUseFlics, g);
    }

    private void printBoard(Image[] ar, Graphics g) {
        int count = 0;
        for (int i = 0; i < yCoords.length; i++) {
            for (int j = 0; j < xCoords.length; j++) {
                g.drawImage(ar[count], xCoords[j], yCoords[i], 265, 265, null);
                count++;
            }
        }
    }

    public void shuffle(Image[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Image a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ImageSwitcher imageSwitcher = new ImageSwitcher();
        });
    }
}
