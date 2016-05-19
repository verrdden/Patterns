package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Part extends Block implements Component {
    private List<String> relations;

    public Block function1(){
        Block first = new Block();
        return  first;
    };
    public Part(){
        relations = new ArrayList<String>(){{
            add("Родитель Part");
            add("Наследуется от Block");
            add("Содержит в себе Block");
            add("Ассоциация с Block");
        }};
    };

    public void WriteRelations() {
        int point=1;
        System.out.println("Связи Составной: ");
        for (String comp: relations){
            System.out.print(point + ": " + comp+ "  ");
            point++;
        }
        System.out.println();
        System.out.println();
    }
}
