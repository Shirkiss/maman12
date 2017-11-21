package main.java;

/**
 * Created by shir.cohen on 11/16/2017.
 */
public abstract class CompoundExpression extends Expression {
    //change it back to Private after checking

    public Expression firstExpression;
    public Expression secondExpression;

    public CompoundExpression(Expression exp1, Expression exp2) {
        this.firstExpression = exp1;
        this.secondExpression = exp2;
    }
}
