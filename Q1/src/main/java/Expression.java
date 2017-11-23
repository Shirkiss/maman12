package main.java;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by shir.cohen on 11/14/2017.
 */
public abstract class Expression {
    protected double value;

    protected abstract double calculate();

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


