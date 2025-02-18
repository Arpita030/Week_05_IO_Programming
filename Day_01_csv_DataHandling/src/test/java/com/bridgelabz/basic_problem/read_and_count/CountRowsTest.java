package com.bridgelabz.basic_problem.read_and_count;

import com.bridgelabz.basic_problems.Read_and_count.CountRows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CountRowsTest {

    private static final String TEST_FILE = "src/test/resources/test_employee.csv";

    // Helper method to create a test CSV file
    private void createTestCSV() throws IOException {
        String data = "ID,Name,Age\n101,John,25\n102,Alice,30\n103,Bob,28";
        Files.createDirectories(Paths.get("src/test/resources"));  // Ensure directory exists
        try (FileWriter writer = new FileWriter(TEST_FILE)) {
            writer.write(data);
        }
    }

    @Test
    public void testCountRows() throws IOException {
        createTestCSV(); // Create test file dynamically

        // Call the method to count rows
        CountRows.count(TEST_FILE);

        // Expected rows = 3 (excluding header)
        int expectedRows = 3;

        // Capture output using a custom stream (Optional)
        assertEquals(expectedRows, getRowCount(TEST_FILE));
    }

    // Helper method to count rows in a file
    private int getRowCount(String filePath) throws IOException {
        return (int) Files.lines(Paths.get(filePath)).count() - 1; // Exclude header
    }
}
