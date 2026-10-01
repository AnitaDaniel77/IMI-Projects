import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamsDemo {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        // write some bytes to the source file first, so there's something to copy
        try (FileOutputStream setup = new FileOutputStream(sourceFile)) {
            setup.write("Hello byte streams!".getBytes());
        } catch (IOException e) {
            System.out.println("Error setting up source file: " + e.getMessage());
        }

        // copy source.txt to destination.txt, one byte at a time
        try (FileInputStream input = new FileInputStream(sourceFile);
             FileOutputStream output = new FileOutputStream(destinationFile)) {

            int byteValue = input.read();
            while (byteValue != -1) {
                output.write(byteValue);
                byteValue = input.read();
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }

        // read the copy back and print it out as text
        try (FileInputStream input = new FileInputStream(destinationFile)) {
            int byteValue = input.read();
            while (byteValue != -1) {
                System.out.print((char) byteValue);
                byteValue = input.read();
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}