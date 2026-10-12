import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la tarea 1 de reconocimiento.");

        String[] nombresEstudiantes = null;
        double[] notasEstudiantes = null;
        int opcMenu = 0;

        do {
            System.out.println("\n\t\t//////////// MENÚ PRINCIPAL ////////////");
            System.out.println("1. Agregar información de los estudiantes (Nombres y Notas)");
            System.out.println("2. Mostrar toda la información registrada");
            System.out.println("3. Mostrar notas y promedios (Estudiantes bajo el promedio)");
            System.out.println("4. Salir del programa");
            System.out.print("\nIngrese su opción: ");

            try {
                opcMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido.");
                sc.nextLine();
                continue;
            }
            sc.nextLine(); // Limpiar búfer

            switch (opcMenu) {
                case 1:
                    nombresEstudiantes = Notas.solicitarNombres(sc);
                    notasEstudiantes = Notas.solicitarNotas(sc, nombresEstudiantes);
                    break;
                case 2:
                    if (nombresEstudiantes != null && notasEstudiantes != null) {
                        Notas.mostrarTodosLosRegistros(nombresEstudiantes, notasEstudiantes);
                    } else {
                        System.out.println("\nPrimero debe registrar la información de los estudiantes (Opción 1).");
                    }
                    break;
                case 3:
                    if (nombresEstudiantes != null && notasEstudiantes != null) {
                        Notas.mostrarEstudiantesBajoPromedio(nombresEstudiantes, notasEstudiantes);
                    } else {
                        System.out.println("\nPrimero debe registrar la información de los estudiantes (Opción 1).");
                    }
                    break;
                case 4:
                    System.out.println("\nHas seleccionado SALIR, gracias, vuelve pronto.");
                    break;
                default:
                    System.out.println("\t\tIngrese un valor que corresponda con las opciones del menú.");
                    break;
            }
        } while (opcMenu != 4);

        sc.close();
    }
}