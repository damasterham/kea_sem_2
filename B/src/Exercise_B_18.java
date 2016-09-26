import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_18 // Ch11Ex19
{
    public static int rarest(Map<String,Integer> map) throws NullPointerException
    {
        if (map.isEmpty())
        {
            throw new NullPointerException("map parameter is empty.");
        }

        Map<Integer, Integer> counter;
        int count;
        int rare = 0;
        int rareCount = 100000; // just a high standard nr

        counter = new TreeMap<>();

        for (Integer i : map.values())
        {
            if (counter.containsKey(i))
            {
                count = counter.get(i);
                count++;
                counter.put(i, count);
            }
            else
            {
                counter.put(i,1);
            }
        }

        for (Integer key : counter.keySet())
        {
            int value;

            value = counter.get(key);

            if (rareCount > value || rareCount == value && rare > key)
            {
                rare = key;
                rareCount = value;
            }
        }

        return rare;
    }


    public static void main(String[] args)
    {
        Map<String,Integer> a;

        a = new HashMap<>();

        a.put("1",1);
        a.put("2",2);
        a.put("3",3);
        a.put("NameDoesntMatter",4);
        a.put("4",1);
        a.put("5",2);
        a.put("6",3);
        a.put("NameDoesntMatter2",4);
        a.put("4",1);
        a.put("5",90);
        a.put("6",3);
        a.put("NameDoesntMatter2",7);

        System.out.println(a);

        try
        {
            System.out.println("The lowest and rarest number is " + rarest(a));
        }
        catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }


    }
}
