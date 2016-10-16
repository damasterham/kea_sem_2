import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Created by DaMasterHam on 13-10-2016.
//
public class Calculator
{
    private List<BigDecimal> operands;
    private List<Character> operators;
    private BigDecimal sum;

    public Calculator()
    {
        operands = new ArrayList<BigDecimal>();
        operators = new ArrayList<Character>();
    }


    private BigDecimal addition(BigDecimal a, BigDecimal b)
    {
        return a.add(b);
    }
    private BigDecimal subtract(BigDecimal a, BigDecimal b)
    {
        return a.subtract(b);
    }
    private BigDecimal multiply(BigDecimal a, BigDecimal b)
    {
        return a.multiply(b);
    }
    private BigDecimal divide(BigDecimal a, BigDecimal b)
    {
        return a.divide(b);
    }

    public void calculate(BigDecimal operand)
    {
        operands.add(operand);
        sum = operands.get(0);

        for (int i = 0; i < operators.size(); i++)
        {

            switch (operators.get(i))
            {
                case '+': sum = addition(sum, operands.get(i+1)); break;
                case '-': sum = subtract(sum, operands.get(i+1)); break;
                case '*': sum = multiply(sum, operands.get(i+1)); break;
                case '/': sum = divide(sum, operands.get(i+1)); break;
            }
        }
        operators.clear();
        operands.clear();
    }

    public void addOps(BigDecimal operand, char operator)
    {
        operands.add(operand);
        operators.add(operator);
    }

    public BigDecimal getSum()
    {
        return sum;
    }

    public void clear()
    {
        operators.clear();
        operands.clear();
        sum = null;
    }
}
