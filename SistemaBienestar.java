import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    private int id;
    private String nombre;
    private int horas;

    public Estudiante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.horas = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getHoras() { return horas; }

    public void modificarHoras(int cantidad) {
        this.horas += cantidad;
    }
}

class Actividad {
    private int codigo;
    private String nombre;
    private int cupos;
    private int horas;
    
    // Dejamos las listas públicas o accesibles para simplificar el manejo en el main
    public ArrayList<Estudiante> inscritos = new ArrayList<>();
    public ArrayList<Estudiante> listaEspera = new ArrayList<>();

    public Actividad(int codigo, String nombre, int cupos, int horas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.horas = horas;
    }

    public int getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCupos() { return cupos; }
    public int getHoras() { return horas; }
}

public class SistemaBienestar {
    
    // Scanner global para evitar conflictos de buffer en métodos estáticos
    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    private static ArrayList<Actividad> listaActividades = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;
        
        do {
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Crear Actividad");
            System.out.println("3. Inscribir Alumno");
            System.out.println("4. Cancelar Cupo (Baja)");
            System.out.println("5. Reporte de Estado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            if (!teclado.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                teclado.nextLine();
                continue;
            }
            op = teclado.nextInt();
            teclado.nextLine(); // Limpieza limpia del buffer siempre

            switch(op) {
                case 1: registrarEstudiante(); break;
                case 2: crearActividad(); break;
                case 3: ejecutarInscripcion(); break;
                case 4: darDeBaja(); break;
                case 5: mostrarReportes(); break;
                case 6: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción no disponible.");
            }
        } while (op != 6);
    }

    private static void registrarEstudiante() {
        System.out.print("ID del estudiante: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nombre completo: ");
        String nom = teclado.nextLine();

        listaEstudiantes.add(new Estudiante(id, nom));
        System.out.println(">> Estudiante registrado correctamente.");
    }

    private static void crearActividad() {
        System.out.print("Código de actividad: ");
        int cod = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Nombre de la actividad: ");
        String nombre = teclado.nextLine();
        System.out.print("Cupos disponibles: ");
        String cuposRaw = teclado.nextLine(); 
        int cupos = Integer.parseInt(cuposRaw);
        System.out.print("Horas que otorga: ");
        int hrs = teclado.nextInt();
        teclado.nextLine();

        listaActividades.add(new Actividad(cod, nombre, cupos, hrs));
        System.out.println(">> Actividad aperturada.");
    }

    private static void ejecutarInscripcion() {
        System.out.print("ID Estudiante: ");
        int idBuscar = teclado.nextInt();
        System.out.print("Código Actividad: ");
        int codBuscar = teclado.nextInt();
        teclado.nextLine();

        Estudiante alumno = null;
        for (Estudiante e : listaEstudiantes) {
            if (e.getId() == idBuscar) { alumno = e; break; }
        }

        Actividad act = null;
        for (Actividad a : listaActividades) {
            if (a.getCodigo() == codBuscar) { act = a; break; }
        }

        if (alumno == null || act == null) {
            System.out.println("[Error] No se encontró el estudiante o la actividad.");
            return;
        }

        // Lógica de inscripción
        if (act.inscritos.size() < act.getCupos()) {
            act.inscritos.add(alumno);
            alumno.modificarHoras(act.getHoras());
            System.out.println("Inscripción confirmada en " + act.getNombre());
        } else {
            act.listaEspera.add(alumno);
            System.out.println("Cupos llenos. El alumno quedó en lista de espera.");
        }
    }

    private static void darDeBaja() {
        System.out.print("Código de la actividad: ");
        int cod = teclado.nextInt();
        System.out.print("ID del estudiante a retirar: ");
        int idEst = teclado.nextInt();
        teclado.nextLine();

        Actividad actividad = null;
        for (Actividad a : listaActividades) {
            if (a.getCodigo() == cod) { actividad = a; break; }
        }

        if (actividad == null) {
            System.out.println("[Error] Actividad no encontrada.");
            return;
        }

        Estudiante aEliminar = null;
        for (Estudiante e : actividad.inscritos) {
            if (e.getId() == idEst) { aEliminar = e; break; }
        }

        if (aEliminar != null) {
            actividad.inscritos.remove(aEliminar);
            aEliminar.modificarHoras(-2); // Penalización por cancelación
            System.out.println("Estudiante retirado. Penalización de -2 horas aplicada.");

            // Si hay alguien en espera, sube a inscritos y SI se le suman horas
            if (!actividad.listaEspera.isEmpty()) {
                Estudiante elSiguiente = actividad.listaEspera.remove(0);
                actividad.inscritos.add(elSiguiente);
                elSiguiente.modificarHoras(actividad.getHoras());
                System.out.println("El estudiante " + elSiguiente.getNombre() + " ha salido de la lista de espera e ingresó a la actividad.");
            }
        } else {
            System.out.println("El estudiante no estaba inscrito en esa actividad.");
        }
    }

    private static void mostrarReportes() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }
        
        System.out.println("\n--- REPORTES DE ALUMNOS ---");
        for (Estudiante est : listaEstudiantes) {
            String estado = (est.getHoras() >= 30) ? "APTO" : "NO APTO";
            System.out.printf("Alumno: %-20s | Horas: %-3d | Estado: %s\n", 
                    est.getNombre(), est.getHoras(), estado);
        }
    }
}