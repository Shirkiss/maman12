package main.java;

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
    protected double calculate() {
        return getValue();
    }

}
