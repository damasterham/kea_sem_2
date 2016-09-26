import com.sun.glass.ui.Size;

import java.util.Random;

//Created by DaMasterHam on 16-09-2016.
//
public class Exercise_C_5
{
    private static final int SIZE = 100;
    private int[] array;

    public Exercise_C_5()
    {
        Random r = new Random();

        array = new int[SIZE];

        for (int i = 0; i < SIZE; i++)
        {
            array[i] = r.nextInt();
        }
    }

    public int getElement(int index) throws ArrayIndexOutOfBoundsException
    {
        try
        {
            return array[index];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new ArrayIndexOutOfBoundsException("The element you are selecting is out of bounds, the last element is at index " + (array.length -1));
        }
    }

    public static void main(String[] args)
    {
        Exercise_C_5 randArray = new Exercise_C_5();

        try
        {
            System.out.println(randArray.getElement(3));
            System.out.println(randArray.getElement(50));
            System.out.println(randArray.getElement(99));
            System.out.println(randArray.getElement(100));
            System.out.println(randArray.getElement(10)); // never accessed since exception is thrown above
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
