import java.util.Scanner;

public class PuntoEbullicion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la temperatura: ");
        double temperatura = sc.nextDouble();

        if (temperatura > 100) {
            System.out.println("Por encima del punto de ebullicion del agua");
        } else {
            System.out.println("Por debajo del punto de ebullicion del agua");
        }

        sc.close();
    }
}