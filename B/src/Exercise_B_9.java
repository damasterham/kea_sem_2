import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_9 // Ch11Ex10
{
    public static void removeOddLength(Set<String> set)
    {
        Iterator<String> itr;

        itr = set.iterator();

        while (itr.hasNext())
        {
            if ((itr.next().length() % 2) != 0)
            {
                itr.remove();
            }
        }
    }


    public static void main(String[] args)
    {
        Set<String> a;

        a = new HashSet<>(Arrays.asList("Woopti","Wooptidoodles", "Wooples", "Woop", "WoopWoop", "Wopple"));

        System.out.println(a.toString());

        removeOddLength(a);

        System.out.println(a.toString());
    }
}
