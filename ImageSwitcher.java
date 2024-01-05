import java.awt.*;
import java.awt.event.*;
public class ImageSwitcher extends Frame {
    private Image image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16, image17, image18;
    private Image[] flics;
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
        image14 = Toolkit.getDefaultToolkit().getImage(".idea/Image14.jpg");
        image15 = Toolkit.getDefaultToolkit().getImage(".idea/Image15.jpg");
        image16 = Toolkit.getDefaultToolkit().getImage(".idea/Image16.jpg");
        image17 = Toolkit.getDefaultToolkit().getImage(".idea/Image17.jpg");
        image18 = Toolkit.getDefaultToolkit().getImage(".idea/Image18.jpg");
        flics = new Image[] {image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12, image13, image14, image15, image16, image17, image18};
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
//https://code-with-me.global.jetbrains.com/F4UfI5Rq-ZZTC3ZV9aVxwA#p=IC&fp=9ACA5DB17627033B459E5C57C493396F6083AF2ACB0E758E5CD6DE6DD8854129
