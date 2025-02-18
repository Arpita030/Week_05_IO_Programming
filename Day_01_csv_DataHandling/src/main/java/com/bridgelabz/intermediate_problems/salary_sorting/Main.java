package com.bridgelabz.intermediate_problems.salary_sorting;

import com.bridgelabz.intermediate_problems.salary_sorting.SortCSV;

public class Main {
    public static void main(String[] args) {
        String filePath="src/main/resources/employee.csv";
        SortCSV.sortBySalary(filePath);
    }
}
