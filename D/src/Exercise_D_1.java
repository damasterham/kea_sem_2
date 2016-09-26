import java.util.LinkedList;
import java.util.Queue;

//Created by DaMasterHam on 19-09-2016.
//
public class Exercise_D_1
{
    public static void main(String[] args)
    {
        Queue<Character> que;

        que = new LinkedList<Character>();

        que.add('C');
        que.add('h');
        que.add('a');
        que.add('n');
        que.add('c');
        que.add('e');
        que.add(' ');
        que.add('M');
        que.add('e');
        que.add('i');
        que.add('s');
        que.add('t');
        que.add('e');
        que.add('r');
        que.add('-');
        que.add('H');
        que.add('a');
        que.add('m');

        System.out.println("Que size = " + que.size());

        while (que.size() != 0)
        {
            System.out.println(que.remove());
        }

        System.out.println("Que size = " + que.size());
    }
}
