package com.bridgelabz.basic_problems.Read_and_count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void count(String filepath) {
        int count=0;
        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            while (br.readLine()!=null){
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(count-1);
    }
}
