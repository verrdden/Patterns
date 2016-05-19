package com.lab111.labwork9;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;

/**
 * Created by verrden on 04.05.16.
 */
    public class Rectangle extends Primitive {

        public Rectangle(){super();}

        public Rectangle(int x, int y, int width, int height, Color color) {
            super(x, y, width, height, color);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            java.awt.Rectangle rectangle = new java.awt.Rectangle(x,y,width,height);
            g2d.setColor(color);
            g2d.fill(rectangle);
        }
    }
