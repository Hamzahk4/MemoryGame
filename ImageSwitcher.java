



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
    private ArrayList<Integer> indices = new ArrayList<Integer>();
    private ImageIcon[] images = new ImageIcon[12];
    private List<ImageIcon> shuffledImages = new ArrayList<>();

    public ImageSwitcher() {
        makeimagelist();
        shuffled();
        JFrame frame = new JFrame();
        frame.setLayout(null);
        setTitle("Memory Game");
        panel.setBounds(300, 0, 1620, 1010);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Stopwatch stopwatch = new Stopwatch(new Person());
        stopwatch.setLocation(0, 0);
        stopwatch.setBounds(0, 0, 300, 1080);
        frame.add(stopwatch, BorderLayout.WEST);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);


        for (int i = 0; i < 24; i++) {
            JButton button = new JButton(facedown);
            int index = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopwatch.start();

                    if (!canclick || buttsClicked[index] || count > 1) return;
//                    System.out.println(count);

                    if (count < 2) {
                        button.setIcon(shuffledImages.get(index));
                        buttsClicked[index] = true;
                        indices.add(index);
                        count++;
                    }
                    int temp = 0;
                    for (int t = 0; t < 24; t++) {
                        if (buttsClicked[t] == true) temp++;
                    }

                    // Check if two buttons are clicked
                    if (indices.size() % 2 == 0) {

                        int lastIndex = indices.size() - 2;
                        if (shuffledImages.get(indices.get(lastIndex)).equals(shuffledImages.get(indices.get(lastIndex + 1)))) {
                            pairsGuessed++;
                            count = 0;
                            if (pairsGuessed == 12) {
                                stopwatch.stop();
                                JOptionPane.showMessageDialog(frame, "You won!");
                                stopwatch.reset();
                                Playagain();
                            }
                        } else {
                            Timer timer = new Timer(500, new ActionListener() {
                                public void actionPerformed(ActionEvent evt) {
                                    button.setIcon(facedown);
                                    JButton lastButton = (JButton) panel.getComponent(indices.get(lastIndex));
                                    lastButton.setIcon(facedown);
                                    buttsClicked[indices.get(lastIndex)] = false;
                                    buttsClicked[indices.get(lastIndex + 1)] = false;
                                    indices.remove(indices.size() - 1);
                                    indices.remove(indices.size() - 1);
                                    count = 0;
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
oneLessPpl();
    }
    public static int getxCoords(int column){
        return xCoords[column-1];
    }
    public static int getyCoords(int row){
        return yCoords[row-1];
    }
    public void shuffled()
    {
        for (ImageIcon images:images)
        {
            shuffledImages.add(images);
            shuffledImages.add(images);

        }
        Collections.shuffle(shuffledImages);
    }
    public void oneLessPpl(){
Person.totalPpl--;
    }


    public void makeimagelist()
    {
        int i = 1;
        while (i<13){
            images[i-1] = new ImageIcon(".idea/Image" + i + ".jpg");
            i++;
        }
    }

    public void Playagain() {
        // Custom button text
        Object[] options = {"Yes", "No"};

        int choice = JOptionPane.showOptionDialog(this,
                "Do you want to play again?",
                "Play Again",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     // Do not use a custom Icon
                options,  // The titles of buttons
                options[0]); // Default button title

        if (choice == JOptionPane.YES_OPTION)
        {
            resetGame();


        } else

            System.exit(0);
    }
    public int findTrues(int n) {
        int count = 0;
        while (n < buttsClicked.length) {
            if (buttsClicked[n] == true) return n;
            n++;
        }
            return -1;
        }
    public void resetGame() {
        // Reset game state
        pairsGuessed = 0;
        int countt = 0;
        indices.clear();
        for(int i =0; i<24;i++)
        {
            countt++;
            buttsClicked[i]=false;
        }

        // Reset buttons to facedown
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                button.setIcon(facedown);
            }
        }

        // Reshuffle images
        shuffledImages.clear();
        shuffled();
    }
}
