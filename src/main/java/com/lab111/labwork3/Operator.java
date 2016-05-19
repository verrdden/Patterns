package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Operator extends Block implements Component {
    private List<String> relations;
    private  Block next;
    public Text part;

    public Operator(){
        part = new Text();
        relations = new ArrayList<String>(){{
            add("Содержит в себе Text");
            add("Содержит в себе Block");
            add("Ассоциация с Block");
            add("Наследуется от  Block");
            add("Родитель Condition");
        }};
    };

    public void WriteRelations() {
        int point=1;
        System.out.println(part.getPart());
        System.out.println();
        System.out.println();
    }

    public void setNext(Block next) {
        this.next = next;
    }

    public Block getNext() {
        return next;
    }
}
