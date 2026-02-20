import java.util.Scanner;

/**
 * Ejercicio 2: Contador de vocales y consonantes
 * La palabra no contiene símbolos, caracteres especiales, acentos, ni números
 * y siempre estará en minúsculas.
 */
public class ContadorVocalesConsonantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Contador de Vocales y Consonantes ===");
        System.out.print("Ingresa una palabra (solo letras minúsculas, sin acentos): ");
        String palabra = scanner.nextLine();

        int vocales = 0;
        int consonantes = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (esVocal(letra)) {
                vocales++;
            } else if (letra >= 'a' && letra <= 'z') {
                consonantes++;
            }
        }

        System.out.println("\nPalabra: " + palabra);
        System.out.println("Vocales:     " + vocales);
        System.out.println("Consonantes: " + consonantes);

        scanner.close();
    }

    /**
     * Determina si un carácter es una vocal.
     * @param c carácter a evaluar
     * @return true si es vocal, false en caso contrario
     */
    public static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
