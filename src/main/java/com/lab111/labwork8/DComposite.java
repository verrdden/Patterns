package com.lab111.labwork8;

import java.util.ArrayList;

/**
 * Created by verrden on 03.05.16.
 */
public class DComposite extends Component {

    ArrayList<Component> child;
    IIterator iterator;

    public DComposite(String name) {
        super(name);
        child = new ArrayList<>();
    }

    @Override
    public void add(Component... c) {
        for (Component i:c)
            child.add(i);
    }

    @Override
    public Component getChild(int index) {
        return child.get(index);
    }

    @Override
    public Component remove(int index) {
        return child.remove(index);
    }

    @Override
    public void remove(Component c) {
        child.remove(c);
    }

    @Override
    public int numberOf() {
        return child.size();
    }

    @Override
    public IIterator getIterator() {
        if(iterator==null)
            iterator = new DIterator(this);
        return iterator;
    }

    @Override
    public String toString(){return name;}
}
