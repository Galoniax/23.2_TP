package Mundial;

import java.util.ArrayList;

public class Llave extends EtapaMundial {
    private String NombreLlave; //Nombre de la Llave en cuestión (Cuartos 1, 2, Semis 1, etc)
    private ArrayList<Equipo> equiposEnfrentados; //Declara los equipos que se enfrentar en una llave


    //Constructor
    public Llave(String NombreLlave) {
        super();
        this.setNombreLlave(NombreLlave);
        this.equiposEnfrentados = new ArrayList<>();
    }


    //Getters & Setters
    public String getNombreLlave() {
        return NombreLlave;
    }

    public void setNombreLlave(String nombreLlave) {
        NombreLlave = nombreLlave;
    }

    public ArrayList<Equipo> getEquiposEnfrentados() {
        return equiposEnfrentados;
    }

    public void setEquiposEnfrentados(ArrayList<Equipo> equiposEnfrentados) {
        this.equiposEnfrentados = equiposEnfrentados;
    }

    //Methods
    public void addEquipo(Equipo equipo) {
        getEquiposEnfrentados().add(equipo);
    }

    public void removeEquipo(Equipo equipo) {
        getEquiposEnfrentados().add(equipo);
    }


    public static void simularPartidos(Equipo equipoLocal, Equipo equipoVisitante, EtapaMundial etapa) {
        ArrayList<Partido> partidosPorJugarLlave = etapa.getPartidos();

        for (Partido partido : partidosPorJugarLlave) {
            int golesLocal = (int) (Math.random() * 5);
            int golesVisitante = (int) (Math.random() * 5);

            Resultado resultado = new Resultado(golesLocal, golesVisitante);
            partido.setResultado(resultado);

            System.out.println("Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());

            SubirPuntajes(partido);

            Equipo ganador = null;
            if (resultado.empate()) {

                int golesLocalVuelta = (int) (Math.random() * 5 + 1);
                int golesVisitanteVuelta = (int) (Math.random() * 5 + 1);

                if (golesLocalVuelta > golesVisitanteVuelta) {
                    ganador = equipoLocal;
                } else if (golesVisitanteVuelta > golesLocalVuelta) {
                    ganador = equipoVisitante;
                }
            }
            else if (resultado.ganoLocal()) {
                ganador = equipoLocal;
            } else if (resultado.ganoVisitante()) {
                ganador = equipoVisitante;
            }
            else {
                System.out.println(" Resultado: Empate");
            }

            if (ganador != null) {
                System.out.println(" Ganador: " + ganador.getNombre());
                ganador.agregarPartido(partido);
            }
        }
    }

    public static void SubirPuntajes (Partido partido) {
        Resultado resultado = partido.getResultado();
        Equipo equipoLocal = partido.getLocal();
        Equipo equipoVisitante = partido.getVisitante();

        if (resultado.ganoLocal()) {
            equipoLocal.addPuntaje(3);
        } else if (resultado.ganoVisitante()) {
            equipoVisitante.addPuntaje(3);
        } else {
            equipoLocal.addPuntaje(1);
            equipoVisitante.addPuntaje(1);
        }
    }
}
