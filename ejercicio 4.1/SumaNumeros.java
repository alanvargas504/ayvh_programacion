

import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalPositivos = 0;
        double totalNegativos = 0;

        System.out.print("Ingrese un numero: ");
        double numero = sc.nextDouble();

        if (numero > 0) {
            totalPositivos = totalPositivos + numero;
        } else {
            totalNegativos = totalNegativos + numero;
        }

        System.out.println("Total de positivos: " + totalPositivos);
        System.out.println("Total de negativos: " + totalNegativos);

        sc.close();
    }
}

