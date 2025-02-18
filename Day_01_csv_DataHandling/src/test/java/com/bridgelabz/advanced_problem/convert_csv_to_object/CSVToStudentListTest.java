package com.bridgelabz.advanced_problems.convert_csv_to_object;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVToStudentListTest {

    @Test
    public void testReadCSV() throws IOException {
        // Create a temporary CSV file for testing
        File tempFile = File.createTempFile("test_students", ".csv");
        tempFile.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("ID,Name,Age,Marks\n");
            writer.write("1,John Doe,20,85.5\n");
            writer.write("2,Jane Doe,22,90.0\n");
        }

        // Read the CSV file
        List<Student> students = com.bridgelabz.advanced_problems.convert_csv_to_object.CSVToStudentList.readCSV(tempFile.getAbsolutePath());

        // Assertions
        assertNotNull(students);
        assertEquals(2, students.size());
        assertEquals("John Doe", students.get(0).toString().contains("John Doe") ? "John Doe" : "");
        assertEquals(85.5, students.get(0).toString().contains("85.5") ? 85.5 : 0.0);
    }
}
