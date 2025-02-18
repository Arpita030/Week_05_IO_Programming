package com.bridgelabz.intermediate_problems.search_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void search(String filepath,String name){
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;
            while ((line = br.readLine()) != null) {
                 String[]data=line.split(",");
                if (name.equalsIgnoreCase(data[1].trim())) {
                    System.out.println(" Name: "+data[1]+" Department: "+data[2]+" ,Salary: "+data[3]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}