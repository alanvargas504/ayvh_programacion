import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el numero de horas: ");
        double horas = sc.nextDouble();

        double subtotal = horas * 2000;
        double iva = subtotal * 0.20;
        double total = subtotal + iva;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (20%): " + iva);
        System.out.println("Total a pagar: " + total);

        sc.close();
    }
}
