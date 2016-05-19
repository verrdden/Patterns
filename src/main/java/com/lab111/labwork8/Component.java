package com.lab111.labwork8;

/**
 * Created by verrden on 03.05.16.
 */
public abstract class Component {

    String name;

    public Component(String name){
        this.name=name;}

    public abstract void add(Component ... c);

    public abstract Component getChild(int index);

    public abstract Component remove(int index);

    public abstract void remove(Component c);

    public abstract int numberOf();

    public abstract IIterator getIterator();

}

