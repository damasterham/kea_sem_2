import javax.print.attribute.SetOfIntegerSyntax;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

//Created by DaMasterHam on 16-09-2016.
//
public class Exercise_C_6 // Ch10Ex1
{


    public static int totalVowels(ArrayList<String> list)
    {
        int count;
        Set<Character> set;
        char[] chars;
        Set<Character> comparer;

        count = 0;
        set = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));

        for (String str : list)
        {
            chars = str.toLowerCase().toCharArray();
            comparer = new HashSet<>(set);

            for (int i = 0; i < chars.length; i++)
            {
                if (comparer.contains(chars[i]))
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        ArrayList<String> list;

        list = new ArrayList<String>();
        list.add("AAA");
        list.add("XXX");
        list.add("Woop");

        System.out.println(list.toString());
        System.out.println(totalVowels(list));

    }
}
