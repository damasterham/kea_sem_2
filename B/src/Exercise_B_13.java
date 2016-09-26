import com.sun.javafx.image.IntPixelGetter;

import java.util.HashMap;
import java.util.Map;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_13 // Ch11Ex14
{
    public static Map<String,Integer> intersect(Map<String, Integer> mapA, Map<String, Integer> mapB)
    {
        Map<String,Integer> result;
        Integer value;

        result = new HashMap<>();

        for (String key : mapA.keySet())
        {
            if (mapB.containsKey(key))
            {
                value = mapA.get(key);

                if (mapB.get(key).equals(value))
                {
                    result.put(key, value);
                }
            }
        }

        return result;
    }


    public static void main(String[] args)
    {
        Map<String,Integer> a;
        Map<String,Integer> b;
        Map<String,Integer> c;

        a = new HashMap<>();
        b = new HashMap<>();

        a.put("Karl", 1);
        a.put("Lone", 2);
        a.put("Egon", 3);
        a.put("Sups", 4);
        a.put("Ken", 5);




        b.put("Karl", 1);
        b.put("Lone", 9);
        b.put("Egon", 3);
        b.put("Sups", 4);
        b.put("Ken", 20);



        System.out.println(a.toString());
        System.out.println(b.toString());

        c = intersect(a,b);

        System.out.println("Intersected maps of people " + c.toString());
    }
}
