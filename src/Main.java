import java.util.ArrayList;

public class Main {
    public static int momento = 0;
    public static void main(String[] arg){

        Proceso p1 = new Proceso("P1", 6);
        Proceso p2 = new Proceso("P2", 8);
        Proceso p3 = new Proceso("P3", 3);
        Proceso p4 = new Proceso("P4", 3);

        ArrayList<Proceso> procesos = new ArrayList<>();
        procesos.add(p1);
        procesos.add(p2);
        procesos.add(p3);
        procesos.add(p4);

        ColaProceso procesosOrdenados = new ColaProceso();
        procesosOrdenados.agregarProcesos(procesos);
        procesosOrdenados.copiarProcesos();

        System.out.println("\nLista de procesos");
        System.out.println("-------------------------------");
        System.out.printf("| %-7s | %-17s |\n","", "     Tiempo    ");
        System.out.printf("| %-7s |%-7s|%-7s|\n", "Proceso", "---------", "---------");
        System.out.printf("| %-7s | %-7s | %-7s |\n", "", "Ráfaga", "Llegada");
        System.out.println("-------------------------------");

        for (Proceso p: procesos){
            System.out.println(p.toString());
        }

        System.out.println("-------------------------------");

        System.out.println("\nLista de procesos ordenados por ráfaga");
        System.out.println("-------------------------------");
        System.out.printf("| %-7s | %-17s |\n","", "     Tiempo    ");
        System.out.printf("| %-7s |%-7s|%-7s|\n", "Proceso", "---------", "---------");
        System.out.printf("| %-7s | %-7s | %-7s |\n", "", "Ráfaga", "Llegada");
        System.out.println("-------------------------------");

        procesosOrdenados.mostrarCopia(); //Ayuda, no entiendo por qué funcionó esto. O soy muy bueno o tengo mucha suerte

        System.out.println("-------------------------------");

        System.out.println("\nProcesos por ordenados por prioridad (tiempo de ráfaga)");
        System.out.println("---------------------------------------");
        System.out.printf("| %-8s | %-6s | %-12s |\n", "", "", "    Momento    ");
        System.out.printf("| %-8s | %-6s |%-6s|%-6s|\n", "Proceso", "Ráfaga", "--------", "--------");
        System.out.printf("| %-8s | %-6s | %-6s | %-6s |\n", "", "", "Inicio", " Fin");
        System.out.println("---------------------------------------");

        procesosOrdenados.ejecutarProcesos();

        System.out.println("---------------------------------------");

    }
}
