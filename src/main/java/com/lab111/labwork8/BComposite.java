package com.lab111.labwork8;

/**
 * Created by verrden on 03.05.16.
 */
public class BComposite extends DComposite{
    public BComposite(String name) {
        super(name);
    }
    @Override
    public IIterator getIterator() {
        if(iterator==null)
            iterator = new BIterator(this);
        return iterator;
    }
}