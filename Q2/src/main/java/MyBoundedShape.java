package main.java;

public abstract class MyBoundedShape extends MyShape {
    private Boolean empty;


    MyBoundedShape(int x1, int y1, int x2, int y2, MyColor color, Boolean empty) {
        super(x1, y1, x2, y2, color);
        this.empty = empty;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        final MyBoundedShape other = (MyBoundedShape) obj;
        return this.width() == other.width() && this.height() == other.height();
    }

    int width() {
        return Math.abs(this.getX2() - getX1());
    }

    int height() {
        return Math.abs(this.getY2() - getY1());
    }

    Boolean getEmpty() {
        return empty;
    }

    void setEmpty(boolean bool) {
        this.empty = bool;
    }


}
