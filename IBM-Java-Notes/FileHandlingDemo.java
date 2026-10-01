import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileHandlingDemo {
    public static void main(String[] args) {
        String fileName = "notes.txt";

        // File: just a path reference, doesn't create anything by itself
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File Exists");
        } else {
            System.out.println("File Does Not Exist");
        }

        // Writing: FileWriter creates/overwrites, BufferedWriter makes it efficient
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("First line");
            writer.newLine();
            writer.write("Second line");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading: FileReader reads characters, BufferedReader reads line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}