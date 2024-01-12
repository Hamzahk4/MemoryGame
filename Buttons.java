import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Buttons extends JFrame implements ActionListener{
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12,button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24;
    private JButton[] allDaButts = new JButton[24];
    private final int[] xCoords = new int[]{310,585 ,855, 1125, 1395, 1665};
    private final int[] yCoords = new int[]{0, 265, 530, 795};

    public Buttons() {
        allDaButts = new JButton[] {button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12,button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24};
        buttonCreation();
        button11.setBounds(0,0,200,200);
    }
    private void buttonCreation(){
        buttonInitialize();
        printButts();
        addToFrame();
    }
    private void printButts() {
        int count = 0;
        for (int i = 0; i < yCoords.length; i++) {
            for (int j = 0; j < xCoords.length; j++) {
                allDaButts[count].setBounds(xCoords[j], yCoords[i], 255, 255);
                count++;
            }
        }
    }
    public void addToFrame() {
        setLayout(new FlowLayout());
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);
        add(button11);
        add(button12);
        add(button13);
        add(button14);
        add(button15);
        add(button16);
        add(button17);
        add(button18);
        add(button20);
        add(button21);
        add(button22);
        add(button23);
        add(button24);
    }
    public void buttonInitialize(){
        button1 = new JButton("");
        button2 = new JButton("");
        button3 = new JButton("");
        button4 = new JButton("");
        button5 = new JButton("");
        button6 = new JButton("");
        button7 = new JButton("");
        button8 = new JButton("");
        button9 = new JButton("");
        button10 = new JButton("");
        button11 = new JButton("");
        button11.setFont(new Font("Ink Free", Font.PLAIN, 20));
        button11.setFocusable(false);
        button12 = new JButton("");
        button13 = new JButton("");
        button14 = new JButton("");
        button15 = new JButton("");
        button16 = new JButton("");
        button17 = new JButton("");
        button18 = new JButton("");
        button19 = new JButton("");
        button20 = new JButton("");
        button21 = new JButton("");
        button22 = new JButton("");
        button23 = new JButton("");
        button24 = new JButton("BOO");
        allDaButts = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20, button21, button22, button23, button24};
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
    private void buttParameters(){

        button1.addActionListener(this);
        button1.setVisible(false);
        add(button1);

        button2.addActionListener(this);
        button2.setVisible(false);
        add(button2);

        button3.addActionListener(this);
        button3.setVisible(false);
        add(button3);

        button4.addActionListener(this);
        button4.setVisible(false);
        add(button4);

        button5.addActionListener(this);
        button5.setVisible(false);
        add(button5);

        button6.addActionListener(this);
        button6.setVisible(false);
        add(button6);

        button7.addActionListener(this);
        button7.setVisible(false);
        add(button7);

        button8.addActionListener(this);
        button8.setVisible(false);
        add(button8);

        button9.addActionListener(this);
        button9.setVisible(false);
        add(button9);

        button10.addActionListener(this);
        button10.setVisible(true);
        add(button10);

        button11.addActionListener(this);
        button11.setVisible(true);
        add(button11);

        button12.addActionListener(this);
        button12.setVisible(true);
        add(button12);

        button13.addActionListener(this);
        button13.setVisible(false);
        add(button13);

        button14.addActionListener(this);
        button14.setVisible(false);
        add(button14);

        button15.addActionListener(this);
        button15.setVisible(false);
        add(button15);

        button16.addActionListener(this);
        button16.setVisible(false);
        add(button16);

        button17.addActionListener(this);
        button17.setVisible(false);
        add(button17);

        button18.addActionListener(this);
        button18.setVisible(false);
        add(button18);

        button19.addActionListener(this);
        button19.setVisible(false);
        add(button19);

        button20.addActionListener(this);
        button20.setVisible(false);
        add(button20);

        button21.addActionListener(this);
        button21.setVisible(false);
        add(button21);

        button22.addActionListener(this);
        button22.setVisible(true);
        add(button22);

        button23.addActionListener(this);
        button23.setVisible(true);
        add(button23);

        button24.addActionListener(this);
        button24.setVisible(true);
        add(button24);
    }
}
