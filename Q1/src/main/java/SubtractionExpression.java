package main.java;


public class SubtractionExpression extends CompoundExpression {

    public SubtractionExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    protected double calculate() {
        return firstExpression.calculate() - secondExpression.calculate();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", firstExpression.toString(), secondExpression.toString());
    }
}
