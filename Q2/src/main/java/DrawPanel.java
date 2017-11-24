package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * DrawPanel.java
 * Purpose: Create panel with different shapes
 *
 * @author Shir Cohen
 */

public class DrawPanel extends JPanel {
    private ArrayList<MyShape> shapes;
    private ArrayList<MyShape> copyShapes;

    protected DrawPanel() {
        setBackground(Color.WHITE);
        shapes = createRandomShapes(2, 200);
        copyShapes = new ArrayList<>();

        for (int i = 0; i < shapes.size(); i++) {
            try {
                copyShapes.add(shapes.get(i).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            copyShapes.get(i).setX1(copyShapes.get(i).getX1() + 10);
            copyShapes.get(i).setY1(copyShapes.get(i).getY1() + 10);
            if (copyShapes.get(i) instanceof MyBoundedShape)
                ((MyBoundedShape) copyShapes.get(i)).setEmpty(!(((MyBoundedShape) copyShapes.get(i)).getEmpty()));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw(g);
            copyShapes.get(i).draw(g);
        }
    }

    /**
     * Create random ArrayList of Oval,Line and Rectangle
     *
     * @param numberOfItems the numbers of random shapes that will create from each type
     * @param maxValue      the upper bound for points value.
     * @return An ArrayList of Expressions
     */
    private static ArrayList<MyShape> createRandomShapes(int numberOfItems, int maxValue) {
        Random rand = new Random();
        ArrayList<MyShape> shapes = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
//            in order to make sure that (x1,y1) is the left point we set (x2,y2) relative to it
            int x1, y1;
            shapes.add(new MyLine(x1 = rand.nextInt(maxValue), y1 = rand.nextInt(maxValue), rand.nextInt(maxValue - x1) + x1, rand.nextInt(maxValue - y1) + y1, createRandomColor()));
            shapes.add(new MyOval(x1 = rand.nextInt(maxValue), y1 = rand.nextInt(maxValue), rand.nextInt(maxValue - x1) + x1, rand.nextInt(maxValue - y1) + y1, createRandomColor(), rand.nextBoolean()));
            shapes.add(new MyRectangle(x1 = rand.nextInt(maxValue), y1 = rand.nextInt(maxValue), rand.nextInt(maxValue - x1) + x1, rand.nextInt(maxValue - y1) + y1, createRandomColor(), rand.nextBoolean()));
        }
        return shapes;
    }

    /**
     * Create random MyColor
     *
     * @return A MyColor object
     */
    private static MyColor createRandomColor() {
        Random rand = new Random();
        return new MyColor(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250));
    }
}
