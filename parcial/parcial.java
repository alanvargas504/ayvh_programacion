import java.util.Scanner;

public class parcial {

private static final int CLAVE = 1234;

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);
final int SALDO_INICIAL = 800000;

int claveUsuario1;
int retiro;
int nuevoSaldo;

System.out.print("Ingrese su clave: ");
claveUsuario1 = scanner.nextInt();

if (claveUsuario1 == CLAVE) {

System.out.println("Bienvenido al cajero de la uniajc");
System.out.println("Digite la cantidad a retirar: ");
retiro = scanner.nextInt();

// costo de transaccion si supera 200000
if (retiro > 200000) {
retiro = retiro + 2000;
}

if (retiro <= SALDO_INICIAL) {
nuevoSaldo = SALDO_INICIAL - retiro;
System.out.println("Su saldo actual es: " + nuevoSaldo);
System.out.println("Muchas gracias");
} else {
System.out.println("El valor solicitado es mayor al saldo actual.");
}

} else {
System.out.println("Su clave no es correcta... intenta nuevamente");
}

scanner.close();
}
}
