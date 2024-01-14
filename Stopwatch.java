import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JTextField;


public class Stopwatch extends JPanel implements ActionListener {


    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    private int elapsedTime = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int millisec = 0;


    private String leadername1 = "N/A";
    private String leadername2 = "N/A";
    private String leadername3 = "N/A";


    Person person = new Person();




    ArrayList<Person> leaders = new ArrayList<Person>();


    private String name;
    private int leaderboard1=0;
    private int leaderboard2=0;
    private int leaderboard3=0;


    private boolean started = false;
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String millisec_string = String.format("%02d", millisec);


    JTextArea leaderboardframe1 = new JTextArea();


    Timer timer = new Timer(1, new ActionListener() {


        public void actionPerformed(ActionEvent e) {


            elapsedTime = elapsedTime + 16;
            millisec = (elapsedTime / 10) % 100;
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            millisec_string = String.format("%02d", millisec);
            timeLabel.setText(minutes_string + ":" + seconds_string + ":" + millisec_string);


        }


    });

    public Stopwatch() {
        setBounds(0,0,300,1080);
        setupleaderboard();
        setLayout(null);


        timeLabel.setText(minutes_string + ":" + seconds_string + ":" + millisec_string);
        timeLabel.setBounds(50, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);


        startButton.setBounds(50, 200, 200, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);


        resetButton.setBounds(50, 250, 200, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);






        add(startButton);
        add(resetButton);
        add(timeLabel);







//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 1080);
//        frame.setLayout(null);
//        frame.setVisible(true);


        leaders.add(new Person("EX",20000000));
        leaders.add(new Person("EX",20000000));

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == startButton) {


            if (!started) {
                started = true;
                startButton.setText("STOP");
                start();
            } else {
                started = false;
                startButton.setText("START");
                stop();
            }


        }
        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reset();
        }


    }
    void start() {
        timer.start();
    }


    void stop() {
        timer.stop();
    }


    void reset() {
        timer.stop();


        // Use JOptionPane to get user input for name
        String enteredName = JOptionPane.showInputDialog("Enter your name:");

        if (enteredName != null && !enteredName.isEmpty()) {
            // Assign only the first five letters of the input to the name variable
            name = enteredName.substring(0, Math.min(enteredName.length(), 5));
        } else {
            // Default name if the user cancels or enters an empty name
            name = "Anon";
        }

        // Update the leaderboard after getting the user's name
        updateleaderboard();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        millisec = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        millisec_string = String.format("%02d", millisec);
        timeLabel.setText(minutes_string + ":" + seconds_string + ":" + millisec_string);

    }






    public void updateleaderboard()
    {
//        name = person.askname();
        leaders.add(new Person(name,elapsedTime));
        leaders.sort(Comparator.comparing(Person::gettime));
        Person person1 = (Person)(leaders.get(0));
        Person person2 = (Person)(leaders.get(1));
        Person person3 = (Person)(leaders.get(2));
        System.out.println(leaders);
        int a = person1.getMinutes();
        int b = person2.getMinutes();
        int c = person3.getMinutes();
        int d = person1.getSeconds();
        int e = person2.getSeconds();
        int f = person3.getSeconds();
        int g= person1.getMillisec();
        int h= person2.getMillisec();
        int i= person3.getMillisec();
        String a_string = String.format("%02d", a);
        String b_string = String.format("%02d", b);
        String c_string = String.format("%02d", c);
        String d_string = String.format("%02d", d);
        String e_string = String.format("%02d", e);
        String f_string = String.format("%02d", f);
        String g_string = String.format("%02d", g);
        String h_string = String.format("%02d", h);
        String i_string = String.format("%02d", i);

        leaderboardframe1.setText( "1." +  person1.getName() + "    " + a_string+ ":" + d_string+ ":" + g_string+
                "\n\n2." +  person2.getName() + "    " + b_string+ ":" + e_string+ ":" + h_string+
                "\n\n3." +  person3.getName() + "    " + c_string+ ":" + f_string+ ":" + i_string);

    }


    public void setupleaderboard()
    {
        leaderboardframe1.setText( "1." +  leadername1 + "      00:00:00"  + "\n\n 2." +  leadername2 +  "     00:00:00" + "\n\n 3." +  leadername3 +  "     00:00:00");
        leaderboardframe1.setBounds(0, 600, 300, 300);
        leaderboardframe1.setFont(new Font("Arial", Font.PLAIN, 30));
        leaderboardframe1.setBorder(BorderFactory.createBevelBorder(0));
        add(leaderboardframe1);
    }





}
