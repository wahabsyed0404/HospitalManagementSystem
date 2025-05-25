package service;

import dao.PatientDAO;
import model.Patient;

import java.util.*;

public class PatientService {
    private PatientDAO dao = new PatientDAO();

    public void addPatient(Patient p) {
        List<Patient> list = dao.getAllPatients();
        list.add(p);
        dao.saveAllPatients(list);
        System.out.println("Patient added successfully.");
    }

    public void viewPatients() {
        List<Patient> list = dao.getAllPatients();
        if (list.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : list) {
            System.out.println(p);
        }
    }

    public void deletePatient(int id) {
        List<Patient> list = dao.getAllPatients();
        boolean found = false;
        Iterator<Patient> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                found = true;
                break;
            }
        }
        if (found) {
            dao.saveAllPatients(list);
            System.out.println("Patient deleted.");
        } else {
            System.out.println("Patient ID not found.");
        }
    }

    public void updatePatient(int id, Patient newPatient) {
        List<Patient> list = dao.getAllPatients();
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, newPatient);
                found = true;
                break;
            }
        }
        if (found) {
            dao.saveAllPatients(list);
            System.out.println("Patient updated.");
        } else {
            System.out.println("Patient ID not found.");
        }
    }
}