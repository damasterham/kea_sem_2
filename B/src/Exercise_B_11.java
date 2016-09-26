import java.util.*;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_11 // Ch11Ex12
{
    public static boolean contains3(List<String> list)
    {
        Map<String, Integer> map;
        int count;

        map = new HashMap<>();

        for (String s : list)
        {
            if (map.containsKey(s)) // count up
            {
                count = map.get(s);
                count++;
                map.put(s, count);
            }
            else // add string with 1 count
            {
                map.put(s,1);
            }
        }

        for (Integer i : map.values())
        {
            if (i >= 3)
            {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args)
    {
        List<String> a;
        List<String> b;

        a = new ArrayList<>(Arrays.asList("Woopti","Wooptidoodles", "Wooples", "Woop", "WoopWoop","Woop", "Wopple"));
        b = new ArrayList<>(Arrays.asList("Woopti","Wooptidoodles","Woop", "Wooples", "Woop", "WoopWoop","Woop", "Wopple"));

        System.out.println(a.toString());
        System.out.println("Contains at least 3 duplicates? " + contains3(a));

        System.out.println(b.toString());
        System.out.println("Contains at least 3 duplicates? " + contains3(b));
    }
}
