import java.util.*;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_6 // Ch11Ex7
{
    public static int countCommon(List<Integer> listA, List<Integer> listB)
    {
        Set<Integer> setA;
        Set<Integer> setB;
        int count;

        setA = new HashSet<>();
        setB = new HashSet<>();
        count = 0;

        setA.addAll(listA);
        setB.addAll(listB);

        for (Integer i : setB)
        {
            if (setA.add(i) == false)
            {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args)
    {
        ArrayList<Integer> a;
        ArrayList<Integer> b;

        int common;

        a = new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,4,4,6,6,6,6,7,8,8,8,9,9,10));
        b = new ArrayList<>(Arrays.asList(1,1,1,2,2,4,4,6,6,6,6,20,20,11,12,10,9));

        System.out.println(a.toString());
        System.out.println(b.toString());

        common = countCommon(a, b);

        System.out.println("numbers in common = " + common);
    }
}
