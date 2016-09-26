import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Created by DaMasterHam on 04-09-2016.
//

// is that same as Ch11Ex13 isUnique()

public class Exercise_B_15 // Ch11Ex16
{
    public static boolean is1to1(Map<String, String> map)
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
        System.out.println("Map a is 1 to 1? " + is1to1(a));

        System.out.println(b.toString());
        System.out.println("Map b is 1 to 1? " + is1to1(b));


    }


}
