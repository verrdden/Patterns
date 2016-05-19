package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Diagram implements Component {
    private List<Component> allComponents = new ArrayList<Component>();

    public  void addComponent(Component comp){
        allComponents.add(comp);
    }
    public void removeComponent(Component comp){
        allComponents.remove(comp);
    }
    public void WriteRelations() {
        for (Component comp: allComponents){
            comp.WriteRelations();
        }
    }
}
