import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class DirectoryManagementDemo {

    // traditional java.io.File approach
    static void createDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs(); // creates the directory and any missing parent directories
        }
    }

    static void listDirectoryContents(String path) {
        File dir = new File(path);
        String[] contents = dir.list();
        if (contents != null) { // null check avoids NPE on an empty or missing directory
            for (String name : contents) {
                System.out.println(name);
            }
        }
    }

    static void deleteDirectory(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            boolean success = dir.delete(); // only succeeds if the directory is empty
            System.out.println("Deleted: " + success);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    // newer java.nio.file approach, better error handling via exceptions
    static void createDirectoryNio(String path) {
        Path dirPath = Paths.get(path);
        try {
            Files.createDirectories(dirPath); // creates all missing parent folders too
        } catch (IOException e) {
            System.out.println("Could not create directory: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String reportsPath = "DocumentSystem/Reports";

        createDirectory(reportsPath);
        System.out.println("Contents of Reports:");
        listDirectoryContents(reportsPath);

        deleteDirectory(reportsPath);

        createDirectoryNio("DocumentSystem/Invoices");
    }
}