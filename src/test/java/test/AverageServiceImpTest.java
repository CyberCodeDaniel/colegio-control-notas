package test;

import org.junit.jupiter.api.Test;
import services.AverageServiceImp;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AverageServiceImpTest {

    private final AverageServiceImp averageService = new AverageServiceImp();

    @Test
    void testCalculateAverageWithValues() {
        // Prueba con una lista de valores
        List<Double> grades = Arrays.asList(5.0, 6.0, 7.0);
        double result = averageService.calculateAverage(grades);
        assertEquals(6.0, result, 0.01, "El promedio debería ser 6.0");
    }

    @Test
    void testCalculateAverageEmptyList() {
        // Prueba con una lista vacía
        List<Double> grades = Arrays.asList();
        double result = averageService.calculateAverage(grades);
        assertEquals(0.0, result, "El promedio de una lista vacía debería ser 0.0");
    }

    @Test
    void testCalculateAverageSingleValue() {
        // Prueba con una lista de un solo valor
        List<Double> grades = Arrays.asList(10.0);
        double result = averageService.calculateAverage(grades);
        assertEquals(10.0, result, "El promedio de una lista con un solo valor debería ser ese valor mismo");
    }

    @Test
    void testCalculateAverageMixedValues() {
        // Prueba con valores positivos y negativos
        List<Double> grades = Arrays.asList(-5.0, 5.0, 15.0);
        double result = averageService.calculateAverage(grades);
        assertEquals(5.0, result, 0.01, "El promedio debería ser 5.0");
    }
}