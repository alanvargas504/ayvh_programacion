import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    int id; String nombre; int horas = 0;
}

class Actividad {
    int codigo; String nombre; int cupos; int horas;
    ArrayList<Estudiante> inscritos = new ArrayList<>();
    ArrayList<Estudiante> espera = new ArrayList<>();
}

public class SistemaBienestar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> alumnos = new ArrayList<>();
        ArrayList<Actividad> actividades = new ArrayList<>();
        int op = 0;

        while (op != 6) {
            System.out.print("\n1.Reg Alumno, 2.Reg Act, 3.Inscribir, 4.Baja, 5.Reporte, 6.Salir\nOpción: ");
            op = sc.nextInt();

            if (op == 1) {
                Estudiante e = new Estudiante();
                System.out.print("ID y Nombre: "); e.id = sc.nextInt(); e.nombre = sc.next();
                alumnos.add(e);
            } 
            else if (op == 2) {
                Actividad a = new Actividad();
                System.out.print("Cod, Nombre, Cupos, Horas: ");
                a.codigo = sc.nextInt(); a.nombre = sc.next(); a.cupos = sc.nextInt(); a.horas = sc.nextInt();
                actividades.add(a);
            } 
            else if (op == 3) {
                System.out.print("ID Alumno y Cod Actividad: "); int idA = sc.nextInt(), codA = sc.nextInt();
                
                // Buscar rápido
                Estudiante est = null; for(Estudiante e : alumnos) if(e.id == idA) est = e;
                Actividad act = null; for(Actividad a : actividades) if(a.codigo == codA) act = a;

                if (est != null && act != null) {
                    if (act.inscritos.size() < act.cupos) {
                        act.inscritos.add(est);
                        est.horas += act.horas;
                        System.out.println("Inscrito.");
                    } else {
                        act.espera.add(est);
                        System.out.println("A lista de espera.");
                    }
                }
            } 
            else if (op == 4) {
                System.out.print("Cod Actividad e ID Alumno: "); int codA = sc.nextInt(), idA = sc.nextInt();
                
                Actividad act = null; for(Actividad a : actividades) if(a.codigo == codA) act = a;

                if (act != null) {
                    Estudiante borrar = null; for(Estudiante e : act.inscritos) if(e.id == idA) borrar = e;

                    if (borrar != null) {
                        act.inscritos.remove(borrar);
                        borrar.horas -= 2; // Penalización
                        System.out.println("Dado de baja (-2h).");

                        if (act.espera.size() > 0) {
                            Estudiante siguiente = act.espera.remove(0);
                            act.inscritos.add(siguiente);
                            siguiente.horas += act.horas; // Suma horas al salir de espera
                            System.out.println(siguiente.nombre + " subió de la espera.");
                        }
                    }
                }
            } 
            else if (op == 5) {
                System.out.println("\n--- REPORTES ---");
                for (Estudiante e : alumnos) {
                    System.out.println(e.nombre + " - Horas: " + e.horas + " [" + (e.horas >= 30 ? "APTO" : "NO APTO") + "]");
                }
            }
        }
        System.out.println("Fin del programa.");
    }
}