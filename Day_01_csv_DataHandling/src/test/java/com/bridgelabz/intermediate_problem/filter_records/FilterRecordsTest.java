package com.bridgelabz.intermediate_problem.filter_records;


import com.bridgelabz.intermediate_problems.filter_records.FilterRecords;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FilterRecordsTest {

    private static final String FILE_PATH = "src/test/resources/student.csv";

    @BeforeEach
    void setUp() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("ID,Name,Age,Marks\n");
            writer.write("101,John Doe,22,85\n");
            writer.write("102,Jane Smith,21,70\n");
            writer.write("103,Jim Brown,23,90\n");
            writer.write("104,Jack White,24,75\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFilterRecords() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        FilterRecords.filter(FILE_PATH);

        System.setOut(originalOut);

        String output = outputStream.toString().trim();

        assertTrue(output.contains("101,John Doe,22,85"));
        assertTrue(output.contains("103,Jim Brown,23,90"));
        assertFalse(output.contains("102,Jane Smith,21,70"));
        assertFalse(output.contains("104,Jack White,24,75"));
    }
}
