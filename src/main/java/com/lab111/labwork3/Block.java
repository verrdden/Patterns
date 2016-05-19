package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Block implements Component {
    private List<String> relations;


    public Block(){
        relations = new ArrayList<String>(){{
           add("Содержится в Part");
           add("Содержится в Operator");
            add("Содержится в Condition");
            add("Родитель Operator");
            add("Родитель Part");
        }};
    };

    public void WriteRelations() {
        int point=1;
        System.out.println("Связи Блока: ");
        for (String comp: relations){
            System.out.print(point + ": " + comp+ "  ");
            point++;
        }
        System.out.println();
        System.out.println();
    }
}
