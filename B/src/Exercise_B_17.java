import java.util.*;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_17 // Ch11Ex18
{
    public static Map<String,List<String>> reverse(Map<String,String> map)
    {
        Map<String,List<String>> result;
        String newKey;

        result = new HashMap<>();

        for (String key : map.keySet())
        {
            newKey = map.get(key);

            if (result.containsKey(newKey))
            {
                result.get(newKey).add(key);
            }
            else
            {
                List<String> newValues;

                newValues = new ArrayList<>();

                newValues.add(key);

                result.put(newKey,newValues);
            }

        }

        return result;
    }


    public static void main(String[] args)
    {
        Map<String,String> a;
        Map<String,List<String>> b;

        a = new HashMap<>();

        a.put("Ben","10");
        a.put("Bently","10");
        a.put("Carlt","40");
        a.put("Woop","30");
        a.put("Lamoo","10");
        a.put("Lax","30");

        System.out.println(a.toString());

        b = reverse(a);

        System.out.println(b.toString());
    }
}
