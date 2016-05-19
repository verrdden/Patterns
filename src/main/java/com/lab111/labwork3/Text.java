package com.lab111.labwork3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by verrden on 06.04.16.
 */
public class Text implements Component {
    private List<String> relations;
    private String part;

     public void setString(String a){part = a;};
    public String getPart(){return part;};

    public Text(){
        relations = new ArrayList<String>(){{
            add("Содержится в Operator");
        }};
    };

    public void WriteRelations() {
       /* int point=1;
        System.out.println("Связи Текст: ");
        for (String comp: relations){
            System.out.print(point + ": " + comp+ "  ");
            point++;
        }
        System.out.println();
        System.out.println();*/
        System.out.println(getPart());
    }
}
