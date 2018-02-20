package com.netcracker.bakend;


/**
 * Created by user on 20.02.2018.
 */
public class  Validation {

    public static String parseStirng(String str){
        str = str.replaceAll("\\s+","");
        return str;
    }
    public  static String parseString1(String str){
        str = str.replace("\\s+"," ");
        return str;
    }
}
