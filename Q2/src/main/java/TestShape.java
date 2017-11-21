package main.java;

import javax.swing.*;

/**
 * Created by shir.cohen on 11/18/2017.
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
