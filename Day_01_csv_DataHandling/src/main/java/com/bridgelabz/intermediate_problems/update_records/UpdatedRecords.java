package com.bridgelabz.intermediate_problems.update_records;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdatedRecords {
    public  static void update(String filepath,String outputFile){

        List<String[]> updatedRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (isHeader) {
                    updatedRecords.add(data);
                    isHeader = false;
                    continue;
                }

                if (data.length >= 4 && data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;
                    data[3] = String.format("%.2f", salary);
                }

                updatedRecords.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeUpdatedCSV(outputFile, updatedRecords);
    }

    public static void writeUpdatedCSV(String outputFile, List<String[]> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] record : records) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Salaries updated successfully and saved to '" + outputFile + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}