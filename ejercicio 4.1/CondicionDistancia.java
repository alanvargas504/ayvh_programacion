package ejercicio 4.1;

public class CondicionDistancia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la distancia: ");
        double distancia = sc.nextDouble();

        if (distancia > 20 && distancia < 35) {
            System.out.print("Ingrese el tiempo: ");
            double tiempo = sc.nextDouble();
        }

        sc.close();
    }
}
