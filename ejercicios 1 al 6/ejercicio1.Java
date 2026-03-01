import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("ingrese el lado del cuadrado: ");
        double b = sc.nextDouble();

        double A = b * b;

        System.out.print("el area del cuadrado es: " + A);
    }
        
}