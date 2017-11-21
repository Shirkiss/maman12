package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by shir.cohen on 11/18/2017.
 */
public class DrawPanel extends JPanel {
    private ArrayList<MyShape> shapes;
    private ArrayList<MyShape> copyShapes;


    public DrawPanel() {
        setBackground(Color.black);
        shapes = createRandomShapes(2, 200);
        copyShapes = new ArrayList<MyShape>();

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
        for (MyShape shape : shapes)
            shape.draw(g);
        for (MyShape shape : copyShapes)
            shape.draw(g);
    }

    /**
     * create random ArrayList of Expression
     */
    private static ArrayList<MyShape> createRandomShapes(int numberOfItems, int maxValue) {
        Random rand = new Random();
        ArrayList<MyShape> shapes = new ArrayList<MyShape>();
        for (int i = 0; i < numberOfItems; i++) {
            MyColor randomColor = new MyColor(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250));
            shapes.add(new MyLine(rand.nextInt(maxValue), rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1), randomColor));
            shapes.add(new MyOval(rand.nextInt(maxValue), rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1), randomColor, rand.nextBoolean()));
            shapes.add(new MyRectangle(rand.nextInt(maxValue), rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1), randomColor, rand.nextBoolean()));
        }
        return shapes;
    }
}
