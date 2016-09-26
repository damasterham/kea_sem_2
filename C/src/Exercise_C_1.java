//Created by DaMasterHam on 13-09-2016.
//
import java.util.*;
import java.util.HashSet;

//Calculator with exception
public class Exercise_C_1
{
    private static final Set<String> operators = new HashSet<String>(Arrays.asList("+","-","/"));  //,"*"));

    private String operator;
    private int a;
    private int b;


    private int add()
    {
        return a + b;
    }
    private int subtract()
    {
        return a - b;
    }
    private int divide()
    {
        return a / b;
    }
    // does not work, * is interperted as all files in folder
//    private int multiply()
//    {
//        return a * b;
//    }


    public int result()
    {
        switch (operator)
        {
            case "+": return add();
            case "-": return subtract();
            case "/": return divide();
//            case "*": return multiply();
            default: return 0;
        }
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


    public void setB(String b) throws NumberFormatException
    {
        try
        {
            this.b = Integer.parseInt(b);
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Wrong Input: " + b);
        }
    }


    public void setOperator(String operator) throws InvalidPropertiesFormatException
    {
        Set<String> temp;

        temp = new HashSet<String>(operators);

        temp.add(operator);

        if (temp.size() == operators.size())
        {
            this.operator = operator;
        }
        else
        {
            String error;

            error = operator + " is and invalid operator, you must use a valid operator:";

            for (String s : operators)
            {
                error += " " + s;
            }

            throw new InvalidPropertiesFormatException(error);
        }
    }


    public static void main(String[] args)
    {
        Exercise_C_1 calc;

        if (args.length != 3)
        {
            System.out.print("Usage: java Calculator ");
            System.out.print("operand1 operator operand2");
            System.out.println();
        }
        else
        {
            try
            {
                calc = new Exercise_C_1();
                calc.setA(args[0]); // throws NumberFormatException
                calc.setOperator(args[1]); // throws InvalidPropertiesFormatException
                calc.setB(args[2]); // throws NumberFormatException

                System.out.println(calc.toEquation());
            }
            catch (NumberFormatException | InvalidPropertiesFormatException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
