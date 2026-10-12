import java.util.Scanner;
import java.util.InputMismatchException;

public class Notas {

    // Función X: Solicita los nombres y retorna el vector con la información
    public static String[] solicitarNombres(Scanner sc) {
        String[] nombres = new String[5];
        
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
        }
        
        System.out.println("¡Nombres registrados correctamente!");
        return nombres;
    }

    // Función Y: Solicita las notas correspondientes en orden y retorna el vector de notas
    public static double[] solicitarNotas(Scanner sc, String[] nombres) {
        double[] notas = new double[5];
        
        for (int i = 0; i < nombres.length; i++) {
            boolean notaValida = false;
            do {
                System.out.print("Ingrese la nota para " + nombres[i] + " (entre 1.0 y 10.0): ");
                try {
                    notas[i] = sc.nextDouble();
                    if (notas[i] >= 1.0 && notas[i] <= 10.0) {
                        notaValida = true;
                    } else {
                        System.out.println("Error: La nota debe estar entre 1.0 y 10.0.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un valor numérico válido (use coma para decimales).");
                    notaValida = false;
                } finally {
                    sc.nextLine(); // Limpiar búfer
                }
            } while (!notaValida);
        }
        
        System.out.println("¡Notas registradas correctamente!");
        return notas;
    }

    // Método nuevo para consultar toda la información registrada
    public static void mostrarTodosLosRegistros(String[] nombres, double[] notas) {
        System.out.println("\n\t\t//////////// LISTADO GENERAL DE ESTUDIANTES ////////////");
        System.out.println("\nNombre\t\t\tNota");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + "\t\t\t" + notas[i]);
        }
    }

    // Método para calcular promedio e imprimir los que están por debajo
    public static void mostrarEstudiantesBajoPromedio(String[] nombres, double[] notas) {
        double totalNotas = 0;
        
        for (int i = 0; i < notas.length; i++) {
            totalNotas += notas[i];
        }

        double promedioCurso = totalNotas / notas.length;

        System.out.println("\nEl promedio del curso es: " + promedioCurso);
        System.out.println("Listado de estudiantes por debajo del promedio:");
        System.out.println("Nombre\t\t\tNota");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < nombres.length; i++) {
            if (notas[i] < promedioCurso) {
                System.out.println(nombres[i] + "\t\t\t" + notas[i]);
            }
        }
    }
}