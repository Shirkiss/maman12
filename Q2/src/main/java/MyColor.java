package main.java;

import java.awt.*;

/**
 * Created by shir.cohen on 11/18/2017.
 */
public class MyColor extends Color implements Cloneable {
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public MyColor clone() throws CloneNotSupportedException {
        return (MyColor) super.clone();
    }
}
