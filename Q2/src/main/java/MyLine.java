package main.java;

import java.awt.*;

public class MyLine extends MyShape {

    public MyLine(int x1, int y1, int x2, int y2, MyColor color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        final MyLine other = (MyLine) obj;
        if (this.length() != other.length()) {
            return false;
        }
        return true;
    }

    public double length() {
        return Math.sqrt(Math.pow(this.getX1() - this.getX2(), 2) + Math.pow(this.getY1() - this.getY2(), 2));
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }


}
