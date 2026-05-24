import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 Celsius a Faherenheit");
        System.out.println("2 Fahrenheit a Celsius");
        System.out.print("elija una opcion: ");
        int opcion = sc.nextInt();

        if(opcion== 1) {
            System.out.print("Ingrese grados Celsius: ");
            double C = sc. nextDouble();
            double F = (C * 9/5) + 32;
            System.out.println("Ingrese grados Fahrenheit es: " + F);
         } else if (opcion == 2) {
            System.out.print("Ingrese grados Fahrenheit: ");
            double F = sc.nextDouble();
            double C = (F - 32) * 5/9;
            System.out.println("En celsius es: " + C);
         } else {
            System.out.println("opcion no valida");
         }

         sc.close();
        
    }
}
