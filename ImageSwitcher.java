import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class ImageSwitcher extends Frame {
    private Image image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16, image17, image18;
    private final Image[] flics;
    private Image[] inUseFlics = new Image[12];
    private final ArrayList<Image> possibleUseFlics = new ArrayList<Image>();
    private ArrayList<Image> tempFlics;
    private Image[] boardPositions;
    private int[] xCoords = {370,635,900,1665,1430,1655};
    private int[] yCoords = {7, 275,543,811, };
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
        flics = new Image[] {image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13};
        for (int i = 0; i < flics.length; i++){possibleUseFlics.add(flics[i]);}
        tempFlics = possibleUseFlics;
//set up in use array and photos that will be used for round\
        for (int i = 0; i < 12; i++) {
            int num = (int) (Math.random() * tempFlics.size());
            inUseFlics[i] = tempFlics.get(num);
            tempFlics.remove(num);
        }
        //board array

        // to come soon
        setTitle("Memory Game");
        setSize(1920, 1080);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                imageCount++;
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {

        g.drawImage(flics[imageCount-1], 0, 0, 260, 260, this);
        }

    }
//https://code-with-me.global.jetbrains.com/WptY_V284YoIrGIFuFOUQQ#p=IC&fp=519A6C9894CC7F47097267E648EE6AFDBC4248D9C3AFE83137AE785C8E7E4417
