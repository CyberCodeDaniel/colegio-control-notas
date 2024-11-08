package services;

import java.util.List;

/**
 * Servicio para calcular el promedio de una lista de notas.
 */
public class AverageServiceImp {

    /**
     * Calcula el promedio de una lista de notas.
     * Si la lista está vacía, retorna 0.0.
     *
     * @param grades lista de notas.
     * @return promedio calculado.
     */
    public double calculateAverage(List<Double> grades) {
        // Stream API para calcular el promedio de los valores en la lista
        return grades.stream()
                     .mapToDouble(Double::doubleValue)
                     .average()
                     .orElse(0.0); // Si la lista está vacía, retorna 0.0
    }
}
