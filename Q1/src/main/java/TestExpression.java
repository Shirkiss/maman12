package main.java;

import java.util.*;


/**
 * TestExpression.java
 * Purpose: Prints expressions and there value to the screen and look for
 * expressions with the same value
 *
 * @author Shir Cohen
 */

public class TestExpression {

    public static void main(String[] args) {

        List<Expression> expressions = createRandomExpressions(20, 30, 3);
//        dictionary to save all calculations results
        Map<Double, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> values;
        for (Expression expression : expressions) {
            values = !map.containsKey(expression.calculate()) ? new ArrayList<>() : new ArrayList<>(map.get(expression.calculate()));
            values.add(expression.toString());
//            add to dictionary based on the calculation
            map.put(expression.calculate(), values);
            System.out.printf("%s = %,.0f%n", expression, expression.calculate());
        }

        for (Map.Entry<Double, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1)
                System.out.printf("%,.0f is the results of the following expressions: %s%n", entry.getKey(), entry.getValue());
        }

    }

    /**
     * Create random ArrayList of Expression
     *
     * @param numberOfItems the numbers of random expressions that will create
     * @param maxValue      the upper bound for values of each operators in an expression.
     * @param maxLength     the upper bound for number of operators in an expression.
     * @return An ArrayList of Expression
     */
    private static ArrayList<Expression> createRandomExpressions(int numberOfItems, int maxValue, int maxLength) {
        Random rand = new Random();
        ArrayList<Expression> expressions = new ArrayList<>();

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
                if (op == 0) {
                    finalExpression = new AdditionExpression(finalExpression, listOfAtomicExpression[x]);
                } else {
                    finalExpression = new SubtractionExpression(finalExpression, listOfAtomicExpression[x]);
                }
            }
//            add the finalExpression to the list of expressions
            expressions.add(finalExpression);
        }
        return expressions;
    }
}