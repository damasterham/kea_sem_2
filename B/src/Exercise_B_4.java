import jdk.nashorn.internal.ir.WhileNode;

import java.util.*;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_4 // Ch11Ex5
{
    public static void sortAndRemoveDuplicate(List<Integer> list)
    {
        Set<Integer> set;

        set = new TreeSet<>();
        set.addAll(list);

        list.clear();
        list.addAll(set);
    }


    public static void main(String[] args)
    {
        ArrayList<Integer> a;

        a = new ArrayList<>(Arrays.asList(30,1,30,15,3,-8,-2,15,19,30,-20,4,4,6,13,18));

        System.out.print(a.toString()+"\n");

        sortAndRemoveDuplicate(a);

        System.out.print(a.toString()+"\n");
    }
}
