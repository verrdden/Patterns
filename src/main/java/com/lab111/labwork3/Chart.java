package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by verrden on 06.04.16.
 */
public class Chart extends Part implements Component {
    private List<String> relations;
    private Name part;

    public Chart(){
        relations = new ArrayList<String>(){{
            add("Агрегирует в себе Name");
            add("Наследуется от Part");
        }};
    };

    public void WriteRelations() {
        int point=1;
        System.out.println("Связи Блок-схема: ");
        for (String comp: relations){
            System.out.print(point + ": " + comp+ "  ");
            point++;
        }
        System.out.println();
        System.out.println();
    }
}
