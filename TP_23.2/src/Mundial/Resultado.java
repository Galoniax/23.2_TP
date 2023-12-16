package Mundial;

public class Resultado {
    private int golesLocal; //Atributo de los goles del equipo local
    private int golesVisitante; //Atributo de los goles del equipo visitante


    //Constructor
    public Resultado(int golesLocal, int golesVisitante) {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }


    //Getters & Setters
    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    //Booleans
    public boolean ganoLocal() {
        return golesLocal > golesVisitante;
    }

    public boolean ganoVisitante() {
        return golesLocal < golesVisitante;
    }

    public boolean empate() {
        return golesLocal == golesVisitante;
    }
}