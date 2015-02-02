package futbol;

import java.util.List;
import java.util.Map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Estadistica {

    
    /**
     * Añade más datos a la estadística
     * @param partido
     * @param goles
     */
    public void agregaPartido( Partido partido, List<Gol> goles ){
        throw new NotImplementedException();
    }
    
    /**
     * 
     * @param partido
     * @param goles
     * @return El nombre del equipo ganador, o la cadena vacía si se produjo empate
     */
    public String equipoGanador( Partido partido, List<Gol> goles ){
        throw new NotImplementedException();
    }
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de equipo y como valor el número de partidos que ha ganado
     */
    public Map<String,Integer> numeroDePartidosGanadosPorEquipo(){
        throw new NotImplementedException();
    }
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de jugador y como valor el número de goles que ha marcado
     */
    public Map<String,Integer> numeroDeGolesMarcadosPorJugador(){
        throw new NotImplementedException();
    }
    
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de equipo y como valor una lista de sus jugadores que hayan marcado un gol.
     *          Si no ha marcado ningún gol, será una lista vacía.
     */
    public Map<String,List<String>> goleadoresPorEquipo(){
        throw new NotImplementedException();
    }
    
    /**
     * Lista ordenada con la clasificación de los equipos.
     * Entre dos equipos, va primero el que:
     * - Haya ganado más partidos
     * - Orden alfabético del nombre del equipo
     */
    public List<String> clasificacionEquipos(){
        throw new NotImplementedException();
    }

    /**
     * Lista ordenada con la clasificación del pichichi.
     * Entre dos jugadores, va primero el que:
     * - Haya metido más goles
     * - Orden alfabético del nombre del jugador
     */
    public List<String> clasificacionPichichi(){
        throw new NotImplementedException();
    }
    
    /**
     * 
     * @return Un mapa con clave el minuto de partido (0 a ???), 
     *   		y con valores la lista de goles metidos en ese minutos 
     */
    public Map<Integer,List<Gol>> golesPorMinutoDePartido(){
    	throw new NotImplementedException();
    }

}
