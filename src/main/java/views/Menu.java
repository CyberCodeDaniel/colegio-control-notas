package views;

import java.util.Scanner;

import models.Student;
import services.FileService;
import services.StudentService;

/**
 * Implementación del menú principal con las acciones específicas.
 */
public class Menu extends MenuTemplate {
    private final StudentService studentService = new StudentService();
    private final FileService fileService = new FileService();
    
    protected Scanner keyboard = new Scanner(System.in);

    @Override
    public void createStudent() {
        System.out.println("--- Crear Alumno ---");

        // Validación de RUT
        String id;
        do {
            System.out.print("Ingrese RUT (formato 1.111.111-1): ");
            id = keyboard.nextLine();
        } while (!id.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]"));

        // Validación de Nombre
        String name;
        do {
            System.out.print("Ingrese nombre: ");
            name = keyboard.nextLine();
        } while (name.trim().isEmpty());

        // Validación de Apellido
        String lastName;
        do {
            System.out.print("Ingrese apellido: ");
            lastName = keyboard.nextLine();
        } while (lastName.trim().isEmpty());

        // Validación de Dirección
        String address;
        do {
            System.out.print("Ingrese dirección: ");
            address = keyboard.nextLine();
        } while (address.trim().isEmpty());

        Student student = new Student(id, name, lastName, address);
        studentService.createStudent(student);
        System.out.println("Alumno creado exitosamente.");
    }

    @Override
    public void listStudents() {
        System.out.println("--- Lista de Alumnos ---");
        studentService.listStudents().forEach((id, student) -> {
            System.out.println("RUT: " + student.getId());
            System.out.println("Nombre: " + student.getName() + " " + student.getLastName());
            System.out.println("Dirección: " + student.getAddress());
            System.out.println("Materias:");
            student.getSubjects().forEach(subject -> {
                System.out.println("  " + subject.getName() + " - Notas: " + subject.getGrades());
            });
        });
    }

    @Override
    public void addSubject() {
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingrese RUT del alumno: ");
        String studentId = keyboard.nextLine();

        if (!studentService.studentExists(studentId)) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        studentService.addSubjectToStudent(studentId);
    }

    @Override
    public void addGradeStepOne() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingrese RUT del alumno: ");
        String studentId = keyboard.nextLine();

        if (!studentService.studentExists(studentId)) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        studentService.listSubjects(studentId);

        System.out.print("Seleccione la materia: ");
        int subjectIndex;
        do {
            while (!keyboard.hasNextInt()) {
                System.out.print("Por favor, ingrese un número: ");
                keyboard.next();
            }
            subjectIndex = keyboard.nextInt() - 1;
        } while (!studentService.validateSubjectIndex(studentService.getStudent(studentId), subjectIndex));
        keyboard.nextLine();

        System.out.print("Ingrese la nota (entre 1.0 y 7.0): ");
        double grade;
        while (true) {
            if (keyboard.hasNextDouble()) {
                grade = keyboard.nextDouble();
                keyboard.nextLine();
                if (grade >= 1.0 && grade <= 7.0) {
                    break;
                }
            } else {
            	keyboard.next();
            }
            System.out.println("Nota no válida. Ingrese un valor entre 1.0 y 7.0.");
        }

        studentService.addGradeToSubject(studentId, subjectIndex, grade);
        System.out.println("Nota agregada exitosamente.");
    }

    @Override
    public void exportData() {
        System.out.println("--- Exportar Datos ---");
        System.out.println("Su directorio actual es " + System.getProperty("user.dir"));
        System.out.print("Ingrese la ruta de exportación: ");
        String path = keyboard.nextLine();
        fileService.exportData(studentService.listStudents(), path);
    }
}