import java.util.*;

//Created by DaMasterHam on 04-09-2016.
//
public class Exercise_B_14 // Ch11Ex15
{
    public static int maxOccurrences(List<Integer> list)
    {
        if (list.isEmpty())
        {
            return 0;
        }

        Map<Integer,Integer> map;
        int count;
        int max;

        map = new HashMap<>();
        max = 0;

        for (Integer i : list)
        {
            if (map.containsKey(i))
            {
                count = map.get(i);
                count++;
                map.put(i, count);
            }
            else
            {
                map.put(i,1);
            }
        }

        for (Integer i : map.values())
        {
            if (max < i)
            {
                max = i;
            }
        }

        return max;
    }


    public static void main(String[] args)
    {
        List<Integer> a;

        a = new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,4,4,20,20,20,20,20,20,20,20,20,20,6,6,6,6,7,8,8,8,9,20,9,10));

        System.out.println(a.toString());

        System.out.println("Largest occurrence of most frequent number " + maxOccurrences(a));
    }
}
