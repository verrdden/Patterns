package com.lab111.labwork9;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by verrden on 04.05.16.
 */
public class Composite extends Primitive {

    private List<Primitive> list;

    public Composite(){
        super();
        list = new LinkedList<>();
    }

    public Composite(Primitive... primitives) {
        this();
        for(Primitive e : primitives)
            addPrimitive(e);
    }

    public void addPrimitive(Primitive primitive) {
        list.add(primitive);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Primitive p : list) {
            p.paintComponent(g);
        }
    }
}
