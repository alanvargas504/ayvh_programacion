import java.util.Scanner;

public class AnguloRecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el valor del angulo: ");
        double angulo = sc.nextDouble();

        if (angulo == 90) {
            System.out.println("El angulo es un angulo recto");
        } else {
            System.out.println("El angulo no es un angulo recto");
        }

        sc.close();
    }
}