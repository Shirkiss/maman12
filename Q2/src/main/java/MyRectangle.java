package main.java;

import java.awt.*;

/**
 * Created by shir.cohen on 11/17/2017.
 */
public class MyRectangle extends MyBoundedShape {

    public MyRectangle(int x1, int y1, int x2, int y2, MyColor color, Boolean empty) {
        super(x1, y1, x2, y2, color, empty);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getEmpty()) {
            g.drawRect(getX1(), getY1(), width(), height());
        } else {
            g.fillRect(getX1(), getY1(), width(), height());
        }
    }
}
