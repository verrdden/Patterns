package com.lab111.labwork4;

/**
 * Created by verrden on 20.04.16.
 */
public class Horizontal implements ILine {

    private double opa;
    private String linia;

    Horizontal(){
        linia = new String();
        this.setOpacity(1.0);
    }

    public void setOpacity(double op) {
        opa = op >= 0.5 ? 1.0 : 0.0;
        if(opa==1.0)
            linia = "-------------------------";
        else linia = "                         ";
    }

    public double getOpa(){
        return opa;
    }
    public void print(){
        System.out.println("\n"+linia);
    }
}
