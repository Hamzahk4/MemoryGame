import java.awt.*;
import java.awt.event.*;
public class ImageSwitcher extends Frame {
    private Image image1, image2;
    private boolean switchImages = false;
    public ImageSwitcher() { image1 = Toolkit.getDefaultToolkit().getImage("C:/Users/BT_1N3_32/Downloads/Image1.jpeg");
        image2 = Toolkit.getDefaultToolkit().getImage("C:/Users/BT_1N3_32/Downloads/Image2.jpeg");
        setTitle("Image Switcher");
        setSize(1920, 1080);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switchImages = !switchImages; repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        if (switchImages) {
            g.drawImage(image2, 0, 0, 1920, 1080, this);
        } else { g.drawImage(image1, 0, 0, 1920, 1080, this);
        }
    }
}
