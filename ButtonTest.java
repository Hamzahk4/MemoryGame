import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
public class ButtonTest extends JFrame implements ActionListener{
    private JButton button1;
    private int yCoord;
    private int xCoord;
    private int[] xCoords = ImageSwitcher.getXCoords();
    private int[] yCoords = ImageSwitcher.getYCoords();
    private int flicIndex;
    private Image imgAtIndex;
    public static Image[] inUseFlics;
    private boolean clicked = false;

    public ButtonTest(int x, int y){
        xCoord = x;
        yCoord = y;
        buttonCreation();
        setInUseFlics();
        setImage();

    }
    public boolean getClicked(){
        return clicked;
    }
    public void buttonCreation(){
        buttonInitialize();
        addToFrame();
        buttParameters();
        printButts();
    }

    public void buttParameters() {

        button1.addActionListener(this);
        button1.setVisible(false);
    }
    public void buttonInitialize(){
        button1 = new JButton("");}

    public void addToFrame() {
        setLayout(new FlowLayout());
        add(button1);
    }
    public int indexOfCoords(int[] ar, int target){
       int count = 0;
        for(int i : ar){
           if (i == target) return count;
           else count++;
        }
        return -1;
    }
    public static void setInUseFlics(){
        inUseFlics = ImageSwitcher.inUseFlics;
    }

    public void paint(Graphics g) {
        super.paint(g);
        paintBoard(g);
    }
    public void paintBoard(Graphics g){
       g.drawImage(imgAtIndex, xCoord,yCoord, 255, 255, this);
    }
    public void setImage(){
        int ind = 0;
        int xInd = indexOfCoords(xCoords, xCoord); int yInd = indexOfCoords(yCoords, yCoord);
//                yInd++; xInd++;
        yInd = yInd * 6;
        ind = yInd + xInd;
        flicIndex = ind;
        imgAtIndex = inUseFlics[ind];
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
            if (!clicked) {
                clicked = !clicked;

                repaint();


            }
        }
    }

    private void printButts() {setBounds(xCoord, yCoord, 255, 255);}
}
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.awt.event.ActionListener;
//public class ButtonTest extends JFrame implements ActionListener{
//    private JButton button1;
//    private int yCoord;
//    private int xCoord;
//    private int[] xCoords = ImageSwitcher.getXCoords();
//    private int[] yCoords = ImageSwitcher.getYCoords();
//    private int flicIndex;
//    private Image imgAtIndex;
//    public static Image[] inUseFlics;
//    private boolean clicked = false;
//
//    public ButtonTest(int x, int y){
//        xCoord = x;
//        yCoord = y;
//        buttonCreation();
//        setInUseFlics();
//        setImage();
//
//    }
//    public boolean getClicked(){
//        return clicked;
//    }
//    public void buttonCreation(){
//        buttonInitialize();
//        addToFrame();
//        buttParameters();
//        printButts();
//    }
//
//    public void buttParameters() {
//
//        button1.addActionListener(this);
//        button1.setVisible(false);
//    }
//    public void buttonInitialize(){
//        button1 = new JButton("");}
//
//    public void addToFrame() {
//        setLayout(new FlowLayout());
//        add(button1);
//    }
//    public int indexOfCoords(int[] ar, int target){
//       int count = 0;
//        for(int i : ar){
//           if (i == target) return count;
//           else count++;
//        }
//        return -1;
//    }
//    public static void setInUseFlics(){
//        inUseFlics = ImageSwitcher.inUseFlics;
//    }
//
//    public void paint(Graphics g) {
//        super.paint(g);
//        paintBoard(g);
//    }
//    public void paintBoard(Graphics g){
//       g.drawImage(imgAtIndex, xCoord,yCoord, 255, 255, this);
//    }
//    public void setImage(){
//        int ind = 0;
//        int xInd = indexOfCoords(xCoords, xCoord); int yInd = indexOfCoords(yCoords, yCoord);
////                yInd++; xInd++;
//        yInd = yInd * 6;
//        ind = yInd + xInd;
//        flicIndex = ind;
//        imgAtIndex = inUseFlics[ind];
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == button1){
//            if (!clicked) {
//                clicked = !clicked;
//
//                repaint();
//
//
//            }
//        }
//    }
//
//    private void printButts() {setBounds(xCoord, yCoord, 255, 255);}
//}
