package dao;

import model.Patient;
import util.FileUtil;

import java.util.*;

public class PatientDAO {
    private static final String FILE_NAME = "patients.txt";

    public List<Patient> getAllPatients() {
        List<String> lines = FileUtil.readFile(FILE_NAME);
        List<Patient> patients = new ArrayList<>();
        for (String line : lines) {
            patients.add(Patient.fromCSV(line));
        }
        return patients;
    }

    public void addPatient(Patient patient) {
        List<Patient> patients = getAllPatients();
        patients.add(patient);
        saveAllPatients(patients);
    }

    public boolean updatePatient(int id, Patient updated) {
        List<Patient> patients = getAllPatients();
        boolean found = false;
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.set(i, updated);
                found = true;
                break;
            }
        }
        saveAllPatients(patients);
        return found;
    }

    public boolean deletePatient(int id) {
        List<Patient> patients = getAllPatients();
        boolean removed = patients.removeIf(p -> p.getId() == id);
        saveAllPatients(patients);
        return removed;
    }

    public void saveAllPatients(List<Patient> patients) {
        List<String> lines = new ArrayList<>();
        for (Patient p : patients) {
            lines.add(p.toCSV());
        }
        FileUtil.writeFile(FILE_NAME, lines);
    }
}
