import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Observable;

//Created by DaMasterHam on 13-10-2016.
//
public class Main extends Application
{
    private Scene mainScene;
    private Pane mainLayout;

    private Calculator calc;
    private String operand = "";

    private Label screen;

    private void operandOperation(int a)
    {
        operand += a;
        appendToScreen(a);
    }

    private void operandOperation(char a)
    {
        operand += a;
        appendToScreen(a);
    }

    private void operatorOperation(char ch)
    {
        calc.addOps(getOperand(), ch);
        operand = "";
        appendToScreen(ch);
    }

    private void calculateOperation()
    {
        calc.calculate(getOperand());
        String format;

        format = calc.getSum().toString(); //formatDouble(calc.getSum());

//        if (calc.getSum() == Math.floor(calc.getSum()))
//        {
//            format = String.format("%d", (int)calc.getSum());
//        }
//        else
//        {
//            format = String.format(Locale.US, "%.8f", calc.getSum());
//        }

        screen.setText(format);
        operand = format;
    }

    private void clearOperation()
    {
        calc.clear();
        operand = "";
        screen.setText("");
    }

    private void appendToScreen(int a)
    {
        screen.setText(screen.getText()+a);
    }

    private void appendToScreen(char a)
    {
        screen.setText(screen.getText()+a);
    }

    private BigDecimal getOperand()
    {
        return new BigDecimal(operand);
    }

    private String formatDouble(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

    private Button[] digitButtons(double padding, int rows)
    {
        Button[] digits = new Button[10];

        int row = 1;
        for (int i = 0; i < 9; i++)
        {
                int digit = i;
                digits[i] = new Button(""+i);
                digits[i].setOnAction(event -> operandOperation(digit));
                digits[i].setLayoutX(padding*i);
                digits[i].setLayoutY(padding*row);

            if (i % 3 == 0)
                row++;
        }


        return digits;
    }

    private Button[] operatorButtons()
    {
        Button[] operators = new Button[5];

        operators[0] = new Button("+");
        operators[0].setOnAction(event -> operatorOperation('+'));

        operators[1] = new Button("-");
        operators[1].setOnAction(event -> operatorOperation('-'));

        operators[2] = new Button("*");
        operators[2].setOnAction(event -> operatorOperation('*'));

        operators[3] = new Button("/");
        operators[3].setOnAction(event -> operatorOperation('/'));

        operators[4] = new Button("=");
        operators[4].setOnAction(event -> calculateOperation());

        return operators;
    }

    private Button clearButton()
    {
        Button clear = new Button("C");
        clear.setOnAction(event -> clearOperation());
        return clear;
    }

    private Button decimalButton()
    {
        Button deci = new Button(".");
        deci.setOnAction(event -> operandOperation('.'));
        return deci;
    }
    @Override
    public void start(Stage window) throws Exception
    {
        calc = new Calculator();

        screen = new Label();

        mainLayout = new Pane();
        ObservableList<Node> children = mainLayout.getChildren();

        children.add(screen);
        children.add(clearButton());
        children.addAll(digitButtons(25,3));
        children.add(decimalButton());
        children.addAll(operatorButtons());



        mainScene = new Scene(mainLayout,200,800);

        window.setTitle("Calculator");
        window.setScene(mainScene);

        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
