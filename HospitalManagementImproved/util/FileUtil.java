package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return lines;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
        }

        return lines;
    }

    public static void writeFile(String fileName, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + fileName);
            e.printStackTrace();
        }
    }
}
