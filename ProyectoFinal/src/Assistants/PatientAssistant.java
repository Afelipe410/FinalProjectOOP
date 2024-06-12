import java.util.ArrayList;
import java.util.List;

public class PatientAssistant {

    private List<Patient> patients = new ArrayList<>();

    // Update patients information
    public void updatePatient(Patient patient) {
        Patient existingPatient = findPatientById(patient.getPatientId());

        if (existingPatient != null) {
            existingPatient.setName(patient.getName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setWeight(patient.getWeight());
            existingPatient.setHeight(patient.getHeight());
            existingPatient.setPreexistingConditions(patient.getPreexistingConditions());
            Console.writeLine("Paciente actualizado correctamente.");
        } else {
            Console.writeLine("Error: No se encontró un paciente con este id.");
        }
    }

    // Add patients
    public void addPatient(Patient patient) {
        if (isUniqueId(patient.getPatientId())) {
            patients.add(patient);
            Console.writeLine("Paciente añadido correctamente. ");
        } else {
            Console.writeLine("Error: Ya existe un paciente con esta id.");
        }
    }

    // To delete patients
    public void removePatient(int id) {
        boolean patientFound = false;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId() == id) {
                patients.remove(i);
                patientFound = true;
                Console.writeLine("Paciente borrado correctamente. ");
                break;
            }
        }
        if (!patientFound) {
            Console.writeLine("Error: Paciente con el id " + id + " no encontrado.");
        }

    }

    // To know if the patient ID is unique
    public boolean isUniqueId(int id) {
        for (Patient existingPatient : patients) {
            if (existingPatient.getPatientId() == id) {
                return false;
            }
        }
        return true;
    }

    // find the patient by id
    private Patient findPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    // Create Patients
    public Patient createPatient(int patientId, String name, int age, double weight, double height) {
        return new Patient(patientId, name, age, weight, height, name);
    }

    // List to display all patients stored in this
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

}
