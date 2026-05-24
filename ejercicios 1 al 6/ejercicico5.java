import java.util.Scanner;

public class ejercicico5 {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad en pesos: ");
        double pesos = sc.nextDouble();

        System.out.print("Ingrese la tasa del dolar: ");
        double tasaDolar = sc.nextDouble();

        System.out.print("Ingrese la tasa del euro: ");
        double tasaEuro = sc.nextDouble();

        double dolares = pesos / tasaDolar;
        double euros = pesos / tasaEuro;

        System.out.println("En dolares es: " + dolares);
        System.out.println("En euros es: " + euros);

        sc.close();
    }
}
