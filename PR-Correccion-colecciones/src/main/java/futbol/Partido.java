package futbol;

/**
 * 
 * Dos partidos son iguales si son del mismo equipo local, visitante y misma jornada
 */
public interface Partido {
    String equipoLocal();
    String equipoVisitante();
    int jornada();
}
