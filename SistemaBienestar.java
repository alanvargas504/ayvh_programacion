import java.util.Scanner;

class Estudiante {
    int id;
    String nombre;
    int horas;
}

class Actividad {
    int codigo;
    String nombre;
    int cupos;
    int horas;
    
    Estudiante[] inscritos = new Estudiante[50];
    Estudiante[] espera = new Estudiante[50];
    
    int cantInscritos = 0;
    int cantEspera = 0;
}

public class SistemaBienestar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        Estudiante[] alumnos = new Estudiante[100];
        int totalAlumnos = 0; 
        
        Actividad[] actividades = new Actividad[20];
        int totalActividades = 0;

        int op = 0;

        while (op != 6) {
            System.out.println("\n--- BIENESTAR ---");
            System.out.println("1. Reg Alumno\n2. Reg Actividad\n3. Inscribir\n4. Dar de Baja\n5. Reporte\n6. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();

            if (op == 1) {
                Estudiante e = new Estudiante();
                System.out.print("ID del alumno: "); e.id = sc.nextInt();
                System.out.print("Primer nombre: "); e.nombre = sc.next();
                e.horas = 0;
                
                alumnos[totalAlumnos] = e; 
                totalAlumnos++; 
                System.out.println("Alumno guardado.");
            } 
            else if (op == 2) {
                Actividad a = new Actividad();
                System.out.print("Código: "); a.codigo = sc.nextInt();
                System.out.print("Nombre act: "); a.nombre = sc.next();
                System.out.print("Cupos: "); a.cupos = sc.nextInt();
                System.out.print("Horas: "); a.horas = sc.nextInt();
                
                actividades[totalActividades] = a;
                totalActividades++;
                System.out.println("Actividad guardada.");
            } 
            else if (op == 3) {
                System.out.print("ID Alumno: "); int idA = sc.nextInt();
                System.out.print("Cod Actividad: "); int codA = sc.nextInt();
                
                
                Estudiante est = null;
                for (int i = 0; i < totalAlumnos; i++) {
                    if (alumnos[i].id == idA) {
                        est = alumnos[i];
                    }
                }
                
                
                Actividad act = null;
                for (int i = 0; i < totalActividades; i++) {
                    if (actividades[i].codigo == codA) {
                        act = actividades[i];
                    }
                }

                if (est != null && act != null) {
                    
                    if (act.cantInscritos < act.cupos) {
                        act.inscritos[act.cantInscritos] = est;
                        act.cantInscritos++;
                        est.horas += act.horas;
                        System.out.println("Inscrito con éxito.");
                    } else {
                        act.espera[act.cantEspera] = est;
                        act.cantEspera++;
                        System.out.println("Lleno. Enviado a lista de espera.");
                    }
                } else {
                    System.out.println("No se encontraron los datos.");
                }
            } 
            else if (op == 4) {
                System.out.print("Cod Actividad: "); int codA = sc.nextInt();
                System.out.print("ID Alumno: "); int idA = sc.nextInt();
                
                Actividad act = null;
                for (int i = 0; i < totalActividades; i++) {
                    if (actividades[i].codigo == codA) act = actividades[i];
                }

                if (act != null) {
                    int posicionBorrar = -1;
                   
                    for (int i = 0; i < act.cantInscritos; i++) {
                        if (act.inscritos[i].id == idA) {
                            posicionBorrar = i;
                            break;
                        }
                    }

                    if (posicionBorrar != -1) {
                        Estudiante borrado = act.inscritos[posicionBorrar];
                        borrado.horas -= 2; 
                        
                       
                        for (int i = posicionBorrar; i < act.cantInscritos - 1; i++) {
                            act.inscritos[i] = act.inscritos[i + 1];
                        }
                        act.cantInscritos--; 
                        System.out.println("Dado de baja. Se restaron 2 horas.");

                      
                        if (act.cantEspera > 0) {
                            Estudiante siguiente = act.espera[0]; 
                            
                            act.inscritos[act.cantInscritos] = siguiente; 
                            act.cantInscritos++;
                            siguiente.horas += act.horas; 
                            
                            
                            for (int i = 0; i < act.cantEspera - 1; i++) {
                                act.espera[i] = act.espera[i + 1];
                            }
                            act.cantEspera--;
                            System.out.println(siguiente.nombre + " subió de la lista de espera.");
                        }
                    } else {
                        System.out.println("El alumno no está inscrito en esta actividad.");
                    }
                }
            } 
            else if (op == 5) {
                System.out.println("\n--- REPORTES ---");
                for (int i = 0; i < totalAlumnos; i++) {
                    String estado = "NO APTO";
                    if (alumnos[i].horas >= 30) {
                        estado = "APTO";
                    }
                    System.out.println(alumnos[i].nombre + " - Horas: " + alumnos[i].horas + " [" + estado + "]");
                }
            }
        }
        System.out.println("Programa terminado.");
    }
}