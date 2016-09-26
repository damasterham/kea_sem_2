import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//Created by DaMasterHam on 03-09-2016.
//
public class Exercise_B_3 // Ch11Ex4
{
    public static boolean partition(ArrayList<Integer> list, int split)
    {
        ArrayList<Integer> partLow;
        ArrayList<Integer> partHigh;
        Iterator<Integer> itr;
        ArrayList<Integer> partitioned;
        int element;

        partLow = new ArrayList<Integer>();
        partHigh = new ArrayList<Integer>();
        itr = list.iterator();
        element = 0;

        while (itr.hasNext())
        {
            element = itr.next();

            if (element < split)
            {
                partLow.add(element);
            }
            else
            {
                partHigh.add(element);
            }
        }

        list.clear();

        return (list.addAll(partLow) && list.addAll(partHigh));
    }


    public static void main(String[] args)
    {
        int part;
        ArrayList<Integer> a;
        ArrayList<Integer> b;

        part = 14;
        a = new ArrayList<Integer>(Arrays.asList(30,1,20,15,3,-8,-2,15,19,200,-20,4,4,6,13,18));

        System.out.print(a.toString()+"\n");

        System.out.println("Partiotion at " + part);
        if (partition(a,part))
        {
            System.out.print(a.toString()+"\n");
        }


    }
}
