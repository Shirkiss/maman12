package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shir.cohen on 11/15/2017.
 */
public class TestExpression {

    public static void main(String[] args) {

        List<Expression> expressions = createRandomExpressions(20, 30);

        for (int i = 0; i < expressions.size(); i++) {
            System.out.printf("%s = %,.0f%n", expressions.get(i), expressions.get(i).calculate());
            for (int x = 0; x < expressions.size(); x++) {
                if (x != i && expressions.get(x).equals(expressions.get(i)))
                    System.out.printf("%s equals other expression %s%n", expressions.get(i), expressions.get(x));
            }
        }
    }

    /**
     * create random ArrayList of Expression
     */
    private static ArrayList<Expression> createRandomExpressions(int numberOfItems, int maxValue) {
        Random rand = new Random();
        ArrayList<Expression> expressions = new ArrayList<Expression>();
        for (int i = 0; i < numberOfItems; i++) {
            double type = rand.nextInt(2);
            if (type == 0)
                expressions.add(new AtomicExpression(rand.nextInt(maxValue)));
            else {
                int split = rand.nextInt(maxValue) + 1;
                Expression left = new AtomicExpression(rand.nextInt(split));
                Expression right = new AtomicExpression(rand.nextInt(maxValue - split + 1));
                int op = rand.nextInt(2);
                if (op == 0)
                    expressions.add(new AdditionExpression(left, right));
                else
                    expressions.add(new SubtractionExpression(left, right));
            }
        }
        return expressions;
    }
}