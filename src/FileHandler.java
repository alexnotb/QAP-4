import java.io.*;

public class FileHandler {
    private static final String FILE_PATH = "drug_data.txt";

    public static void saveDrugToFile(Drug drug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(drug.toFileString());
            writer.newLine();
            System.out.println("Drug saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }

        System.out.println("\nPress Enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void readDrugsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Drug drug = Drug.fromFileString(line);
                System.out.println(drug);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        System.out.println("\nPress Enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}
