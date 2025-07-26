import java.sql.*;

public class DatabaseHandler {
    private static final String URL = "jdbc:postgresql://localhost:5432/rsvp_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static void savePatientToDB(Patient patient) {
        String query = "INSERT INTO patients (id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getPatientFirstName());
            stmt.setString(3, patient.getPatientLastName());
            stmt.setString(4, patient.getPatientDOB());

            stmt.executeUpdate();
            System.out.println("Patient saved to database.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        System.out.println("\nPress Enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }

    public static void readPatientsFromDB() {
        String query = "SELECT * FROM patients";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("Patient ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("first_name") + " " + rs.getString("last_name")
                        + ", DOB: " + rs.getString("dob"));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        System.out.println("\nPress Enter to continue...");
        new java.util.Scanner(System.in).nextLine();
    }
}
