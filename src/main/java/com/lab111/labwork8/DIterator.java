package com.lab111.labwork8;

/**
 * Created by verrden on 03.05.16.
 */
public class DIterator implements IIterator {

    Component component;
    int current;

    public DIterator(DComposite component){
        this.component = component;
        current = -1;
    }

    @Override
    public Component first() {
        current = -1;
        for (int i =0;i<component.numberOf();i++){
            if(component.getChild(i).numberOf()!=0)
                component.getChild(i).getIterator().first();
        }
        return component;
    }

    @Override
    public boolean hasNext() {
        return current<component.numberOf();
    }
    @Override
    public Component next() {
        return next(this);
    }
    private Component next(DIterator it){
        if(it.current==-1){
            it.current++;
            return it.component;
        }
        if(it.component.numberOf()>it.current){
            if(it.component.getChild(it.current).numberOf() == 0){
                return it.component.getChild(it.current++);
            }else {
                Component temp=next((DIterator) it.component.getChild(it.current).getIterator());
                if(temp!=null)
                    return temp;
                it.current++;
                return next(it);
            }
        }
        return null;
    }

    public Component current() {
        if(current==-1)
            return component;
        if(current<component.numberOf()) {
            if (component.getChild(current).numberOf() == 0)
                return component.getChild(current);
            else {
                Component temp=component.getChild(current).getIterator().current();
                if(temp!=null)
                    return temp;
                current++;
                return current();
            }
        }
        else return null;
    }
}
