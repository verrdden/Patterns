package com.lab111.labwork9;

import java.util.ArrayList;

/**
 * Created by verrden on 04.05.16.
 */
public class DOMNode extends DOMElement{

    ArrayList<DOMElement> childrens=new ArrayList<>();
    int current;
    public void Add(DOMElement item){childrens.add(item);}
    public DOMNode(){
        super();
        current=-1;
    }
    public ArrayList<DOMElement> GetAllChildren(){return childrens;}
    public DOMElement GetChild(int index){
        return childrens.get(index);
    }

}