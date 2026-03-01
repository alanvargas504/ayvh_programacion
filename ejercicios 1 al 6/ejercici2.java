import java.util.Scanner;

public class ejercici2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio del circulo: ");
        double r = sc. nextDouble();

        double A = 31416 * r * r;

        System.out.println("El area del circulo es:" + A);

        sc.close();
    }
}