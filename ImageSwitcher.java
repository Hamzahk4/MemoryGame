import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ImageSwitcher extends Frame {
    private Image image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13;
    private Image[] flics = new Image[13];
    private Image[] inUseFlics = new Image[24];
    private final ArrayList<Image> possibleUseFlics = new ArrayList<Image>();
    private int[] xCoords = {370, 635, 900, 1665, 1430, 1655};
    private int[] yCoords = {7, 275, 543, 811};
    private int imageCount = 1;

    public ImageSwitcher() {
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
// settimg up arrays
        flics = new Image[]{image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13};
        for (int i = 0; i < flics.length; i++) {
            possibleUseFlics.add(flics[i]);
        }
        //flics and possibleUseFlics hold same data. Flic is array, puf is arrayList

//set up in use array and photos that will be used for round\
        for (int i = 0; i < 23; i += 2) {
            int num = (int) (Math.random() * possibleUseFlics.size());
            inUseFlics[i] = possibleUseFlics.get(num);
            inUseFlics[i + 1] = possibleUseFlics.get(num);
            possibleUseFlics.remove(num);
        }
        // shuffle is used to shuffle our array to board positions
        shuffle(inUseFlics);
        construct();
    }//end of constructor

    private void printBoard(Image[] ar,Graphics g) {
        for (int i = 0; i < yCoords.length; i++) {
            for (int j = 0; j < xCoords.length; j++) {
                g.drawImage(flics[imageCount - 1], xCoords[j], yCoords[i], 265, 265, this);
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

    // to come soon
    public void construct() {
        setTitle("Memory Game");
        setSize(1920, 1080);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                imageCount++;
                printBoard(inUseFlics);
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {

        g.drawImage(flics[imageCount - 1], 0, 0, 260, 260, this);
    }

    }
//https://code-with-me.global.jetbrains.com/I4XTM7FrOmjl9HCe4FdNVQ#p=IC&fp=FDA8A50E3A7D23F6CFFA08C25A2A9CD9508CD46C82AB37C2542B606EC6E93126
