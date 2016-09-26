import java.util.*;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_12 // Ch11Ex13
{
    public static boolean isUnique(Map<String,String> map)
    {
        Set<String> set;

        set = new HashSet<>();

        for (String s : map.values())
        {
            if (set.add(s) == false)
            {
                return false;
            }
        }

        return  true;
    }


    public static void main(String[] args)
    {
        Map<String,String> a;
        Map<String,String> b;

        a = new HashMap<>();

        b = new HashMap<>();

        a.put("Karl", "1");
        a.put("Lone", "2");
        a.put("Egon", "3");
        a.put("Sups", "4");
        a.put("Ken", "5");

        b.put("Karl", "1");
        b.put("Lone", "2");
        b.put("Egon", "2");
        b.put("Sups", "4");
        b.put("Ken", "5");


        System.out.println(a.toString());
        System.out.println("Map a is unique? " + isUnique(a));

        System.out.println(b.toString());
        System.out.println("Map b is unique? " + isUnique(b));


    }
}
