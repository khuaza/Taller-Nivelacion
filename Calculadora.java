import java.util.Scanner;

/**
 * Ejercicio 1: Calculadora básica
 * Realiza operaciones de suma, resta, multiplicación y división.
 */
public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculadora Básica ===");
        System.out.print("Ingresa el primer número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nSelecciona una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        double resultado;

        switch (opcion) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado: " + num1 + " + " + num2 + " = " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado: " + num1 + " * " + num2 + " = " + resultado);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: No se puede dividir entre cero.");
                } else {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + num1 + " / " + num2 + " = " + resultado);
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
