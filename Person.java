import java.util.Scanner;


public class Person
{
    private String name;
    private int timeused;
    public static int totalPpl = 0;

    private int seconds = 0;
    private int minutes = 0;
    private int millisec = 0;

    public Person(String x, int y)
    {
        name = x;
        timeused = y;
        millisec = (y/ 10) % 100;
        minutes = (y / 60000) % 60;
        seconds = (y / 1000) % 60;
        totalPpl++;
    }

    public Person()
    {
        totalPpl++;
    }

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
