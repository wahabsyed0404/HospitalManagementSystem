package model;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDisease() { return disease; }

    public String toCSV() {
        return id + "," + name + "," + age + "," + disease;
    }

    public static Patient fromCSV(String data) {
        String[] parts = data.split(",");
        return new Patient(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3]);
    }

    @Override
    public String toString() {
        return "Patient[ID: " + id + ", Name: " + name + ", Age: " + age + ", Disease: " + disease + "]";
    }
}
