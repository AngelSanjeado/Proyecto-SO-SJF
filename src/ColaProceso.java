import java.util.ArrayList;
import java.util.PriorityQueue;

public class ColaProceso {
    private PriorityQueue<Proceso> procesos;
    private PriorityQueue<Proceso> copia;

    public ColaProceso(){
        procesos = new PriorityQueue<>();
    }

    public void agregarProcesos(ArrayList<Proceso> proceso){
        procesos.addAll(proceso);
    }

    public void copiarProcesos() {
        copia = new PriorityQueue<>();
        copia.addAll(procesos);
    }

    //Tampoco toquen esto, no sé por qué, pero funcionó
    public void mostrarCopia(){
        while (!copia.isEmpty()){
            System.out.println(copia.poll());
        }
    }

    public void ejecutarProcesos(){
        while (!procesos.isEmpty()) {
            Proceso procesoTemporal = procesos.poll();
            System.out.printf(procesoTemporal.mostrarOperacion());
            Main.momento += procesoTemporal.getTiempoRafaga();
        }
    }
}
