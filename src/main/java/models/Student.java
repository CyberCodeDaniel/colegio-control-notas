package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un estudiante con su información personal y materias asignadas.
 */
public class Student {
    private String idRut;
    private String firstName;
    private String lastName;
    private String address;
    private List<Subject> subjects;

    public Student(String id, String name, String lastName, String address) {
        this.idRut = id;
        this.firstName = name;
        this.lastName = lastName;
        this.address = address;
        this.subjects = new ArrayList<>();
    }

    public String getId() { return idRut; }
    public String getName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public List<Subject> getSubjects() { return subjects; }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
