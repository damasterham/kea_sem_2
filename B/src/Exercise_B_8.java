import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_8 // Ch11Ex9
{
    public static boolean hasEven(Set<Integer> set)
    {
        if (set.isEmpty())
        {
            return false;
        }

        for (Integer i : set)
        {
            if ((i % 2) == 0)
            {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args)
    {
        Set<Integer> a;
        Set<Integer> b;
        Set<Integer> c;


        a = new HashSet<>(Arrays.asList(1,3,5,7,9));
        b = new HashSet<>(Arrays.asList(1,3,5,8,9));
        c = new HashSet<>();


        System.out.println(a.toString() + " Contains even nubmer? " + hasEven(a));
        System.out.println(b.toString() + " Contains even nubmer? " + hasEven(b));
        System.out.println(c.toString() + " Contains even nubmer? " + hasEven(c));

    }
}
