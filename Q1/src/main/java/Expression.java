package main.java;

/**
 * Created by shir.cohen on 11/14/2017.
 */
public abstract class Expression {
    //change it back to Private after checking
    public double value;

    public abstract double calculate();

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        final Expression other = (Expression) obj;
        if (this.calculate() != other.calculate()) {
            return false;
        }
        return true;
    }
}


