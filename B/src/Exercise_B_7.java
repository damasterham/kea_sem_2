import java.util.*;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_7 //Ex11Ch8
{
    public static int minLength(Set<String> set)
    {
        Iterator<String> itr;
        int element;
        int shortest;

        itr = set.iterator();
        shortest = 0;

        if (itr.hasNext())
        {
            shortest = itr.next().length();
        }

        while (itr.hasNext())
        {
            element = itr.next().length();

            if (element == 0)
            {
                return 0;
            }

            if (shortest > element)
            {
                shortest = element;
            }
        }

        return shortest;
    }


    public static void main(String[] args)
    {
        Set<String> a;

        int shortest;

        a = new HashSet<>(Arrays.asList("Woopti","Wooptidoodles", "Wooples", "Woop", "WoopWoop", "Wopple"));

        System.out.println(a.toString());

        shortest = minLength(a);

        System.out.println("Shortest word length = " + shortest);
    }
}
