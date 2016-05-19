package com.lab111.labwork8;

import java.awt.dnd.InvalidDnDOperationException;

/**
 * Created by verrden on 03.05.16.
 */
public class Node extends Component {

    public Node(String name){
        super(name);
    }

    @Override
    public void add(Component... c) {
        throw new InvalidDnDOperationException("Invalid Operation!");
    }

    @Override
    public Component getChild(int index) {
        throw new InvalidDnDOperationException("Invalid Operation!");
    }

    @Override
    public Component remove(int index) {
        throw new InvalidDnDOperationException("Invalid Operation!");
    }

    @Override
    public void remove(Component c) {
        throw new InvalidDnDOperationException("Invalid Operation!");
    }

    public int numberOf(){
        return 0;
    }

    @Override
    public IIterator getIterator() {
        throw new InvalidDnDOperationException("Invalid Operation!");
    }
    @Override
    public String toString() {
        return name;
    }
}
