package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Name implements Component {
    private List<String> relations;

    public Name(){
        relations = new ArrayList<String>(){{
            add("Содержится в  Chart");
        }};
    }
    public void WriteRelations() {
        int point=1;
        System.out.println("Связи Имени: ");
        for (String comp: relations){
            System.out.print(point + ": " + comp+ "  ");
            point++;
        }
        System.out.println();
        System.out.println();
    }
}
