package models;

import java.util.ArrayList;
import java.util.List;

// Representa una materia
public class Subject {
    private SubjectEnum name;
    private List<Double> grades;

 // Constructor de la clase Subject
    public Subject(SubjectEnum name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

 // Getters y Setters para cada atributo
    
    public void setName(SubjectEnum name) {
		this.name = name;
	}

	public void setGrades(List<Double> grades) {
		this.grades = grades;
	}

	public SubjectEnum getName() { return name; }
    public List<Double> getGrades() { return grades; }

    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    
}