package com.bridgelabz.intermediate_problems.search_record;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filepath ="src/main/resources/employee.csv";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Name of  Employee you want to Search");
        String name=sc.nextLine();
        SearchRecord.search(filepath,name);

    }
}
