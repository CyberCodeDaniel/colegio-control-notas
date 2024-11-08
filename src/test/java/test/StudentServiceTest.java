package test;

import models.Student;
import models.Subject;
import models.SubjectEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.StudentService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void testCreateStudent() {
        Student student = new Student("1.111.111-1", "Carlos", "Pérez", "Dirección 123");
        studentService.createStudent(student);

        Map<String, Student> students = studentService.listStudents();
        assertTrue(students.containsKey("1.111.111-1"), "El estudiante debería haber sido agregado a la lista.");
    }

    @Test
    void testAddSubjectToStudent() {
        Student student = new Student("1.111.111-1", "Carlos", "Pérez", "Dirección 123");
        studentService.createStudent(student);

        studentService.addSubjectToStudent("1.111.111-1");

        Student result = studentService.listStudents().get("1.111.111-1");
        assertEquals(1, result.getSubjects().size(), "El estudiante debería tener una materia asignada.");
    }

    @Test
    void testAddGradeToSubject() {
        Student student = new Student("1.111.111-1", "Carlos", "Pérez", "Dirección 123");
        studentService.createStudent(student);

        Subject math = new Subject(SubjectEnum.MATH);
        student.addSubject(math);

        studentService.addGradeToSubject("1.111.111-1", 0, 6.5);

        assertEquals(6.5, student.getSubjects().get(0).getGrades().get(0), 0.01,
                     "La nota debería haberse agregado correctamente.");
    }
}