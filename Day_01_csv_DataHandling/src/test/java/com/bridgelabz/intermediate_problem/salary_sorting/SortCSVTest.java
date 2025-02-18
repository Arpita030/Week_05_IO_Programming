package com.bridgelabz.intermediate_problem.salary_sorting;


import com.bridgelabz.intermediate_problems.salary_sorting.SortCSV;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortCSVTest {

    @Test
    public void testSortBySalary() throws IOException {
        File tempFile = File.createTempFile("employee_test", ".csv");
        tempFile.deleteOnExit(); // Ensures the file is deleted when the program exits

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,John Doe,IT,55000\n");
            writer.append("2,Jane Smith,HR,60000\n");
            writer.append("3,Mark Brown,IT,75000\n");
            writer.append("4,Alice Williams,Finance,80000\n");
            writer.append("5,Bob Johnson,Sales,65000\n");
        }

        List<SortCSV.Employee> sortedEmployees = SortCSV.sortBySalary(tempFile.getAbsolutePath());

        assertNotNull(sortedEmployees, "The list of employees should not be null");
        assertEquals(5, sortedEmployees.size(), "There should be 5 employees in the list");

        // Check the order: Highest salary first
        assertTrue(sortedEmployees.get(0).salary >= sortedEmployees.get(1).salary, "First employee should have the highest salary");
        assertTrue(sortedEmployees.get(1).salary >= sortedEmployees.get(2).salary, "Second employee should have a salary less than or equal to the first");
        assertTrue(sortedEmployees.get(2).salary >= sortedEmployees.get(3).salary, "Third employee should have a salary less than or equal to the second");
        assertTrue(sortedEmployees.get(3).salary >= sortedEmployees.get(4).salary, "Fourth employee should have a salary less than or equal to the third");
    }
}
