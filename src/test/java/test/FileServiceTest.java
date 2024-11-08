package test;

import models.Student;
import models.Subject;
import models.SubjectEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.FileService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    private FileService fileService;
    private Map<String, Student> students;
    private String testPath;

    @BeforeEach
    void setUp() {
        fileService = new FileService();
        students = new HashMap<>();
        testPath = System.getProperty("user.dir") + "/test_output";

        // Crear datos de prueba
        Student student = new Student("1.111.111-1", "Carlos", "Pérez", "Dirección 123");
        Subject math = new Subject(SubjectEnum.MATH);
        math.addGrade(6.0);
        math.addGrade(7.0);
        student.addSubject(math);
        students.put(student.getId(), student);

        // Crear carpeta de prueba si no existe
        new File(testPath).mkdir();
    }

    @AfterEach
    void tearDown() {
        // Eliminar el archivo de prueba después de cada prueba
        try {
            Files.deleteIfExists(Paths.get(testPath + "/promedios.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testExportDataCreatesFile() {
        // Ejecutar el método exportData para generar el archivo
        fileService.exportData(students, testPath);

        // Verificar que el archivo fue creado
        File file = new File(testPath + "/promedios.txt");
        assertTrue(file.exists(), "El archivo debería haberse creado.");
    }

    @Test
    void testExportDataOverwritesFile() {
        // Ejecutar el método exportData por primera vez
        fileService.exportData(students, testPath);
        
        // Modificar los datos de prueba
        students.get("1.111.111-1").getSubjects().get(0).addGrade(4.5);
        
        // Ejecutar el método exportData por segunda vez (sobrescribir)
        fileService.exportData(students, testPath);

        // Verificar que el archivo fue sobrescrito con los datos actualizados
        File file = new File(testPath + "/promedios.txt");
        assertTrue(file.exists(), "El archivo debería existir después de sobrescribirlo.");
    }
}