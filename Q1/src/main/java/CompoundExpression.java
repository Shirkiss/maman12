package main.java;

public abstract class CompoundExpression extends Expression {
    //change it back to Private after checking

    protected Expression firstExpression;
    protected Expression secondExpression;

    public CompoundExpression(Expression exp1, Expression exp2) {
        this.firstExpression = exp1;
        this.secondExpression = exp2;
    }
}
