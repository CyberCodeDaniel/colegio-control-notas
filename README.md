# Control de Notas de Alumnos en Java
## Colegio Control de Notas en Java usando Maven.

Este proyecto es una aplicación de consola en Java diseñada para gestionar el control de notas de estudiantes de secundaria. Permite a los usuarios crear perfiles de estudiantes, asignar materias, agregar notas, calcular promedios y exportar los datos a un archivo de texto.

## Características

- **Crear y Listar Estudiantes**: Crea estudiantes y muestra información detallada de cada uno.
- **Asignación de Materias y Notas**: Asigna materias a los estudiantes y permite agregar notas.
- **Cálculo de Promedios**: Calcula el promedio de cada materia para cada estudiante.
- **Exportación de Datos**: Exporta los datos a un archivo de texto (`promedios.txt`) en el que se registran los promedios de cada materia.
- **Validación de Datos**: Verifica la entrada del usuario y permite solo tres intentos fallidos antes de cerrar la aplicación.
- **Pruebas Unitarias**: Incluye pruebas unitarias para asegurar la funcionalidad de las clases principales.

## Requisitos

- Java 8 o superior.
- Maven (para gestión de dependencias y ejecución de pruebas).

## Instalación
1.  Clona el repositorio en tu máquina local:
```bash
    git clone https://github.com/CyberCodeDaniel/tu-repositorio.git
```
2.  Navega al directorio del proyecto:
```bash
    cd tu-repositorio
```
3.  Asegúrate de que las dependencias estén configuradas correctamente ejecutando Maven:
```bash
    mvn install
```
## Estructura del Proyecto

- **src/main/java:** Contiene el código principal.
  - **vistas:** Define el menú de la aplicación.
  - **modelos:** Clases de datos para `Student`, `Subject`, y `enumeraciones`.
  - **servicios:** Clases de servicio para manejar lógica de negocio y cálculos de promedios.
- **src/test/java:** Contiene las pruebas unitarias de las clases `FileService`, `StudentService`, y `AverageServiceImp`.

## Uso

1.  **Ejecuta la clase principal MainApp:**
    En Eclipse: Haz clic derecho en `MainApp.java` y selecciona **Run As > Java Application**.
    En la terminal, asegúrate de estar en el directorio del proyecto y ejecuta:
    ```bash
        mvn exec:java -Dexec.mainClass="vistas.MainApp"
    ```
    
2.  **Interacción con el Menú:**
    - **1. Crear Alumno**: Ingrese el RUT, nombre, apellido y dirección del estudiante.
    - **2. Listar Alumnos**: Muestra una lista de todos los estudiantes registrados con sus materias y notas.
    - **3. Agregar Materia**: Permite asignar una materia específica a un estudiante.
    - **4. Agregar Nota**: Permite agregar una nota a una materia asignada a un estudiante.
    - **5. Exportar Datos**: Exporta los datos al archivo `promedios.txt` en la ubicación especificada.
    - **6. Salir**: Cierra el programa.
    
3.  **Limpieza Automática de Consola y Control de Errores:**
    - La consola se limpia automáticamente al iniciar el menú.
    - Tras tres errores consecutivos, el programa se cierra automáticamente.

## Pruebas

El proyecto incluye pruebas unitarias con JUnit 5 para verificar el correcto funcionamiento de los métodos principales:
- **Ejecución de Pruebas en Eclipse:**
  - Haz clic derecho en las clases de prueba (`AverageServiceImpTest`, `FileServiceTest`, `StudentServiceTest`) y selecciona **Run As > JUnit Test**.
- **Ejecución de Pruebas con Maven:**
    ```bash
        mvn test
    ```

## Ejemplo de Exportación de Datos

**El archivo `promedios.txt` exportado tendrá el siguiente formato:**
```
Alumno: 1.111.111-1 - Carlos
  Materia: MATEMATICAS - Promedio: 6.0

Alumno: 2.222.222-2 - Ana
  Materia: CIENCIA - Promedio: 5.5
  Materia: HISTORIA - Promedio: 6.0
```

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, realiza un fork, crea una rama y haz una solicitud de extracción.

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y realiza un commit (`git commit -m 'Agregar nueva funcionalidad'`).
4. Sube la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre una solicitud de extracción.


## Licencia

- **Licencia del Proyecto:** Informa sobre los derechos de uso del proyecto.

Este proyecto está licenciado bajo la [MIT License](LICENSE).
