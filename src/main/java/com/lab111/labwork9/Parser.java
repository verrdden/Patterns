package com.lab111.labwork9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by verrden on 04.05.16.
 */
public class Parser {
    static ArrayList<String> arr=new ArrayList<>();
    public static DOMNode Parse(String FileName) throws FileNotFoundException {
        DOMNode temp=new DOMNode();
        FileReader fileReader = new FileReader(FileName);
        Scanner sc = new Scanner(fileReader);
        DOMElement t;
        while (sc.hasNextLine()) {
            arr.add(sc.next());
        }
        temp.type="root";
        temp.Add(ParseNode(0));
        return temp;
    }
    private static DOMLeaf ParseLeaf(int f){
        String temp=arr.get(f);
        DOMLeaf t;
        String tempArr[];
        t=new DOMLeaf();
        t.type=temp.substring(1, temp.length());
        for (int i=f+1;i<arr.size();i++){
            temp=arr.get(i);
            if(temp.equals("/>"))
                break;
            if(temp.contains("/>")){
                temp=temp.replaceAll("/>","");
                tempArr=temp.split(":");
                if(tempArr.length==2)
                    t.atributes.put(tempArr[0],tempArr[1]);
                break;
            }
            tempArr=temp.split(":");
            t.atributes.put(tempArr[0],tempArr[1]);
        }
        return t;
    }
    private static DOMNode ParseNode(int f){
        DOMNode current=new DOMNode();
        current.type=arr.get(f).substring(1,arr.get(f).length()-1);
        String temp=arr.get(f);
        for (int i=f+1;i<EndTags(f,true);i++){
            temp=arr.get(i);
            if(temp.charAt(0)=='<'){
                if(temp.charAt(temp.length()-1)=='>'){
                    current.Add(ParseNode(i));
                    i=EndTags(i,true);
                }
                else {
                    current.Add(ParseLeaf(i));
                    i=EndTags(i,false);
                }
            }

        }
        return current;
    }
    private static int EndTags(int f,boolean b){
        String temp;
        int j=0;
        if(b) {
            temp = arr.get(f).substring(1, arr.get(f).length() - 1);
            for (int i = f + 1; i < arr.size(); i++) {
                if(arr.get(i).equals("<"+temp+">")){
                    j++;
                }
                if(arr.get(i).equals("</"+temp+">")) {
                    if(j==0)
                        return i;
                    else {
                        j--;
                        continue;
                    }
                }
            }
        }
        else {
            temp = arr.get(f).substring(1, arr.get(f).length());
            for (int i = f + 1; i < arr.size(); i++) {
                if(arr.get(i).contains("/>"))
                    return i;
            }
        }
        return arr.size();
    }
}
