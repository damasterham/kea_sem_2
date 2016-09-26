import java.util.*;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_5 // Ch11Ex6
{
    public static int countUnique(List<Integer> list)
    {
        Set<Integer> set;
        int count;

        set = new HashSet<>();
        count = 0;

        for (Integer i : list)
        {
            if (set.add(i))
            {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args)
    {
        ArrayList<Integer> a;
        int unique;

        a = new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,4,4,6,6,6,6,7,8,8,8,9,9,10));

        System.out.println(a.toString());

        unique = countUnique(a);

        System.out.println("nr of unique numbers = " + unique);
    }
}
