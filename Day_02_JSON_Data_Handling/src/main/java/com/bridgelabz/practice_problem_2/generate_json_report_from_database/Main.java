package com.bridgelabz.practice_problem_2.generate_json_report_from_database;


public class Main {
    public static void main(String[] args) {
        String jsonResponse = EmployeeAPIClient.fetchEmployeeData();

        EmployeeJSONReportGenerator.generateReport(jsonResponse);
    }
}
