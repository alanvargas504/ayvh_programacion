import java.util.Scanner;

public class raizcuadrada413 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        double numero = scanner.nextDouble();

        if (numero < 0) {
            System.out.println("No se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            double resultado = Math.sqrt(numero);
            System.out.println("La raíz cuadrada de " + numero + " es: " + resultado);
        }

        scanner.close();
    }
}