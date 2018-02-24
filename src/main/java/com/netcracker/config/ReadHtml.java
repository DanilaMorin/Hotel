package com.netcracker.config;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 12345 on 24.02.2018.
 */
public class ReadHtml {
    String s = "";

    public String getS() {
        // System.out.println(s) ;
        return s;
    }

    public ReadHtml(String name){

        try(FileReader reader = new FileReader(name))
        {
            int c ;

            while((c=reader.read())!=-1){
                s += (char) c;
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }


}
