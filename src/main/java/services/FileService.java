package services;

import models.Student;
import models.Subject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Servicio para exportar datos de estudiantes a un archivo de texto.
 */
public class FileService {

    /**
     * Exporta los datos de los estudiantes a un archivo en la ruta especificada.
     *
     * @param students Mapa de estudiantes a exportar.
     * @param path Ruta donde se guardará el archivo.
     */
    public void exportData(Map<String, Student> students, String path) {
        Scanner scanner = new Scanner(System.in);
        String fullPath = path + "/promedios.txt";

        // Mostrar el directorio actual de ejecución
        System.out.println("Directorio actual: " + System.getProperty("user.dir"));

        // Verificar si el archivo ya existe
        File file = new File(fullPath);
        if (file.exists()) {
            System.out.print("El archivo ya existe. ¿Desea sobrescribirlo? (s/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();  // Convertir entrada a minúscula

            // Si el usuario no desea sobrescribir, salir del método
            if (!choice.equals("s")) {
                System.out.println("Operación cancelada. No se sobrescribió el archivo.");
                return;
            }
        }

        // Proceder a exportar los datos al archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
            for (Student student : students.values()) {
                writer.write("Alumno: " + student.getId() + " - " + student.getName() + "\n");
                for (Subject subject : student.getSubjects()) {
                    double average = calculateAverage(subject.getGrades());
                    writer.write("  Materia: " + subject.getName() + " - Promedio: " + average + "\n");
                }
                writer.write("\n");
            }
            System.out.println("Datos exportados correctamente en: " + fullPath);
        } catch (IOException e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }
    }

    /**
     * Calcula el promedio de una lista de notas.
     *
     * @param grades Lista de notas.
     * @return Promedio calculado.
     */
    private double calculateAverage(java.util.List<Double> grades) {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}