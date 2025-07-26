import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Save Drug to File");
            System.out.println("2. Read Drugs from File");
            System.out.println("3. Save Patient to Database");
            System.out.println("4. Read Patients from Database");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter drug id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter dosage: ");
                    String dosage = scanner.nextLine();
                    FileHandler.saveDrugToFile(new Drug(id, name, cost, dosage));
                }
                case 2 -> FileHandler.readDrugsFromFile();
                case 3 -> {
                    System.out.print("Enter patient id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter DOB: ");
                    String dob = scanner.nextLine();
                    DatabaseHandler.savePatientToDB(new Patient(id, firstName, lastName, dob));
                }
                case 4 -> DatabaseHandler.readPatientsFromDB();
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }
}
