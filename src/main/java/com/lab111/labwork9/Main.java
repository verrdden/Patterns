package com.lab111.labwork9;

import javax.management.modelmbean.XMLParseException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;

/**
 * Created by verrden on 05.05.16.
 */
public class Main {
    public static final String PATH = "src/res/";

    public static int WIDTH = 1000;

    public static int HEIGHT = 700;

    public static void main(String[] args) throws CloneNotSupportedException {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        Director director = new Director(new ImageBuilder());
        JPanel image = null;
        try {
            image = director.buildImage("config.mcf");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParseException e) {
            e.printStackTrace();
        }

        frame.add(image);

        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}