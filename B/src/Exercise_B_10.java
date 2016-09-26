import com.sun.deploy.panel.ITreeNode;

import java.util.*;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_10 // Ch11Ex11
{
    public static <T> Set<T> symmetricSetDifference(Set<T> setA, Set<T> setB)
    {
        Set<T> aReduced;
        Set<T> bReduced;
        Set<T> result;

        aReduced = new HashSet<>(setA);
        bReduced = new HashSet<>(setB);
        result = new HashSet<>();

        aReduced.removeAll(setB);
        bReduced.removeAll(setA);

        result.addAll(aReduced);
        result.addAll(bReduced);

        return result;
    }


    public static void main(String[] args)
    {
        Set<Integer> a;
        Set<Integer> b;
        Set<Integer> c;

        a = new HashSet<>(Arrays.asList(1,1,1,2,2,3,3,4,4,6,6,6,6,7,8,8,8,9,9,10));
        b = new HashSet<>(Arrays.asList(1,1,1,2,2,4,4,6,6,6,6,20,20,11,12,10,9));

        System.out.println(a.toString());
        System.out.println(b.toString());

        c = symmetricSetDifference(a,b);

        System.out.println(c.toString());
    }
}
