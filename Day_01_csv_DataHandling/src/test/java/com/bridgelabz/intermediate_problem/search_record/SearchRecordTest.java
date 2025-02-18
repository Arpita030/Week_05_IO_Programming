package com.bridgelabz.intermediate_problem.search_record;


import com.bridgelabz.intermediate_problems.search_record.SearchRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class SearchRecordTest {

    private static final String FILE_PATH = "src/test/resources/employee.csv";

    @BeforeEach
    void setUp() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("113,Arpita Goutam,Data Analyst,62000\n");
            writer.write("115,Manish Patel,Sales,58000\n");
            writer.write("114,Ayushi Anand,Finance,60000\n");
            writer.write("125,Raj Chandran,Sales,58000\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSearchRecord_found() {
        String searchName = "Arpita Goutam";
        SearchRecord.search(FILE_PATH, searchName);
    }

    @Test
    void testSearchRecord_notFound() {
        String searchName = "John Doe";
        SearchRecord.search(FILE_PATH, searchName);
    }
}
