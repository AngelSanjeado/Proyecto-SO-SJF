import java.util.ArrayList;
import java.util.Comparator;

public class ColaProceso{
    private static int sumaEspera;
    private static int sumaRespuesta;
    private ArrayList<Proceso> procesosListos;

    public ColaProceso(){
        procesosListos = new ArrayList<>();
    }

    public void agregarProcesos(ArrayList<Proceso> listaProcesos){
        procesosListos.addAll(listaProcesos);
    }

    public void ordenarProcesos(){
        procesosListos.sort(Comparator.comparingInt(Proceso::getTiempoLlegada));
    }

    public void procesosOrdenados(){
        ordenarProcesos();

        int momentoActualSimulado = 0;
        ArrayList<Proceso> listaTemporal = new ArrayList<>(procesosListos);
        ArrayList<Proceso> ordenEjecucion = new ArrayList<>();
        
        while (!listaTemporal.isEmpty()){
            ArrayList<Proceso> procesosEnLista = new ArrayList<>();

            for (Proceso p: listaTemporal){
                if (p.getTiempoLlegada() <= momentoActualSimulado){
                    procesosEnLista.add(p);
                }
            }

            if (procesosEnLista.isEmpty()){
                Proceso siguienteProceso = listaTemporal.getFirst();
                momentoActualSimulado = siguienteProceso.getTiempoLlegada();
                procesosEnLista.add(siguienteProceso);
            }

            Proceso menorProceso = menorRafaga(procesosEnLista);
            
            if (menorProceso != null){
                ordenEjecucion.add(menorProceso);
                momentoActualSimulado += menorProceso.getTiempoRafaga();
                listaTemporal.remove(menorProceso);
            }
        }

        for (Proceso p: ordenEjecucion){
            System.out.print(p.toString());
        }
    }

    public void ejecutarProcesos(){

        ordenarProcesos();

        ArrayList<Proceso> procesosCompletados = new ArrayList<>();
        Proceso menorProceso = null;
        
        ArrayList<Proceso> listaTemporal = new ArrayList<>(procesosListos);

        while (!listaTemporal.isEmpty()){

            ArrayList<Proceso> procesosEnLista = new ArrayList<>();

            for (Proceso p: listaTemporal){
                if (p.getTiempoLlegada() <= Main.momentoActual){
                    procesosEnLista.add(p);
                }
            }

            if (procesosEnLista.isEmpty()){
                Proceso siguienteProceso = listaTemporal.getFirst();
                Main.momentoActual = siguienteProceso.getTiempoLlegada();
                procesosEnLista.add(siguienteProceso);
            }

            menorProceso = menorRafaga(procesosEnLista);

            if (menorProceso != null){
                Main.momentoInicio = Main.momentoActual;
                Main.momentoActual += menorProceso.getTiempoRafaga();
                Main.momentoFinal = Main.momentoActual;

                sumaEspera += menorProceso.tiempoEspera();
                sumaRespuesta += menorProceso.tiempoRespuesta();

                System.out.printf(menorProceso.mostrarOperacion());
                procesosCompletados.add(menorProceso);
                listaTemporal.remove(menorProceso);
            }
        }
    }

    public double promedioRespuesta(){
        return (double) sumaRespuesta/procesosListos.size();
    }

    public double promedioEspera(){
        return (double) sumaEspera/procesosListos.size();
    }

    public Proceso menorRafaga(ArrayList<Proceso> procesos){
    
        if(procesos.isEmpty()){
            return null;
        }

        if(procesos.size() == 1) {
            return procesos.getFirst();
        }

        Proceso menor = procesos.getFirst();
        int minimo = menor.getTiempoRafaga();

        for (Proceso p : procesos) {
            if (p.getTiempoRafaga() < minimo) {
                minimo = p.getTiempoRafaga();
                menor = p;
            }
        }

        return menor;
    }
}
