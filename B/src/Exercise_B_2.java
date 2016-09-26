import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

//
//Created by DaMasterHam on 01-09-2016.
//
public class Exercise_B_2 // Ch11Ex3
{
    public static LinkedList<Integer> removeEvenInRange(LinkedList<Integer> linked, int start, int end)
    {
        int index;
        int nr;
        Iterator<Integer> itr;

        index = 0;
        nr = 0;
        itr = linked.iterator();

        while (itr.hasNext() && index < end)
        {
            nr = itr.next();

            if (index >= start && (nr % 2) == 0)
            {
                itr.remove();
            }

            index++;
        }

        return linked;
    }


    public static void main(String[] args)
    {
        LinkedList<Integer> linked;

        linked = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));

        System.out.print(linked.toString()+"\n");

        removeEvenInRange(linked, 5,11);

        System.out.print(linked.toString()+"\n");
    }
}
