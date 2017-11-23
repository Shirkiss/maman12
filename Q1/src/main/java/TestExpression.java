package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shir.cohen on 11/15/2017.
 */
public class TestExpression {

    public static void main(String[] args) {

        List<Expression> expressions = createRandomExpressions(20, 30, 3);

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
    private static ArrayList<Expression> createRandomExpressions(int numberOfItems, int maxValue, int maxLength) {
        Random rand = new Random();
        ArrayList<Expression> expressions = new ArrayList<Expression>();

//        create array of expressions
        for (int i = 0; i < numberOfItems; i++) {
//            the number of operators in each expression
            int expressionLength = rand.nextInt(maxLength) + 1;
            Expression[] listOfAtomicExpression = new Expression[expressionLength];
//            create list of AtomicExpression
            for (int x = 0; x < expressionLength; x++) {
                listOfAtomicExpression[x] = new AtomicExpression(rand.nextInt(maxValue));
            }
            Expression finalExpression = listOfAtomicExpression[0];

//            add all the Atomic Expressions to one CompoundExpression
            for (int x = 1; x < expressionLength; x++) {
//                chose random operand
                int op = rand.nextInt(2);
                if (op == 0)
                    finalExpression = new AdditionExpression(finalExpression, listOfAtomicExpression[x]);
                else
                    finalExpression = new SubtractionExpression(finalExpression, listOfAtomicExpression[x]);
            }
//            add the finalExpression to the list of expressions
            expressions.add(finalExpression);
        }
        return expressions;
    }
}