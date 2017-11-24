package main.java;

import java.awt.*;


public class MyOval extends MyBoundedShape {


    public MyOval(int x1, int y1, int x2, int y2, MyColor color, Boolean empty) {
        super(x1, y1, x2, y2, color, empty);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getEmpty()) {
            g.drawOval(getX1(), getY1(), width(), height());
        } else {
            g.fillOval(getX1(), getY1(), width(), height());
        }
    }

}
