import java.util.Scanner;

public class ejercicio412 {
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            System.out.println("El primer número es el mayor");
        }

        if (num1 < num2) {
            System.out.println("El primer número es el más pequeño");
        }

        if (num1 == num2) {
            System.out.println("Ambos números son iguales");
        }

        sc.close();
    }
}

