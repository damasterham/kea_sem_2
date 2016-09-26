//Created by DaMasterHam on 16-09-2016.
//
// Represents a time span of hours and minutes elapsed.
// Class invariant: minutes < 60

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise_C_8 implements Comparable<Exercise_C_8>
{
    private int hours;
    private int minutes;

    // Constructs a time span with the given interval.
    // pre: hours >= 0 && minutes >= 0
    public Exercise_C_8(int hours, int minutes)
    {
        this.hours = 0;
        this.minutes = 0;
        add(hours, minutes);
    }

    // Adds the given interval to this time span.
    // pre: hours >= 0 && minutes >= 0
    public void add(int hours, int minutes)
    {
        this.hours += hours;
        this.minutes += minutes;

        // convert each 60 minutes into one hour
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
    }

    // Returns whether o is a Exercise_C_8 representing the same
    // number of hours and minutes as this Exercise_C_8 object.
    public boolean equals(Object o)
    {
        if (o instanceof Exercise_C_8) {
            Exercise_C_8 other = (Exercise_C_8) o;
            return hours == other.hours &&
                    minutes == other.minutes;
        } else {   // not a Exercise_C_8 object
            return false;
        }
    }

    // Returns a String for this time span such as "6h15m".
    public String toString()
    {
        return hours + "h" + minutes + "m";
    }


    // Ch10Ex19
    public int compareTo(Exercise_C_8 other)
    {
        int comparison;

        comparison = Integer.compare(hours, other.hours);

        if (comparison == 0)
        {
            comparison = Integer.compare(minutes, other.minutes);
        }

        return comparison;
    }


    public static void main(String[] args)
    {
        Exercise_C_8 a;
        Exercise_C_8 b;
        Exercise_C_8 c;
        Exercise_C_8 d;
        Exercise_C_8 e;
        List<Exercise_C_8> array;

        a = new Exercise_C_8(4,50);
        b = new Exercise_C_8(1,8);
        c = new Exercise_C_8(2,3);
        d = new Exercise_C_8(4,30);
        e = new Exercise_C_8(4,70);
        array = new ArrayList<Exercise_C_8>();
        array.add(a);
        array.add(b);
        array.add(c);
        array.add(d);
        array.add(e);

        System.out.println(array.toString());

        Collections.sort(array);

        System.out.println(array.toString());
    }
}
