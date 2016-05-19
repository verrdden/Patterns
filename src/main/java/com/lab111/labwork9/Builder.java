package com.lab111.labwork9;

import javax.management.modelmbean.XMLParseException;
import javax.swing.*;

/**
 * Created by verrden on 04.05.16.
 */
public abstract class Builder {

    public abstract void buildImage(DOMNode root) throws XMLParseException;
    public abstract JPanel getImage();
}
