



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class ImageSwitcher extends JFrame{
    private Image[] flics = new Image[12];
    public static Image[] inUseFlics = new Image[24];
    private final List<Image> possibleUseFlics = new ArrayList<>();
    private static final int[] xCoords = {315 ,585 ,855, 1125, 1395, 1665}; // x coordinates for 6 columns
    private static final int[] yCoords = {0, 265, 530, 795};               // y coordinates for 4 rows
    private int imageCount = 0;

    private int count = 0;
    private boolean printOver = true;
    private int pairsGuessed = 0;
    private boolean canclick = true;
    JPanel panel = new JPanel(new GridLayout(4,6));
    ImageIcon facedown  = new ImageIcon(".idea/Image0.jpg");
    private boolean[] buttsClicked = new boolean[24];
    ArrayList<Integer> indices = new ArrayList<Integer>();




    ImageIcon[] images = new ImageIcon[12];
    //private ButtonTest button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12,button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24;
//    private ButtonTest[] butts = new ButtonTest[24];




    List<ImageIcon> shuffledImages = new ArrayList<>();




    public void shuffled()
    {
        for (ImageIcon images:images)
        {
            shuffledImages.add(images);
            shuffledImages.add(images);




        }
        Collections.shuffle(shuffledImages);
    }
















//   ImageIcon image1 = new ImageIcon(".idea/Image1.jpg");
//    ImageIcon image2 = new ImageIcon(".idea/Image2.jpg");
//    ImageIcon image3 = new ImageIcon(".idea/Image3.jpg");
//    ImageIcon image4 = new ImageIcon(".idea/Image4.jpg");
//    ImageIcon image5 = new ImageIcon(".idea/Image5.jpg");
//    ImageIcon image6 = new ImageIcon(".idea/Image6.jpg");
//    ImageIcon image7 = new ImageIcon(".idea/Image7.jpg");
//    ImageIcon image8 = new ImageIcon(".idea/Image8.jpg");
//    ImageIcon image9 = new ImageIcon(".idea/Image9.jpg");
//    ImageIcon image10 = new ImageIcon(".idea/Image10.jpg");
//    ImageIcon image11 = new ImageIcon(".idea/Image11.jpg");
//    ImageIcon image12= new ImageIcon(".idea/Image12.jpg");




    public void makeimagelist()
    {
        int i = 1;
        while (i<13){
            images[i-1] = new ImageIcon(".idea/Image" + i + ".jpg");
            i++;
        }
    }












    public void makeframe()
    {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel.setBounds(300,0,1620,1080);




    }












    public ImageSwitcher() {
        makeimagelist();
        shuffled();
        JFrame frame = new JFrame();
        frame.setLayout(null);
        setTitle("Memory Game");
        panel.setBounds(300, 0, 1620, 1080);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.setLocation(0,0);
        stopwatch.setBounds(0,0,300,1080);
        frame.add(stopwatch, BorderLayout.WEST);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);




        for (int i = 0; i < 24; i++) {
            JButton button = new JButton(facedown);
            int index = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!canclick || buttsClicked[index]||count>1) return;
                    System.out.println(count);

                    if (count<2)
                    {
                        button.setIcon(shuffledImages.get(index));
                        buttsClicked[index] = true;
                        indices.add(index);
                        count++;
                    }

                    // Check if two buttons are clicked
                    if (indices.size() % 2 == 0)
                    {
//                        canclick=false;
                        int lastIndex = indices.size() - 2;
                        if (shuffledImages.get(indices.get(lastIndex)).equals(shuffledImages.get(indices.get(lastIndex + 1))))
                        {
                            pairsGuessed++;
                            count=0;
                            if (pairsGuessed == 12)
                            {
                                JOptionPane.showMessageDialog(frame, "You won!");
                                stopwatch.reset();
                            }
                        }
                        else
                        {
                            Timer timer = new Timer(500, new ActionListener()
                            {
                                public void actionPerformed(ActionEvent evt)
                                {
                                    button.setIcon(facedown);
                                    JButton lastButton = (JButton) panel.getComponent(indices.get(lastIndex));
                                    lastButton.setIcon(facedown);
                                    buttsClicked[indices.get(lastIndex)] = false;
                                    buttsClicked[indices.get(lastIndex + 1)] = false;
                                    indices.remove(indices.size() - 1);
                                    indices.remove(indices.size() - 1);
                                    count=0;
                                }
                            });
                            timer.setRepeats(false);
                            timer.start();

                        }

                    }

                }
            });
            panel.add(button);
        }




        // Add stopwatch or other components if needed
    }




















//    public Image[] getFlics()
//    {
//        return inUseFlics;
//    }
//    public ImageSwitcher() {
//        loadImages();
//        initializeArrays();
////        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        makeButtons();
//        shuffle(inUseFlics);
//        pack();
//        setLayout(null);
//        Stopwatch stopwatch = new Stopwatch();
//        stopwatch.setLocation(0,0);
//        stopwatch.setBounds(0,0,300,1080);
//        shuffle(inUseFlics);
//        add(stopwatch, BorderLayout.WEST);
//        pack();
//
//        revalidate(); // Trigger the paint method after loading the images
//        // Stopwatch stopwatch = new Stopwatch();
//        // Create and add button
////        Buttons buttons = new Buttons();
//
////        getContentPane().add(buttons, BorderLayout.EAST);
//        repaint();
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setResizable(false);
//        setVisible(true);
//        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
//    }




//    private void initializeArrays() {
//        flics = new Image[]{image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13};
//        Collections.addAll(possibleUseFlics, flics);
//
//        for (int i = 0; i < 23; i += 2) {
//            int num = (int) (Math.random() * possibleUseFlics.size());
//            inUseFlics[i] = possibleUseFlics.get(num);
//            inUseFlics[i + 1] = possibleUseFlics.get(num);
//            possibleUseFlics.remove(num);
//        }
//    }




//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        startBoard(inUseFlics, g);
//    }




//    private void startBoard(Image[] ar, Graphics g) {
//        int count = 0;
//        for (int i = 0; i < yCoords.length; i++) {
//            for (int j = 0; j < xCoords.length; j++) {
////                g.drawImage(ar[count], xCoords[j], yCoords[i], 255, 255, null);
//                g.drawImage(image0, xCoords[j], yCoords[i], 255, 255, null);
//                count++;
//            }
//        }
//    }




//    public void shuffle(Image[] ar) {
//        Random rnd = ThreadLocalRandom.current();
//        for (int i = ar.length - 1; i > 0; i--) {
//            int index = rnd.nextInt(i + 1);
//            Image a = ar[index];
//            ar[index] = ar[i];
//            ar[i] = a;
//        }
//    }




//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            new ImageSwitcher();
//        });
//    }




//    public static int[] getXCoords(){
//        return xCoords;
//    }
//    public static int[] getYCoords(){
//        return yCoords;
//    }




//    private void loadImages() {
//        MediaTracker tracker = new MediaTracker(this);
//        image0 = Toolkit.getDefaultToolkit().getImage(".idea/Image0.jpg");
//        tracker.addImage(image0, 0);
//        image1 = Toolkit.getDefaultToolkit().getImage(".idea/Image1.jpg");
//        tracker.addImage(image1, 1);
//        image2 = Toolkit.getDefaultToolkit().getImage(".idea/Image2.jpg");
//        tracker.addImage(image2, 2);
//        image3 = Toolkit.getDefaultToolkit().getImage(".idea/Image3.jpg");
//        tracker.addImage(image3, 3);
//        image4 = Toolkit.getDefaultToolkit().getImage(".idea/Image4.jpg");
//        tracker.addImage(image4, 4);
//        image5 = Toolkit.getDefaultToolkit().getImage(".idea/Image5.jpg");
//        tracker.addImage(image5, 5);
//        image6 = Toolkit.getDefaultToolkit().getImage(".idea/Image6.jpg");
//        tracker.addImage(image6, 6);
//        image7 = Toolkit.getDefaultToolkit().getImage(".idea/Image7.jpg");
//        tracker.addImage(image7, 7);
//        image8 = Toolkit.getDefaultToolkit().getImage(".idea/Image8.jpg");
//        tracker.addImage(image8, 8);
//        image9 = Toolkit.getDefaultToolkit().getImage(".idea/Image9.jpg");
//        image10 = Toolkit.getDefaultToolkit().getImage(".idea/Image10.jpg");
//        tracker.addImage(image10, 10);
//        image11 = Toolkit.getDefaultToolkit().getImage(".idea/Image11.jpg");
//        tracker.addImage(image11, 11);
//        image12 = Toolkit.getDefaultToolkit().getImage(".idea/Image12.jpg");
//        tracker.addImage(image12, 12);
//        image13 = Toolkit.getDefaultToolkit().getImage(".idea/Image13.jpg");
//        tracker.addImage(image13, 13);
//        try {
//            tracker.waitForAll();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }








//    public void makeButtons()
//    {
//        int count = 0;
//        for (int i = 0; i < yCoords.length; i++) {
//            for (int j = 0; j < xCoords.length; j++) {
//                butts[count] = new ButtonTest(xCoords[j], yCoords[i], imageIcon0);
//                butts[count].buttParameters();
//                butts[count].addActionListener(this);
//                add(butts[count]);
//                count++;
//            }
//        }
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
////        for (int i =0; i<24; i++)
//
//        if (e.getSource() == butts[0] && !butts[0].getClicked()) {
//            butts[0].setClicked();
//            getGraphics().drawImage(inUseFlics[butts[0].getFlicIndex()], butts[0].getxCoord(), butts[0].getyCoord(), 255, 255, this);  // Trigger a repaint to display the image
//            System.out.println("action performed");
//        }
//    }




//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (ButtonTest button : butts) {
//            if (e.getSource() == button && !button.getClicked()) {
//                button.setClicked();
//                getGraphics().drawImage(inUseFlics[button.getFlicIndex()], button.getxCoord(), button.getyCoord(), 255, 255, this);
//                System.out.println("Button clicked");
//                break;  // Break to handle only one button click
//            }
//        }
//    }
}





