package com.lab111.labwork9;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by verrden on 04.05.16.
 */
public abstract class DOMElement {
        protected Map<String,String > atributes;
        protected String type;
        public DOMElement(){
            atributes=new HashMap<>();
        }
        public String GetTagName(){return type;}
        public String GetAttribute(String atr){
            return atributes.get(atr);
        }
    }

