package com.lab111.labwork9;

import javax.management.modelmbean.XMLParseException;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by verrden on 04.05.16.
 */
public class ImageBuilder extends Builder {

    private static Map<String, Color> colorMap;

    /**
     * initialize colorMap
     */
    static {
        colorMap = new HashMap<>();
        colorMap.put("red", Color.RED);
        colorMap.put("green", Color.GREEN);
        colorMap.put("blue", Color.BLUE);
        colorMap.put("orange", Color.ORANGE);
        colorMap.put("yellow",Color.YELLOW);
    }

    /**
     * Image
     */
    private JPanel image;

    /**
     * default constructor
     */
    public ImageBuilder() {
        image = null;
    }

    /**
     * build composit from document
     * @param root  parsed by MCF
     * @throws XMLParseException
     */
    @Override
    public void buildImage(DOMNode root) throws XMLParseException {
        image = buildComposite((DOMNode)root.GetChild(0));
        image.setBounds(0, 0, Main.WIDTH, Main.HEIGHT);

    }

    /**
     *
     * @return Image
     */
    @Override
    public JPanel getImage() {
        return image;
    }

    /**
     * Parse element from XML node
     * @param element
     * @return new Primitive builded from XML node
     * @throws XMLParseException
     */
    private Primitive parseElement(DOMElement element) throws XMLParseException {
        Primitive result;
        String elementName = element.GetTagName();
        if (elementName.equals("circle")) {
            result = buildCircle(element);
        }
        else if (elementName.equals("triangle")) {
            result = buildTriangle(element);
        }
        else if (elementName.equals("composite")) {
            result = buildComposite((DOMNode)element);
        }
        else if(elementName.equals("rectangle")){
            result = buildRectangle(element);
        }
        else {
            throw new XMLParseException("Not valid component : " + elementName);
        }
        return result;
    }
    /**
     * build Composite by config
     * @param element node from XML
     * @return new Composite
     */
    private Primitive buildComposite(DOMNode element) throws XMLParseException {
        Composite composite = new Composite();
        ArrayList<DOMElement> nodeList= element.GetAllChildren();
        for (int i = 0; i < nodeList.size(); i++) {
            Primitive p = parseElement(nodeList.get(i));
            if (p != null) {
                composite.addPrimitive(p);

            }
        }
        return composite;
    }
    /**
     * build Circle by config
     * @param element node from XML
     * @return new Circle
     */
    private Primitive buildCircle(DOMElement element) {
        String paramX = element.GetAttribute("x");
        int x = paramX == null ? 0 : Integer.parseInt(paramX);
        String paramY = element.GetAttribute("y");
        int y = paramY == null ? 0 : Integer.parseInt(paramY);
        String paramWidth = element.GetAttribute("width");
        int width = paramWidth == null ? 0 : Integer.parseInt(paramWidth);
        String paramHeight = element.GetAttribute("height");
        int height = paramHeight == null ? 0 : Integer.parseInt(paramHeight);
        Color paramColor = getColor(element.GetAttribute("color"));
        Color color = paramColor == null ? Color.BLACK : paramColor;
        return new Circle(x, y, width, height, color);
    }

    /**
     * build Triangle by config
     * @param element node from XML
     * @return new Triangle
     */
    private Primitive buildTriangle(DOMElement element) {
        String paramX = element.GetAttribute("x");
        int x = paramX == null ? 0 : Integer.parseInt(paramX);
        String paramY = element.GetAttribute("y");
        int y = paramY == null ? 0 : Integer.parseInt(paramY);
        String paramWidth = element.GetAttribute("width");
        int width = paramWidth == null ? 0 : Integer.parseInt(paramWidth);
        String paramHeight = element.GetAttribute("height");
        int height = paramHeight == null ? 0 : Integer.parseInt(paramHeight);
        Color paramColor = getColor(element.GetAttribute("color"));
        Color color = paramColor == null ? Color.BLACK : paramColor;
        return new Triangle(x, y, width, height, color);
    }
    /**
     * build Rectangle by config
     * @param element node from XML
     * @return new Rectangle
     */
    private Primitive buildRectangle(DOMElement element) {
        String paramX = element.GetAttribute("x");
        int x = paramX == null ? 0 : Integer.parseInt(paramX);
        String paramY = element.GetAttribute("y");
        int y = paramY == null ? 0 : Integer.parseInt(paramY);
        String paramWidth = element.GetAttribute("width");
        int width = paramWidth == null ? 0 : Integer.parseInt(paramWidth);
        String paramHeight = element.GetAttribute("height");
        int height = paramHeight == null ? 0 : Integer.parseInt(paramHeight);
        Color paramColor = getColor(element.GetAttribute("color"));
        Color color = paramColor == null ? Color.BLACK : paramColor;
        return new Rectangle(x, y, width, height, color);
    }
    /**
     *
     * @param colorName
     * @return return color by name in XML
     */
    private Color getColor(String colorName) {
        if (colorName == null) {
            return null;
        }
        return colorMap.get(colorName);
    }
}
