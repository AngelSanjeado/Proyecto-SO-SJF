public class Proceso{
    private int tiempoRafaga;
    private String nombre;
    private int tiempoLlegada;

    public Proceso(String nombre, int tiempoLlegada, int tiempoRafaga){
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoRafaga = tiempoRafaga;
    }

    public String getNombre(){
        return nombre;
    }

    public int getTiempoRafaga(){
        return tiempoRafaga;
    }

    public int getTiempoLlegada(){
        return tiempoLlegada;
    }

    public int tiempoRespuesta(){
        return Main.momentoFinal - getTiempoLlegada();
    }

    public int tiempoEspera(){
        return tiempoRespuesta() - getTiempoRafaga();
    }

    public String toString(){
        return String.format("| %-7s | %-7d | %-7d |\n",getNombre(), getTiempoRafaga(), getTiempoLlegada());
    }

    //No lo toquen, funciona, pero no entiendo por qué lo hace 💀💀
    public String mostrarOperacion(){
        return String.format("| %-7s | %-7s | %-7s | %-6s | %-6s | %-9s | %-6s |\n", getNombre(), getTiempoLlegada(), getTiempoRafaga(), Main.momentoInicio, Main.momentoFinal, tiempoRespuesta(), tiempoEspera());
    }

}
