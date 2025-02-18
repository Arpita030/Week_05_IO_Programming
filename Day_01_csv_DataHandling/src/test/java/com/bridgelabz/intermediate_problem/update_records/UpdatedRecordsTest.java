package com.bridgelabz.intermediate_problem.update_records;


import com.bridgelabz.intermediate_problems.update_records.UpdatedRecords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpdatedRecordsTest {

    private static final String INPUT_FILE_PATH = "src/test/resources/employee.csv";
    private static final String OUTPUT_FILE_PATH = "src/test/resources/updated_employees.csv";

    @BeforeEach
    void setUp() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE_PATH))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("113,Arpita Goutam,IT,62000\n");
            writer.write("115,Manish Patel,Sales,58000\n");
            writer.write("114,Ayushi Anand,IT,60000\n");
            writer.write("125,Raj Chandran,Sales,58000\n");
            writer.write("104,Alice Williams,IT,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUpdateSalaries() {
        UpdatedRecords.update(INPUT_FILE_PATH, OUTPUT_FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE_PATH))) {
            String line;
            boolean foundArpita = false;
            boolean foundAyushi = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("113")) { // Arpita Goutam (IT)
                    assertEquals("68200.00", data[3]);  // 10% increase
                    foundArpita = true;
                }
                if (data[0].equals("114")) { // Ayushi Anand (IT)
                    assertEquals("66000.00", data[3]);  // 10% increase
                    foundAyushi = true;
                }
            }

            assertTrue(foundArpita, "Arpita Goutam not found in the updated records.");
            assertTrue(foundAyushi, "Ayushi Anand not found in the updated records.");

        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred during the test");
        }
    }

    @Test
    void testNoUpdateForNonIT() {
        UpdatedRecords.update(INPUT_FILE_PATH, OUTPUT_FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE_PATH))) {
            String line;
            boolean foundManish = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("115")) { // Manish Patel (Sales)
                    assertEquals("58000", data[3]);  // No update, should remain the same
                    foundManish = true;
                }
            }

            assertTrue(foundManish, "Manish Patel not found in the updated records.");

        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred during the test");
        }
    }
}
