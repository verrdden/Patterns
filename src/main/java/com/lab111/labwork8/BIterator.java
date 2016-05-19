package com.lab111.labwork8;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by verrden on 03.05.16.
 */
public class BIterator implements IIterator {

    List<Component> list;
    Component component;
    int current;

    public BIterator(Component component){
        list = new LinkedList<>();
        this.component = component;
        current = -1;
        list.add(component);
    }

    @Override
    public Component first() {
        current=-1;
        list.clear();
        list.add(component);
        return component;
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Component next() {
        if(current<list.get(0).numberOf()) {
            if (current == -1) {
                current++;
                return list.get(0);
            }
            Component temp = list.get(0).getChild(current);
            if (temp.numberOf() > 0)
                list.add(temp);
            current++;
            return temp;
        }
        else {
            current=0;
            list.remove(0);
            if(list.isEmpty())
                return null;
            return next();
        }
    }

    public Component current() {
        return list.get(0).getChild(current);
    }
}
