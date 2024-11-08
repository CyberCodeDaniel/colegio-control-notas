package views;

import java.util.Scanner;

/**
 * Clase base para el menú, proporciona la estructura básica del menú de
 * opciones.
 */
public class MenuTemplate {

	private final Scanner keyboard = new Scanner(System.in);
	private int errorCount = 0; // Contador de errores consecutivos

	// Getter para el objeto Scanner, en caso de necesitarlo en clases derivadas
	protected Scanner getKeyboard() {
		return keyboard;
	}

	/**
	 * Muestra el menú principal y gestiona la navegación entre opciones.
	 * Auto-saldrá si el usuario comete 3 errores consecutivos.
	 */
	public void startMenu() {
		int option;
		do {
			clearConsole(); // Limpiar la consola al inicio de cada ciclo del menú

			System.out.println("\nMenú Principal:");
			System.out.println("1. Crear Alumno");
			System.out.println("2. Listar Alumnos");
			System.out.println("3. Agregar Materia");
			System.out.println("4. Agregar Nota");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");

			// Leer la opción ingresada por el usuario y validar que sea un entero
			if (!keyboard.hasNextInt()) {
				System.out.println("Error: Opción no válida. Ingrese un número.");
				keyboard.next(); // Consumir la entrada inválida
				errorCount++;
			} else {
				option = keyboard.nextInt();
				keyboard.nextLine(); // Limpiar el buffer

				// Ejecutar el método correspondiente a la opción seleccionada
				switch (option) {
				case 1 -> {
					createStudent();
					resetErrorCount();
				}
				case 2 -> {
					listStudents();
					resetErrorCount();
				}
				case 3 -> {
					addSubject();
					resetErrorCount();
				}
				case 4 -> {
					addGradeStepOne();
					resetErrorCount();
				}
				case 5 -> {
					exportData();
					resetErrorCount();
				}
				case 6 -> {
					endProgram();
					return;
				}
				default -> {
					System.out.println("Error: Opción no válida.");
					errorCount++;
				}
				}
			}

			// Verificar si se han alcanzado los 3 errores
			if (errorCount >= 3) {
				System.out.println("Demasiados errores consecutivos. El programa se cerrará.");
				endProgram();
				return;
			}
		} while (true);
	}

	/**
	 * Métodos que deben ser sobrescritos en la clase derivada.
	 */
	public void createStudent() {}
	public void listStudents() {}	
	public void addSubject() {}
	public void addGradeStepOne() {}
	public void exportData() {}

	//Métodos para optimizacion del sistema.
	
	/**
	 * Método para limpiar el contador de errores.
	 */
	private void resetErrorCount() {
		errorCount = 0;
	}

	/**
	 * Limpia la consola en sistemas compatibles.
	 */
	private void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			System.out.println("No se pudo limpiar la consola.");
		}
	}

	/**
     * Finaliza el programa.
     */
    public void endProgram() {
        System.out.println("\nPrograma Finalizado...");
        System.exit(0); // Finaliza la ejecución del programa
    }
}
