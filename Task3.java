import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = sc.nextLine();

        String fileContents = readFile(fileName);
        System.out.println("File contents:");
        System.out.println(fileContents);

        System.out.println("Enter the new content or keep it as empty:");
        String newContent = sc.nextLine();

        if (!newContent.isEmpty()) {
            wf(fileName, newContent);
            System.out.println("Changes saved. ");
        } else {
            System.out.println("No changes made. ");
        }
        sc.close();
    }

    private static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
    private static void wf(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}