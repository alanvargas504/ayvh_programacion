package ejercicio

import java.util.Scanner;

4.1;

public class valor {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese x: ");
        double x = sc.nextDouble();

        System.out.print("Ingrese y: ");
        double y = sc.nextDouble();

        System.out.print("Ingrese z: ");
        double z = sc.nextDouble();

        if (x > y && z < 20) {
            System.out.print("Ingrese p: ");
            double p = sc.nextDouble();
        }

        sc.close();

