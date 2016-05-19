package com.lab111.labwork9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by verrden on 04.05.16.
 */
public abstract class Primitive extends JPanel {
    protected int x,y,width,height;
    protected Color color;

    public Primitive(){super();}

    public Primitive(int x, int y, int width, int height, Color color) {
        this();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public abstract void paintComponent(Graphics g);
}
