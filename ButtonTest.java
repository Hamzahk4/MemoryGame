//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.awt.event.ActionListener;
//public class ButtonTest extends JButton implements ActionListener {
//    private JButton button1;
//    private int yCoord;
//    private int xCoord;
//    private int[] xCoords = ImageSwitcher.getXCoords();
//    private int[] yCoords = ImageSwitcher.getYCoords();
//    private int flicIndex;
//    private Image imgAtIndex;
//    private ImageIcon img;
//    public static Image[] inUseFlics;
//    private boolean clicked = false;
//
//    public ButtonTest(int x, int y, ImageIcon i) {
//        xCoord = x;
//        yCoord = y;
//        buttonCreation();
//        setInUseFlics();
//        setImage();
//        img = i;
//    }
//public int getxCoord(){return xCoord;}
//    public int getyCoord(){return yCoord;}
//    public boolean getClicked() {
//        return clicked;
//    }
//    public void setClicked(){clicked = !clicked;}
//
//    public void buttonCreation() {
//        buttonInitialize();
//        addToFrame();
//        buttParameters();
//        printButts();
//        System.out.println("ButonCreation runs");
//    }
//
//    public void buttParameters() {
////        button1.addActionListener(this);  // Add ActionListener to the button
////        button1.setActionCommand("buttonClicked");  // Set action command for identification
//        System.out.println("Button parameters run");
//    }
//
//    public void buttonInitialize() {
//        //JButton button1 = new JButton(img);
//        this.setVisible(false);
// System.out.println("Button initalizeds");
//}
//    public void addToFrame() {
//        setLayout(new FlowLayout());
//        //add(this);
//        System.out.println("added to frame");
//    }
//    public int indexOfCoords(int[] ar, int target){
//       int count = 0;
//        for(int i : ar){
//            System.out.println("indexof coords runs");
//           if (i == target) return count;
//           else count++;
//        }
//        return -1;
//    }
//    public static void setInUseFlics(){
//        inUseFlics = ImageSwitcher.inUseFlics;  System.out.println("setinuseflics runs");
//    }
//
//    public void paint(Graphics g) {
//        super.paint(g);
//        paintBoard(g);
//        System.out.println("paint runs");
//    }
//    public void paintBoard(Graphics g){
//       g.drawImage(imgAtIndex, xCoord,yCoord, 255, 255, this);
//        System.out.println("paintboard runs");
//    }
//
//
//    public void setImage(){
//        int ind = 0;
//        int xInd = indexOfCoords(xCoords, xCoord); int yInd = indexOfCoords(yCoords, yCoord);
////                yInd++; xInd++;
//        yInd = yInd * 6;
//        ind = yInd + xInd;
//        flicIndex = ind;
//        imgAtIndex = inUseFlics[ind];
//        System.out.println("setimage runs");
//    }
//    public int getFlicIndex(){return flicIndex;}
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if ("buttonClicked".equals(e.getActionCommand()) && !clicked) {
//            clicked = true;
//            repaint();  // Trigger a repaint to display the image
//            System.out.println("Button clicked");
//        }
//    }
//
//
//    public void printButts() {setBounds(xCoord, yCoord, 255, 255);}
//}
