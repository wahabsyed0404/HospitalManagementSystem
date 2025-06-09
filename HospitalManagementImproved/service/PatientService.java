package service;

import dao.PatientDAO;
import model.Patient;

import java.util.List;

public class PatientService {
    private final PatientDAO dao = new PatientDAO();

    public void addPatient(Patient patient) {
        if (validatePatient(patient)) {
            dao.addPatient(patient);
            System.out.println("Patient added successfully.");
        }
    }

    public void viewPatients() {
        List<Patient> patients = dao.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            patients.forEach(System.out::println);
        }
    }

    public void updatePatient(int id, Patient updatedPatient) {
        if (validatePatient(updatedPatient)) {
            boolean success = dao.updatePatient(id, updatedPatient);
            if (success) {
                System.out.println("Patient updated successfully.");
            } else {
                System.out.println("Update failed: Patient not found.");
            }
        }
    }

    public void deletePatient(int id) {
        boolean success = dao.deletePatient(id);
        if (success) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Delete failed: Patient not found.");
        }
    }

    private boolean validatePatient(Patient p) {
        if (p.getId() <= 0) {
            System.out.println("Invalid ID. Must be positive.");
            return false;
        }
        if (p.getName() == null || p.getName().isEmpty()) {
            System.out.println("Invalid name. Cannot be empty.");
            return false;
        }
        if (p.getAge() < 0 || p.getAge() > 150) {
            System.out.println("Invalid age. Must be between 0 and 150.");
            return false;
        }
        if (p.getDisease() == null || p.getDisease().isEmpty()) {
            System.out.println("Invalid disease. Cannot be empty.");
            return false;
        }
        return true;
    }
}
