package com.lab111.labwork9;

import javax.management.modelmbean.XMLParseException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by verrden on 04.05.16.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public JPanel buildImage(String filename) throws ParserConfigurationException, IOException, XMLParseException {
        DOMElement root = Parser.Parse(Main.PATH+filename);
        builder.buildImage((DOMNode) root);
        return builder.getImage();
    }
}
