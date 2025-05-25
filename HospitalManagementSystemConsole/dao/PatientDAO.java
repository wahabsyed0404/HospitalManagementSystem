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

    public void saveAllPatients(List<Patient> patients) {
        List<String> lines = new ArrayList<>();
        for (Patient p : patients) {
            lines.add(p.toCSV());
        }
        FileUtil.writeFile(FILE_NAME, lines);
    }
}