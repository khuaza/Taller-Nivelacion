import java.util.Scanner;

/**
 * Ejercicio 3: Invertir una cadena de texto ingresada por el usuario.
 */
public class InvertirCadena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Invertir Cadena de Texto ===");
        System.out.print("Ingresa una cadena de texto: ");
        String texto = scanner.nextLine();

        String invertida = invertir(texto);

        System.out.println("\nTexto original: " + texto);
        System.out.println("Texto invertido: " + invertida);

        scanner.close();
    }

    /**
     * Invierte una cadena de texto carácter por carácter.
     * @param texto la cadena a invertir
     * @return la cadena invertida
     */
    public static String invertir(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado += texto.charAt(i);
        }
        return resultado;
    }
}
