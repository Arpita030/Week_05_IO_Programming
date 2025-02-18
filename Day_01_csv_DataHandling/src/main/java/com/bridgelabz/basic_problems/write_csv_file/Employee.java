package com.bridgelabz.basic_problems.write_csv_file;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class Employee {
    public static void employeeDetails(String filepath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("113,Arpita Goutam ,Data Analyst,62000\n");
            writer.write("115,Manish Patel,Sales,58000\n");
            writer.write("114,Ayushi Anand,Finance,60000\n");
            writer.write("125,Raj chandanan,Sales,58000\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
