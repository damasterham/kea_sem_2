// The CalendarDate class stores information about a single calendar date
// (month and day but no year).

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise_C_9 implements Comparable<Exercise_C_9> {
    private int year;
    private int month;
    private int day;

    public Exercise_C_9(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Ch10Ex20
    public int compareTo(Exercise_C_9 other) {
        if (this.year != other.year)
        {
            return this.year - other.year;
        }
        else if (this.month != other.month) {
            return this.month - other.month;
        } else {
            return this.day - other.day;
        }
    }

    public int getYear()
    {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }


    public static void main(String[] args)
    {
        List<Exercise_C_9> list;
        Exercise_C_9 cal;
        Exercise_C_9 cal0;
        Exercise_C_9 cal1;
        Exercise_C_9 cal2;

        list = new ArrayList<Exercise_C_9>();
        cal = new Exercise_C_9(1990, 4,25);
        cal0 = new Exercise_C_9(1990, 4,20);
        cal1 = new Exercise_C_9(1990,1,1);
        cal2 = new Exercise_C_9(1800,2,4);



        list.add(cal);
        list.add(cal0);
        list.add(cal1);
        list.add(cal2);

        System.out.println(list.toString());

        Collections.sort(list);

        System.out.println(list.toString());

    }
}
