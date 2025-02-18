package com.bridgelabz.basic_problems.read_csv_file;
import java.io.*;
import java.util.*;

public class Student {
    public static void giveInfo() {
        String filepath = "src/main/resources/student.csv";
        try (
                BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1]+ " ,Age:  "+columns[2] + ", Marks:  "+columns[3]);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
