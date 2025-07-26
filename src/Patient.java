public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientDOB;

    public Patient(int patientId, String firstName, String lastName, String dob) {
        this.patientId = patientId;
        this.patientFirstName = firstName;
        this.patientLastName = lastName;
        this.patientDOB = dob;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + patientFirstName + " " + patientLastName + ", DOB: " + patientDOB;
    }
}
