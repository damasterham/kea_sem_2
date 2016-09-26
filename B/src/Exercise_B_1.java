import java.util.*;

public class Exercise_B_1 // Ch11Ex02
{
    public static <T> List<T> alternate(List<T> listA, List<T> listB)
    {
        Iterator a;
        Iterator b;
        boolean alt;
        ArrayList<T> list;

        a = listA.iterator();
        b = listB.iterator();
        alt = true;

        list = new ArrayList<>();
        while (a.hasNext() || b.hasNext())
        {
            while (a.hasNext() && b.hasNext())
            {
                if (alt)
                {
                    list.add((T)a.next());
                }
                else
                {
                    list.add((T)b.next());
                }

                alt = !alt;
            }

            while (a.hasNext())
            {
                list.add((T)a.next());
            }

            while (b.hasNext())
            {
                list.add((T)b.next());
            }
        }

        return list;
    }

    public static void  main(String[] args)
    {
        List<Integer> a;
        List<Integer> b;
        List<Integer> c;

        a = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        b = new ArrayList<>(Arrays.asList(10,20,30,40,50,60,70));
        c = alternate(a, b);

        for (int i = 0; i < c.size(); i++)
        {
            System.out.print(c.get(i)+";");

        }
    }
}
