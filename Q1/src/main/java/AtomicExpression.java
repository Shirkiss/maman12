package main.java;

/**
 * Created by shir.cohen on 11/16/2017.
 */
public class AtomicExpression extends Expression {
    // constractor
    public AtomicExpression(double value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%,.0f", getValue());
    }

    public double getValue() {
        return value;
    }

    @Override
    public double calculate() {
        return getValue();
    }

}
