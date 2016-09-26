import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Created by DaMasterHam on 19-09-2016.
//
public class Exercise_D_2
{
    public static void main(String[] args)
    {
        Stack<Character> stack;

        stack = new Stack<Character>();

        stack.push('C');
        stack.push('h');
        stack.push('a');
        stack.push('n');
        stack.push('c');
        stack.push('e');
        stack.push(' ');
        stack.push('M');
        stack.push('e');
        stack.push('i');
        stack.push('s');
        stack.push('t');
        stack.push('e');
        stack.push('e');
        stack.push('r');
        stack.push('-');
        stack.push('H');
        stack.push('a');
        stack.push('m');

        System.out.println("Stack size = " + stack.size());

        while (stack.size() != 0)
        {
            System.out.println(stack.pop());
        }

        System.out.println("Stack size = " + stack.size());
    }
}
