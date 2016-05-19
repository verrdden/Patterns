package com.lab111.labwork4;

/**
 * Created by verrden on 09.04.16.
 */
public class Image implements  IImage {

    private double tra;
    private String img = "Тут будет ваша картинка";

    public Image(){
        tra = 1.0;
    }

    public void setTransparency(double tr) {
            tra = tr > 0.5 ? 1.0 : 0.0;
    }
    public double getTra(){
        return tra;
    }

    public void setImg(String a){
        img = a;
    }

    public String getImg(){
        return img;
    }

    public void print(){
        System.out.print(img);
    }
}
