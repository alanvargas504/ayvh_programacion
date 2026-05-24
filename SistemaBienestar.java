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

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void sumarHoras(int horas) {
        this.horas += horas;
    }

    public void restarHoras(int horas) {
        this.horas -= horas;
    }
}

class Actividad {

    private int codigo;
    private String nombre;
    private int cupos;
    private int horas;

    ArrayList<Estudiante> inscritos =
            new ArrayList<>();

    ArrayList<Estudiante> espera =
            new ArrayList<>();

    public Actividad(int codigo, String nombre,
                     int cupos, int horas) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.horas = horas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCupos() {
        return cupos;
    }

    public int getHoras() {
        return horas;
    }
}

public class SistemaBienestar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Estudiante> estudiantes =
                new ArrayList<>();

        ArrayList<Actividad> actividades =
                new ArrayList<>();

        int opcion = 0;

        while(opcion != 6){

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Crear actividad");
            System.out.println("3. Inscribir");
            System.out.println("4. Cancelar inscripción");
            System.out.println("5. Ver reportes");
            System.out.println("6. Salir");

            opcion = sc.nextInt();

            switch(opcion){

                case 1:

                    System.out.println("ID:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nombre:");
                    String nombre = sc.nextLine();

                    Estudiante e =
                            new Estudiante(id, nombre);

                    estudiantes.add(e);

                    System.out.println("Estudiante guardado");

                break;

                case 2:

                    System.out.println("Codigo:");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nombre actividad:");
                    String nom = sc.nextLine();

                    System.out.println("Cupos:");
                    int cupos = sc.nextInt();

                    System.out.println("Horas:");
                    int horas = sc.nextInt();

                    Actividad a =
                            new Actividad(codigo,
                                    nom, cupos, horas);

                    actividades.add(a);

                    System.out.println("Actividad creada");

                break;

                case 3:

                    System.out.println("ID estudiante:");
                    int buscarId = sc.nextInt();

                    System.out.println("Codigo actividad:");
                    int buscarAct = sc.nextInt();

                    Estudiante estudiante = null;
                    Actividad actividad = null;

                    // Buscar estudiante
                    for(Estudiante est : estudiantes){

                        if(est.getId() == buscarId){
                            estudiante = est;
                        }
                    }

                    // Buscar actividad
                    for(Actividad act : actividades){

                        if(act.getCodigo() == buscarAct){
                            actividad = act;
                        }
                    }

                    if(estudiante != null &&
                            actividad != null){

                        // Validar cupos
                        if(actividad.inscritos.size()
                                < actividad.getCupos()){

                            actividad.inscritos
                                    .add(estudiante);

                            estudiante.sumarHoras(
                                    actividad.getHoras());

                            System.out.println(
                                    "Inscripción exitosa");

                        }else{

                            actividad.espera
                                    .add(estudiante);

                            System.out.println(
                                    "Sin cupos");
                            System.out.println(
                                    "Agregado a espera");
                        }

                    }else{

                        System.out.println(
                                "Datos incorrectos");
                    }

                break;

                case 4:

                    System.out.println(
                            "Codigo actividad:");

                    int cod = sc.nextInt();

                    for(Actividad act : actividades){

                        if(act.getCodigo() == cod){

                            if(act.inscritos.size() > 0){

                                Estudiante eliminado =
                                        act.inscritos.remove(0);

                                eliminado.restarHoras(2);

                                System.out.println(
                                        "Penalización aplicada");

                                // Lista espera
                                if(act.espera.size() > 0){

                                    Estudiante nuevo =
                                            act.espera.remove(0);

                                    act.inscritos.add(nuevo);

                                    System.out.println(
                                            "Nuevo inscrito");
                                }
                            }
                        }
                    }

                break;

                case 5:

                    for(Estudiante est : estudiantes){

                        System.out.println(
                                "\nNombre: "
                                + est.getNombre());

                        System.out.println(
                                "Horas: "
                                + est.getHoras());

                        // Certificación
                        if(est.getHoras() >= 30){

                            System.out.println(
                                    "APTO");

                        }else{

                            System.out.println(
                                    "NO APTO");
                        }
                    }

                break;

                case 6:

                    System.out.println(
                            "Sistema finalizado");

                break;

                default:

                    System.out.println(
                            "Opción inválida");
            }
        }
    }
}