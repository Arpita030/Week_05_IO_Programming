package com.bridgelabz.intermediate_problems.salary_sorting;

import java.io.*;
import java.util.*;

public class SortCSV {
    public static List<Employee> sortBySalary(String filePath) {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int salary = Integer.parseInt(data[3].trim());
                employees.add(new Employee(data[1].trim(), salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        employees.sort((e1, e2) -> Integer.compare(e2.salary, e1.salary));

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println("Name: " + employees.get(i).name + " | Salary: " + employees.get(i).salary);
        }
        return employees;
    }

    public static class Employee {
        public String name;
        public int salary;

        Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }
    }
}
