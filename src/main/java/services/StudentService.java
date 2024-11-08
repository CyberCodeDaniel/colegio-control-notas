package services;

import models.Student;
import models.Subject;
import models.SubjectEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Servicio para gestionar estudiantes
public class StudentService {
	private final Map<String, Student> studentList = new HashMap<>();
	private final Scanner keyboardOpt = new Scanner(System.in);

	public void createStudent(Student student) {
		studentList.put(student.getId(), student);
	}

	public Map<String, Student> listStudents() {
		return studentList;
	}

	public boolean studentExists(String id) {
		return studentList.containsKey(id);
	}

	public Student getStudent(String id) {
		return studentList.get(id);
	}

	public void addSubjectToStudent(String studentId) {
		Student student = studentList.get(studentId);
		if (student != null) {
			System.out.println("Seleccione una materia:");
			for (SubjectEnum subjectEnum : SubjectEnum.values()) {
				System.out.println((subjectEnum.ordinal() + 1) + ". " + subjectEnum);
			}
			int choice;
			do {
				while (!keyboardOpt.hasNextInt()) {
					System.out.print("Por favor, ingrese un número: ");
					keyboardOpt.next();
				}
				choice = keyboardOpt.nextInt();
			} while (choice < 1 || choice > SubjectEnum.values().length);

			SubjectEnum chosenSubject = SubjectEnum.values()[choice - 1];
			student.addSubject(new Subject(chosenSubject));
			System.out.println("Materia agregada exitosamente.");
		} else {
			System.out.println("Alumno no encontrado.");
		}
	}

	public void addGradeToSubject(String studentId, int subjectIndex, double grade) {
		Student student = studentList.get(studentId);
		if (student != null) {
			Subject subject = student.getSubjects().get(subjectIndex);
			subject.addGrade(grade);
		}
	}

	public boolean validateSubjectIndex(Student student, int index) {
		return index >= 0 && index < student.getSubjects().size();
	}

	public void listSubjects(String studentId) {
		Student student = studentList.get(studentId);
		if (student != null) {
			System.out.println("Materias disponibles:");
			for (int i = 0; i < student.getSubjects().size(); i++) {
				System.out.println((i + 1) + ". " + student.getSubjects().get(i).getName());
			}
		}
	}
}