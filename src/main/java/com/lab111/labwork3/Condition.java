package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Condition extends Operator implements Component {
    private List<String> relations;

    public Block function3(){
        Block first = new Block();
        return  first;
    };

    public Condition(){
        relations = new ArrayList<String>(){{
            add("Содержит в себе Block");
            add("Ассоциация с Block");
        }};
    };

    public void WriteRelations() {
       /* int point=1;
        System.out.println("Связи Условие: ");
        for (String comp: relations){
            System.out.print(point + ": " + comp+ "  ");
            point++;
        }*/
        System.out.println(part.getPart());
        System.out.println("Если правда выполнить следующее");
        System.out.println("Если ложь следследующее");
    }
}
