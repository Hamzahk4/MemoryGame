import java.util.Scanner;


public class Person
{
    private String name;
    private int timeused;

    private int seconds = 0;
    private int minutes = 0;
    private int millisec = 0;

    Person(String x, int y)
    {
        name = x;
        timeused = y;
        millisec = (y/ 10) % 100;
        minutes = (y / 60000) % 60;
        seconds = (y / 1000) % 60;
    }

    public Person()
    {
    }

//    public String askname()
//    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What's your name");
//
//        String name = scanner.nextLine();
//        return name;
//
//    }

    public int gettime()
    {
        return timeused;
    }

    public String getName()
    {
        return name;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getMillisec()
    {
        return millisec;
    }

    public String toString()
    {
        return name + " Time: " + minutes + ":" + seconds + ":" + millisec;
    }

}