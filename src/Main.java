import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int momentoActual = 0;
    public static int momentoInicio = 0;
    public static int momentoFinal = 0;

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        ArrayList<Proceso> procesos = new ArrayList<>();

        System.out.println("====== Simulación de algoritmo SJF (Shortest Job First) ======");
        System.out.print("\n¿Cuántos procesos se van a ejecutar?: ");
        int ejecuciones = sc.nextInt();

        for (int i = 0; i < ejecuciones; i++) {
            System.out.print("\n\tNombre: ");
            String nombre = sc.next();
            System.out.print("\tTiempo de llegada: ");
            int llegada = sc.nextInt();
            System.out.print("\tTiempo de ráfaga: ");
            int rafaga = sc.nextInt();

            procesos.add(new Proceso(nombre, llegada, rafaga));
        }


        ColaProceso procesosOrdenados = new ColaProceso();
        procesosOrdenados.agregarProcesos(procesos);

        System.out.println("\n1. Lista de procesos");
        System.out.println("-------------------------------");
        System.out.printf("| %-7s | %-17s |\n","", "     Tiempo    ");
        System.out.printf("| %-7s |%-7s|%-7s|\n", "Proceso", "---------", "---------");
        System.out.printf("| %-7s | %-7s | %-7s |\n", "", "Ráfaga", "Llegada");
        System.out.println("-------------------------------");

        for (Proceso p: procesos){
            System.out.print(p.toString());
        }

        System.out.println("-------------------------------");

        System.out.println("\n2. Lista de procesos ordenados por tiempo de llegada y ráfaga");
        System.out.println("-------------------------------");
        System.out.printf("| %-7s | %-17s |\n","", "     Tiempo    ");
        System.out.printf("| %-7s |%-7s|%-7s|\n", "Proceso", "---------", "---------");
        System.out.printf("| %-7s | %-7s | %-7s |\n", "", "Ráfaga", "Llegada");
        System.out.println("-------------------------------");

        procesosOrdenados.procesosOrdenados();

        System.out.println("-------------------------------\n");

        System.out.println("Fórmulas para las métricas");
        System.out.println("Tiempo de respuesta = Tiempo finalización - tiempo de llegada");
        System.out.println("Tiempo de espera = Tiempo de respuesta - tiempo de ráfaga");

        System.out.println("\n3. Tabla de ejecución");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("| %-7s | %-17s | %-12s | %-18s |\n", "", "     Tiempo    ", "    Momento    ", "      Tiempo     ");
        System.out.printf("| %-7s |%-7s|%-7s|%-6s|%-6s|%-9s|%-6s|\n", "Proceso", "---------", "---------", "--------", "--------", "-----------", "--------");
        System.out.printf("| %-7s | %-7s | %-7s | %-6s | %-6s | %-9s | %-6s |\n", "", "Llegada", "Ráfaga", "Inicio", " Fin", "Respuesta", "Espera");
        System.out.println("----------------------------------------------------------------------");

        procesosOrdenados.ejecutarProcesos();

        System.out.println("----------------------------------------------------------------------\n");

        System.out.printf("Tiempo promedio de respuesta: %.2f\n", procesosOrdenados.promedioRespuesta());
        System.out.printf("Tiempo promedio de espera: %.2f", procesosOrdenados.promedioEspera());
    }
}

