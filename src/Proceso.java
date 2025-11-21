public class Proceso implements Comparable<Proceso>{
    private int tiempoRafaga;
    private String nombre;
    private int indice;
    private static int contador;

    public Proceso(String nombre, int tiempoRafaga){
        this.nombre = nombre;
        this.tiempoRafaga = tiempoRafaga;
        indice = ++contador;
    }

    public String getNombre(){
        return nombre;
    }

    public int getTiempoRafaga(){
        return tiempoRafaga;
    }

    public int getIndice(){
        return indice;
    }

    @Override
    public int compareTo(Proceso p2){
        int menorRafaga = Integer.compare(this.tiempoRafaga, p2.tiempoRafaga);

        if (menorRafaga == 0){
            return Integer.compare(this.indice, p2.indice);
        }

        return menorRafaga;
    }

    public String toString(){
        return String.format("| %-7s | %-7d | %-7d |",getNombre(), getTiempoRafaga(), getIndice());
    }

    //No lo toquen, funciona, pero no entiendo por qué lo hace 💀💀
    public String mostrarOperacion(){
        return String.format("| %-8s |  %-6d| %-6d | %-6d |\n", getNombre(), getTiempoRafaga(), Main.momento, (Main.momento + getTiempoRafaga()));
    }

}
