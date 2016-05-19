package com.lab111.labwork4;

/**
 * Created by verrden on 09.04.16.
 */
public class Picture {
    Vertical left,right;
    Horizontal up,down;
    Image kartinka;
    boolean vision = false;

    public Picture(){
        left = new Vertical();
        right = new Vertical();
        up = new Horizontal();
        down = new Horizontal();
        kartinka = new Image();
    }

    public void show(boolean vis){
        vision = vis ;
    }

   public void setTyperamka(double a, double b, double c, double d){
       up.setOpacity(a);
       left.setOpacity(b);
       right.setOpacity(c);
       down.setOpacity(d);
    }

    public void print(){
        if(vision){
        up.print();
        left.print();
        kartinka.print();
        right.print();
        down.print();
        } else
            System.out.println("Нет доступа к содержимому");
    };
}
