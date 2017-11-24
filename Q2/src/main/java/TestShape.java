package main.java;

import javax.swing.*;

/**
 * TestShape.java
 * Purpose: Draw shapes on JFrame based on specific instructions
 *
 * @author Shir Cohen
 */

public class TestShape {
    public static void main(String[] args) {
        JFrame app = new JFrame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        app.add(panel);
        app.setSize(400, 400);
        app.setVisible(true);
    }


}
