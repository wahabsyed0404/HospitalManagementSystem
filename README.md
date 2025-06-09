#  Hospital Management System (Console-Based Java Application)

##  Overview

This is a console-based Hospital Management System developed in Java. It allows users to manage patient data through basic operations like adding, viewing, updating, and deleting records. All data is stored persistently in a text file using CSV format.

---

##  Features

- Add new patients with:
  - ID
  - Name
  - Age
  - Disease
  - Gender
  - Contact Number
- View all patients
- Update patient details by ID
- Delete patient by ID
- Data persistence through text file (`patients.txt`)

---

##  Project Structure

HospitalManagement/
│
├── model/
│ └── Patient.java
│
├── dao/
│ └── PatientDAO.java
│
├── service/
│ └── PatientService.java
│
├── util/
│ └── FileUtil.java
│
├── Main.java
├── patients.txt ← Used to store patient data



##  Technologies Used

- Java 17+
- File I/O (`java.nio.file`, `java.io`)
- OOP principles (Encapsulation, Abstraction, Modularity)

---

##  How to Run

1. Open the project in IntelliJ IDEA or any Java IDE.
2. Ensure `patients.txt` is present in the root directory.
3. Run `Main.java`.
4. Follow the console prompts to interact with the system.

---

##  Sample Console Flow

```text
--- Hospital Management System ---
1. Add Patient
2. View Patients
3. Update Patient
4. Delete Patient
0. Exit
Enter choice: 1

Enter ID: 101
Enter Name: Riya
Enter Age: 23
Enter Disease: Fever
Enter Gender: Female
Enter Contact: 9876543210
Patient added successfully.
 Highlights
Clean, modular code with layered architecture

Robust input validation and error handling

CSV-format data handling

Easy to maintain and extend

 Developed By
Name: [Syed Wahab]

Semester: 2nd Semester, B.Tech CSE

Subject: Java Programming

 License
This project is created for academic purposes. Feel free to reuse or extend it.
