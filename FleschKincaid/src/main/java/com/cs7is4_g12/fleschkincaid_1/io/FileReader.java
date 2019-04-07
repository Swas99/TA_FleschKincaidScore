package com.cs7is4_g12.fleschkincaid_1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class FileReader {

    public String read(String filename) {
        try {
            System.out.println("Reading file: " + filename);
            Scanner s;
            if(filename.startsWith("/")) {
                s = new Scanner(new File(filename));
            } else {
                s = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
            }
            StringBuilder builder = new StringBuilder();

            String text = "";
            while(s.hasNextLine()) builder.append(s.nextLine() + "\n");
            s.close();
            text = builder.toString();
            return text;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
