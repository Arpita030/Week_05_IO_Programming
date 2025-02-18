package com.bridgelabz.basic_problem.write_csv_file;


import com.bridgelabz.basic_problems.write_csv_file.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private static final String FILE_PATH = "src/main/resources/employee.csv";

    @BeforeEach
    void setUp() {
        // Delete file before each test to ensure it's created fresh
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testEmployeeDetailsFileCreation() {
        // Call the method that writes to the file
        Employee.employeeDetails(FILE_PATH);

        // Check if the file is created
        File file = new File(FILE_PATH);
        assertTrue(file.exists(), "CSV file should be created");

        // Read the file and verify content
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            assertNotNull(line);
            assertEquals("ID,Name,Department,Salary", line, "Header row should match");

            line = br.readLine();
            assertNotNull(line);
            assertTrue(line.contains("113,Arpita Goutam"), "File should contain employee details");

        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred while reading the file");
        }
    }
}
