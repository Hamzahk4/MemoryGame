
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
    private final int[] xCoords = {370, 635, 900, 1165, 1430, 1695}; // Adjusted x coordinates for 4 columns
    private final int[] yCoords = {7, 282, 557, 832};               // Adjusted y coordinates for 4 rows
    private int imageCount = 1;

    public ImageSwitcher() {
        loadImages();
        initializeArrays();

        setSize(1920, 1080);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        shuffle(inUseFlics);
        repaint(); // Trigger the paint method after loading the images
        setVisible(true);

        // Create and add buttons
        Buttons buttons = new Buttons();
        buttons.addToFrame(this);
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
        g.drawImage(image0, 100, 100, 265, 265, null);
        startBoard(inUseFlics, g);
    }

    private void startBoard(Image[] ar, Graphics g) {
        int count = 0;
        for (int i = 0; i < yCoords.length; i++) {
            for (int j = 0; j < xCoords.length; j++) {
                g.drawImage(ar[count], xCoords[j], yCoords[i], 265, 265, null);
                g.drawImage(image0, xCoords[j], yCoords[i], 265, 265, null);
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
}

//class Buttons {
//    private final Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
//
//    public Buttons() {
//        button1 = new Button();
//        button2 = new Button();
//        button3 = new Button();
//        button4 = new Button();
//        button5 = new Button();
//        button6 = new Button();
//        button7 = new Button();
//        button8 = new Button();
//        button9 = new Button();
//        button10 = new Button();
//        button11 = new Button();
//        button12 = new Button();
//    }
//
//    public void addToFrame(JFrame frame) {
//        frame.setLayout(new FlowLayout());
//
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);
//        frame.add(button4);
//        frame.add(button5);
//        frame.add(button6);
//        frame.add(button7);
//        frame.add(button8);
//        frame.add(button9);
//        frame.add(button10);
//        frame.add(button11);
//        frame.add(button12);
//    }
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Button;
//
//public class Buttons extends Frame implements ActionListener {
//    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;
//public Buttons(){
//    buttonMaker();

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class Buttons extends JFrame implements ActionListener {
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12;

    public Buttons() {
//        button1 = new Button();
//        button2 = new Button();
//        button3 = new Button();
//        button4 = new Button();
//        button5 = new Button();
//        button6 = new Button();
//        button7 = new Button();
//        button8 = new Button();
//        button9 = new Button();
//        button10 = new Button();
//        button11 = new Button();
//        button12 = new Button();
        buttonMaker();

    }

    public void addToFrame(JFrame frame) {
        frame.setLayout(new FlowLayout());

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
        frame.add(button11);
        frame.add(button12);
    }
}
//}
private void buttonMaker(){
    button1 = new Button();
    button1.addActionListener(this);
    button1.setVisible(false);
    add(button1);
    button2 = new Button();
    button2.addActionListener(this);
    button1.setVisible(false);
    add(button2);
    button3 = new Button();
    button3.addActionListener(this);
    button3.setVisible(false);
    add(button3);
    button4 = new Button();
    button4.addActionListener(this);
    button4.setVisible(false);
    add(button4);
    button5 = new Button();
    button5.addActionListener(this);
    button5.setVisible(false);
    add(button5);
    button6 = new Button();
    button6.addActionListener(this);
    button6.setVisible(false);
    add(button6);
    button7= new Button();
    button7.addActionListener(this);
    button7.setVisible(false);
    add(button7);
    button8 = new Button();
    button8.addActionListener(this);
    button8.setVisible(false);
    add(button8);
    button9 = new Button();
    button9.addActionListener(this);
    button9.setVisible(false);
    add(button9);
    button10 = new Button();
    button10.addActionListener(this);
    button10.setVisible(false);
    add(button10);
    button11 = new Button();
    button11.addActionListener(this);
    button11.setVisible(false);
    add(button11);
    button12 = new Button();
    button12.addActionListener(this);
    button12.setVisible(false);
    add(button12);
}
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}
