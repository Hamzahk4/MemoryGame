
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageSwitcher extends JFrame implements ActionListener {
    private Image image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13;
    private Image[] flics = new Image[13];
    public static Image[] inUseFlics = new Image[24];
    private final List<Image> possibleUseFlics = new ArrayList<>();
    private static final int[] xCoords = {315 ,585 ,855, 1125, 1395, 1665}; // x coordinates for 6 columns
    private static final int[] yCoords = {0, 265, 530, 795};               // y coordinates for 4 rows
    private int imageCount = 1;
    //private ButtonTest button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12,button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24;
    private ButtonTest[] butts = new ButtonTest[24];

    public Image[] getFlics()
    {
        return inUseFlics;
    }
    public ImageSwitcher() {
        loadImages();
        initializeArrays();
//        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        shuffle(inUseFlics);
        pack();
        setLayout(null);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.setLocation(0,0);
        stopwatch.setBounds(0,0,300,1080);
        shuffle(inUseFlics);
        add(stopwatch, BorderLayout.WEST);
        pack();

        revalidate(); // Trigger the paint method after loading the images
        // Stopwatch stopwatch = new Stopwatch();
        // Create and add buttons
        makeButtons();
        Buttons buttons = new Buttons();

//        getContentPane().add(buttons, BorderLayout.EAST);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setVisible(true);
//        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

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

//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            new ImageSwitcher();
//        });
//    }

    public static int[] getXCoords(){
        return xCoords;
    }
    public static int[] getYCoords(){
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
    public void actionPerformed(ActionEvent e){};

   public void makeButtons(){
       int count = 0;
       for (int i = 0; i < yCoords.length; i++) {
           for (int j = 0; j < xCoords.length; j++) {
               butts[count] = new ButtonTest(j, i);
               count++;
           }
       }
}
}

//https://code-with-me.global.jetbrains.com/GVsdMpBmVI_b26bLEVgIuQ#p=IC&fp=2825E2804BA4315AB540CE105FFDF40E0A54C852752C076847716F53FD1BA632
