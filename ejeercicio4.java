import java.util.Scanner;

public class ejeercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el salario bruto: ");
        double salario_bruto = sc.nextDouble();

        System.out.print("Ingrese las deducciones: ");
        double deducciones = sc.nextDouble();

        System.out.print("Ingrese la comision: ");
        double comision = sc.nextDouble();

        double salario_neto = (salario_bruto - deducciones) + comision;

        System.out.println("El salario neto es: " + salario_neto);

        sc.close();
    }
}
