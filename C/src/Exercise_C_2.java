//Created by DaMasterHam on 13-09-2016.
//

import java.util.*;
import java.util.stream.Collector;

//Calculator with exception
public class Exercise_C_2
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

    private boolean isDigits(String s)
    {
        int length = s.length();

        for (int i = 0; i < length; i++)
        {
            if (Character.isDigit(s.charAt(i)) == false)
            {
                return false;
            }
        }

        return true;
    }


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


    public boolean setA(String a)
    {
        if (isDigits(a))
        {
            this.a = Integer.parseInt(a);
            return true;
        }

        return false;
    }


    public boolean setB(String b)
    {
        if (isDigits(b))
        {
            this.b = Integer.parseInt(b);
            return true;
        }

        return false;
    }


    public boolean setOperator(String operator)
    {
        Set<String> temp;

        temp = new HashSet<String>(operators);

        temp.add(operator);

        if (temp.size() == operators.size())
        {
            this.operator = operator;
            return true;
        }
        else
        {
            
            return false;
        }
    }


    public static void main(String[] args)
    {
        Exercise_C_2 calc;

        if (args.length != 3)
        {
            System.out.print("Usage: java Calculator ");
            System.out.print("operand1 operator operand2");
            System.out.println();
        }
        else
        {
            calc = new Exercise_C_2();

            boolean a;
            boolean b;
            boolean op;

            a = calc.setA(args[0]);
            b = calc.setB(args[2]);
            op =  calc.setOperator(args[1]);

            if (a == false)
            {
                System.out.println("Wrong input: " + args[0]);
            }

            if (b == false)
            {
                System.out.println("Wrong input: " + args[2]);
            }

            if (op == false)
            {
                System.out.println("Wrong input: " + args[1]);
            }


            if (a && b && op)
            {
                System.out.println(calc.toEquation());
            }

        }
    }
}
