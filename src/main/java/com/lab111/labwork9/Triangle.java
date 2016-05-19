package com.lab111.labwork9;

import java.awt.*;

/**
 * Created by verrden on 04.05.16.
 */
public class Triangle extends Primitive {

    private int[] xCoords,yCoords;

    public Triangle(){super();}

    public Triangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        xCoords = new int[]{x, x + width / 2, x + width};
        yCoords = new int[]{y + height, y, y + height};
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Polygon p = new Polygon(xCoords, yCoords, 3);
        g2d.setColor(color);
        g2d.fill(p);
    }
}
