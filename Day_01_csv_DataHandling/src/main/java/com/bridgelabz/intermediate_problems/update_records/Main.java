package com.bridgelabz.intermediate_problems.update_records;

public class Main {
    public static void main(String[] args) {
        String filepath="src/main/resources/employee.csv";
        String outputFile = "src/main/resources/updated_employees.csv";
        UpdatedRecords.update(filepath,outputFile);
    }
}
