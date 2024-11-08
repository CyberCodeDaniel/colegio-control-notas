package views;

/**
 * Clase principal que inicia la aplicación y ejecuta el menú principal.
 */
public class MainApp {

    /**
     * Método principal que inicia el menú.
     *
     */
    public static void main(String[] args) {
    	
        // Crea una instancia del menú y lo inicia
        Menu app = new Menu();
        app.startMenu();
    }
}