
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageSwitcher extends JFrame {
    private Image image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13;
    private Image[] flics = new Image[13];
    private Image[] inUseFlics = new Image[24];
    private final List<Image> possibleUseFlics = new ArrayList<>();
    private final int[] xCoords = {315,585 ,855, 1125, 1395, 1665}; // x coordinates for 6 columns
    private final int[] yCoords = {0, 265, 530, 795};               // y coordinates for 4 rows
    private int imageCount = 1;

    public ImageSwitcher() {
        loadImages();
        initializeArrays();
//        setResizable(false);
        pack();



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shuffle(inUseFlics);

        revalidate(); // Trigger the paint method after loading the images

        Stopwatch stopwatch = new Stopwatch();

        // Create and add buttons
       Buttons buttons = new Buttons();
        setVisible(true);
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

//       buttons.addToFrame(this);
    }

    private void initializeArrays() {
        flics = new Image[]{image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13};
        Collections.addAll(possibleUseFlics, flics);

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
        startBoard(inUseFlics, g);
    }

    private void startBoard(Image[] ar, Graphics g) {
        int count = 0;
        for (int i = 0; i < yCoords.length; i++) {
            for (int j = 0; j < xCoords.length; j++) {
                g.drawImage(ar[count], xCoords[j], yCoords[i], 255, 255, null);
                g.drawImage(image0, xCoords[j], yCoords[i], 255, 255, null);
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
            new ImageSwitcher();
        });
    }

    public int[] getxCoords(){
        return xCoords;
    }
    public int[] getyCoords(){
        return yCoords;
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            g.drawImage(image0, xCoords[j], yCoords[i], 255, 255, null);
        }
}

https://code-with-me.global.jetbrains.com/GVsdMpBmVI_b26bLEVgIuQ#p=IC&fp=2825E2804BA4315AB540CE105FFDF40E0A54C852752C076847716F53FD1BA632
