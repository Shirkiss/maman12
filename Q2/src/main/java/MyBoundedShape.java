package main.java;

import java.awt.*;

/**
 * Created by shir.cohen on 11/17/2017.
 */
public abstract class MyBoundedShape extends MyShape {
    private Boolean empty;


    public MyBoundedShape(int x1, int y1, int x2, int y2, MyColor color, Boolean empty) {
        super(x1, y1, x2, y2, color);
        this.empty = empty;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        final MyBoundedShape other = (MyBoundedShape) obj;
        if (this.width() != other.width()) {
            return false;
        }
        if (this.height() != other.height()) {
            return false;
        }
        return true;
    }

    public int width() {
        return this.getX2() - getX1();
    }

    public int height() {
        return this.getY2() - getY1();
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean bool) {
        this.empty = bool;
    }


}
