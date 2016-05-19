package com.lab111.labwork9;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by verrden on 04.05.16.
 */
public class Circle extends Primitive {

    public Circle(){super();}

    public Circle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(circle);
    }

}
