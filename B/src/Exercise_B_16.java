import java.util.HashMap;
import java.util.Map;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_16 // Ch11Ex17
{
    public static boolean subMap(Map<String,String> sub, Map<String,String> parent)
    {
        if (sub.size() >= parent.size())
        {
            return false;
        }

        String value;

        for (String key : sub.keySet())
        {
            if (parent.containsKey(key))
            {
                value = sub.get(key);

                if (parent.get(key).equals(value) == false)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args)
    {
        Map<String,String> a;
        Map<String,String> b;
        Map<String,String> c;
        Map<String,String> d;

        a = new HashMap<>();
        b = new HashMap<>();
        c = new HashMap<>();
        d = new HashMap<>();

        a.put("Karl", "Polo");
        a.put("Lone", "Spral");
        a.put("Egon", "Fups");

        b.put("Lone", "Spral");
        b.put("Egon", "Fups");

        c.put("Shultz", "Kronborg");
        c.put("Egon", "Fups");

        d.put("Karl", "Kronborg");
        d.put("Egon", "Fups");

        System.out.println("A: " + a.toString()+"\n");
        System.out.println("B: " + b.toString());

        System.out.println("Is B a sub map of A? " + subMap(b,a));
        System.out.println("Is A a sub map of B? " + subMap(a,b));

        System.out.println("C: " + c.toString());
        System.out.println("Is C a sub map of A? " + subMap(c,a));

        System.out.println("D: " + d.toString());
        System.out.println("Is D a sub map of A? " + subMap(c,a));



    }
}
