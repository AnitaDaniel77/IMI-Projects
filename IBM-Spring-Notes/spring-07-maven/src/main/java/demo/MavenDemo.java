package demo;

import java.util.List;

public class MavenDemo {

    public static void main(String[] args) {
        // phases in the order Maven runs them
        List<String> phases = List.of(
                "validate", "compile", "test", "package", "verify", "install", "deploy");

        String requested = "package";

        // every phase up to and including the one asked for
        int last = phases.indexOf(requested);
        System.out.println("mvn " + requested + " runs:");
        for (int i = 0; i <= last; i++) {
            System.out.println("  " + (i + 1) + ". " + phases.get(i));
        }
    }
}