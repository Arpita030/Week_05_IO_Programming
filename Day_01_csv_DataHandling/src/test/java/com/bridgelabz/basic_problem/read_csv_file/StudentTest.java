package com.bridgelabz.basic_problem.read_csv_file;

import com.bridgelabz.basic_problems.read_csv_file.Student;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    @Test
    void testGiveInfo() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Student.giveInfo();

        System.setOut(originalOut);

        String output = outputStream.toString().trim();

        assertTrue(output.contains("ID:"));
        assertTrue(output.contains("Name:"));
        assertTrue(output.contains("Age:"));
        assertTrue(output.contains("Marks:"));
    }
}
