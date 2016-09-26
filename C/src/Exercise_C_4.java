//Created by DaMasterHam on 13-09-2016.
//

import java.util.Arrays;
import java.util.HashSet;
import java.util.InvalidPropertiesFormatException;
import java.util.Set;

//Calculator with exception
public class Exercise_C_4
{
    private static final String operator = "/";
    private int a;
    private int b;

    private double divide()
    {
        return (double)a / (double)b;
    }


    public double result()
    {
       return divide();
    }

    public String toEquation()
    {
        return a + " " + operator + " " + b + " = " + result();
    }


    public void setA(String a) throws NumberFormatException
    {
        try
        {
            this.a = Integer.parseInt(a);
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Wrong Input: " + a);
        }
    }


    public void setB(String b) throws NumberFormatException, ArithmeticException
    {
        try
        {
            int bParsed = Integer.parseInt(b);

            if (bParsed == 0)
            {
                throw new ArithmeticException("You cannot divide by Zero!");
            }

            this.b = bParsed;
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Wrong Input: " + b);
        }
    }

    public static void main(String[] args)
    {
        Exercise_C_4 calc;

        if (args.length != 2)
        {
            System.out.print("Usage: java Calculator ");
            System.out.print("operand1 operator operand2");
            System.out.println();
        }
        else
        {
            try
            {
                calc = new Exercise_C_4();
                calc.setA(args[0]); // throws NumberFormatException
                calc.setB(args[1]); // throws NumberFormatException

                System.out.println(calc.toEquation());
            }
            catch (NumberFormatException | ArithmeticException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
