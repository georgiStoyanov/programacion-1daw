package futbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class Estadistica {
	
	abstract class MapaConValorInicial<K,V> extends HashMap<K,V> {
		@Override
		public V get(Object key) {
			V ret = super.get(key);
			if( ret == null ){
				ret = creaValorInicial();
				put((K)key,ret);
			}
			return ret;
		}

		abstract protected V creaValorInicial();
	}

	class MapaDeStringAInt extends MapaConValorInicial<String,Integer>{

		@Override
		protected Integer creaValorInicial() {
			return 0;
		}
	}
	
	class MapaDeStringASetDeStrings extends  MapaConValorInicial<String,Set<String>>{
		@Override
		protected Set<String> creaValorInicial() {
			return new HashSet<String>();
		}
	}
    
    private Map<String,Integer> _numeroDePartidosGanadosPorEquipo = new MapaDeStringAInt();
    private Map<String, Integer> _numeroDeGolesMarcadosPorJugador = new MapaDeStringAInt();
    private Map<String,Set<String>> _goleadoresPorEquipo = new MapaDeStringASetDeStrings();
    private List<String> _clasificacionEquipos = new ArrayList<String>();
    private List<String> _clasificacionPichichi = new ArrayList<String>();;

    /**
     * Añade más datos a la estadística
     * @param partido
     * @param goles
     */
    public void agregaPartido( Partido partido, List<Gol> goles ){
        actualizaNumeroDePartidosGanadosPorEquipo(partido,goles);
        actualizaNumeroDeGolesMarcadosPorJugador(partido,goles);
        actualizaGoleadoresPorEquipo(partido,goles);
        actualizaClasificacionEquipos();
        actualizaClasificacionPichichi();
    }
    
    private <C extends Comparable<C>> Comparator<C> creaComparadorDeStringBasadoEnMap( final Map<C,Integer> map ){
    	return new Comparator<C>(){

            @Override
            public int compare(C eq1, C eq2) {
                int ret = map.get(eq2).intValue() - map.get(eq1).intValue();
                if( ret == 0 ){
                    ret = eq1.compareTo(eq2);
                }
                return ret;
            }
            
        };
    }
    
    
    private void actualizaClasificacionEquipos() {
        Comparator<String> comparadorEquipos = creaComparadorDeStringBasadoEnMap(_numeroDePartidosGanadosPorEquipo);
        List<String> ret = new ArrayList<String>(_numeroDePartidosGanadosPorEquipo.keySet());
        Collections.sort(ret,comparadorEquipos);
        _clasificacionEquipos.clear();
        _clasificacionEquipos.addAll( ret );
    }

    private void actualizaClasificacionPichichi() {
        Comparator<String> comparadorPichichi = creaComparadorDeStringBasadoEnMap(_numeroDeGolesMarcadosPorJugador);
        List<String> ret = new ArrayList<String>(_numeroDeGolesMarcadosPorJugador.keySet());
        Collections.sort(ret,comparadorPichichi);
        _clasificacionPichichi.clear();
        _clasificacionPichichi.addAll( ret );
    }

    private void actualizaGoleadoresPorEquipo(Partido partido, List<Gol> goles) {
    	_goleadoresPorEquipo.get(partido.equipoLocal());
    	_goleadoresPorEquipo.get(partido.equipoVisitante());
        for( Gol g: goles) {
            String jugador = g.jugador();
            String equipo = g.equipoMarcador();
            _goleadoresPorEquipo.get(equipo).add(jugador);
        }
    }

    private void actualizaNumeroDeGolesMarcadosPorJugador(Partido partido, List<Gol> goles) {
        
        for( Gol g: goles ){
            String jugador = g.jugador();
            int golesDeJugador = 0;
            if( _numeroDeGolesMarcadosPorJugador.containsKey(jugador) ){
                golesDeJugador = _numeroDeGolesMarcadosPorJugador.get(jugador);
            }
            golesDeJugador += 1;
            _numeroDeGolesMarcadosPorJugador.put(jugador,golesDeJugador);
        }
        
    }

    private void actualizaNumeroDePartidosGanadosPorEquipo(Partido partido, List<Gol> goles) {
        String local = partido.equipoLocal();
        String visitante = partido.equipoVisitante();
        String ganador = equipoGanador(partido, goles);
        
        int partidosGanadosLocal = _numeroDePartidosGanadosPorEquipo.get(local);
        int partidosGanadosVisitante = _numeroDePartidosGanadosPorEquipo.get(visitante);
         
        if(local.equals(ganador) ){
            partidosGanadosLocal += 1;
        }
        if(visitante.equals(ganador) ){
            partidosGanadosVisitante += 1;
        }
        
        _numeroDePartidosGanadosPorEquipo.put( local, partidosGanadosLocal );
        _numeroDePartidosGanadosPorEquipo.put( visitante, partidosGanadosVisitante );
    }

    /**
     * 
     * @param partido
     * @param goles
     * @return El nombre del equipo ganador, o la cadena vacía si se produjo empate
     */
    public String equipoGanador( Partido partido, List<Gol> goles ){
        
        if( goles.size() == 0 ){
            return "";
        }
        
        Map<String,Integer> equipoToGoles = new HashMap<String,Integer>();
        
        for( Gol g: goles ){
            String equipo = g.equipoMarcador();
            int golesAcumulados = 0;
            if( equipoToGoles.containsKey(equipo) ){
                golesAcumulados = equipoToGoles.get(equipo);
            }
            equipoToGoles.put(equipo, golesAcumulados+1);
        }
        
        int maxGoles = Collections.max( equipoToGoles.values() );
        int equiposConMaxGoles = Collections.frequency(equipoToGoles.values(), maxGoles);
        if( equiposConMaxGoles > 1 ){
            return "";
        }
        
        for( Entry<String, Integer> a: equipoToGoles.entrySet() ){
            if( a.getValue().equals(maxGoles) ){
                return a.getKey();
            }
        }
        throw new IllegalStateException();
    }
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de equipo y como valor el número de partidos que ha ganado
     */
    public Map<String,Integer> numeroDePartidosGanadosPorEquipo(){
        return Collections.unmodifiableMap( _numeroDePartidosGanadosPorEquipo  );
    }
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de jugador y como valor el número de goles que ha marcado
     */
    public Map<String,Integer> numeroDeGolesMarcadosPorJugador(){
        return Collections.unmodifiableMap(_numeroDeGolesMarcadosPorJugador);
    }
    
    
    /**
     * 
     * @return Un mapa que tiene como clave un nombre de equipo y como valor una conjunto de sus jugadores que hayan marcado un gol.
     *          Si no ha marcado ningún gol, será un conjunto vacía.
     */
    public Map<String,Set<String>> goleadoresPorEquipo(){
        return Collections.unmodifiableMap( _goleadoresPorEquipo  );
    }
    
    /**
     * Lista ordenada con la clasificación de los equipos.
     * Entre dos equipos, va primero el que:
     * - Haya ganado más partidos
     * - Orden alfabético del nombre del equipo
     */
    public List<String> clasificacionEquipos(){
        return Collections.unmodifiableList( _clasificacionEquipos  );
    }

    /**
     * Lista ordenada con la clasificación del pichichi.
     * Entre dos jugadores, va primero el que:
     * - Haya metido más goles
     * - Orden alfabético del nombre del jugador
     */
    public List<String> clasificacionPichichi(){
        return Collections.unmodifiableList( _clasificacionPichichi   );
    }
    
    /**
     * 
     * @return Un mapa con clave el minuto de partido (0 a ???), 
     *   		y con valores la lista de goles metidos en ese minutos 
     */
    public Map<Integer,List<Gol>> golesPorMinutoDePartido(){
    	throw new RuntimeException();
    }
}
