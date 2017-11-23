package main.java;

/**
 * Created by shir.cohen on 11/16/2017.
 */
public class AdditionExpression extends main.java.CompoundExpression {

    public AdditionExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    protected double calculate() {
        return firstExpression.calculate() + secondExpression.calculate();
    }

    @Override
    public String toString() {
        return String.format("%s + %s", firstExpression.toString(), secondExpression.toString());
    }
}
