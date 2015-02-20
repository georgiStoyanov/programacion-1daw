package futbol;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import futbol.Estadistica;
import futbol.Gol;
import futbol.Partido;

public class EstadisticaPartidosGanadosPorEquipoTest {

    class GolI implements Gol {

        private String _equipo;
        private String _jugador;
        private int _minuto;
        private Partido _partido;

        public GolI(String equipo, String jugador, int minuto, Partido partido) {
            _equipo = equipo;
            _jugador = jugador;
            _minuto = minuto;
            _partido = partido;
        }

        @Override
        public String equipoMarcador() {
            return _equipo;
        }

        @Override
        public String jugador() {
            return _jugador;
        }

        @Override
        public int minuto() {
            return _minuto;
        }

        @Override
        public Partido partido() {
            return _partido;
        }
        
        @Override
        public String toString() {
        	return "(Gol: equipo:" + equipoMarcador() + " jugador:" + jugador() + ")";
        }

    }

    class PartidoI implements Partido {

        private String _local;
        private String _visitante;
        private int _jornada;

        public PartidoI(String local, String visitante, int jornada) {
            _local = local;
            _visitante = visitante;
            _jornada = jornada;
        }

        @Override
        public String equipoLocal() {
            return _local;
        }

        @Override
        public String equipoVisitante() {
            return _visitante;
        }

        @Override
        public int jornada() {
            return _jornada;
        }
        
        @Override
        public String toString() {
        	return "(Partido: local:" + equipoLocal() + " visitante:" + equipoVisitante() + ")";
        }

    }

    @Test
    public void ningunPartido(){
        Estadistica e = new Estadistica();
        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Sin datos no debería haber equipos con partidos ganados, pero hay:" + equipoToGanados.size(), equipoToGanados.size() == 0 );
    }

    @Test
    public void partidosEmpatados(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
        }));
        
        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Debería haber cuatro equipos tras dos partidos, pero hay:" + equipoToGanados.size(), equipoToGanados.size() == 4 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça"} ){
            assertTrue( equipo + " debería estar en la estadística", equipoToGanados.containsKey(equipo) );
            assertTrue( "Todos los partidos estaban empatados, ningún equipo ganó ninguno:" + equipo, equipoToGanados.get(equipo).equals(0) );
        }
    }

    @Test
    public void partidosEmpatadosConEquipoRepetido(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 0);
        e.agregaPartido( partido3, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido3),
                new GolI("betis","manolo",1,partido3),
        }));

        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Debería haber cuatro equipos tras tres partidos, hay:" + equipoToGanados.size(), equipoToGanados.size() == 4 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça"} ){
            assertTrue( equipo + " debería estar en la estadística", equipoToGanados.containsKey(equipo) );
            assertTrue( "Todos los partidos estaban empatados, ningún equipo ganó ninguno:" + equipo, equipoToGanados.get(equipo).equals(0) );
        }
    }

    
    @Test
    public void partidosGanadosSimple(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
        }));

        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Debería haber cuatro equipos tras tres partidos, hay:" + equipoToGanados.size(), equipoToGanados.size() == 4 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça"} ){
            assertTrue( equipo + " debería estar en la estadística", equipoToGanados.containsKey(equipo) );
        }
        for( String equipo: new String[]{ "betis", "sevilla", "barça"} ){
            assertTrue( "El equipo no ganó ningún partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(0) );
        }
        assertTrue( "El equipo ganó un partido: madrid" + " pero la estadistica dice:" + equipoToGanados.get("madrid"), equipoToGanados.get("madrid").equals(1) );
    }

    @Test
    public void partidosGanadosConEquipoRepetido(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
                new GolI("barça","juan",2,partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 0);
        e.agregaPartido( partido3, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido3),
                new GolI("betis","manolo",1,partido3),
                new GolI("betis","manolo",2,partido3),
        }));

        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Debería haber cuatro equipos tras tres partidos, hay:" + equipoToGanados.size(), equipoToGanados.size() == 4 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça"} ){
            assertTrue( equipo + " debería estar en la estadística", equipoToGanados.containsKey(equipo) );
        }
        for( String equipo: new String[]{ "sevilla", "madrid" } ){
            assertTrue( "El equipo no ganó ningún partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(0) );
        }
        for( String equipo: new String[]{ "betis", "barça" } ){
            assertTrue( "El equipo ganó un partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(1) );
        }
    }

    @Test
    public void losPartidosGanadosSonInmutables(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        try{
            e.numeroDePartidosGanadosPorEquipo().put("hola",4);
            fail( "La estadística de partidos ganados por equipo no tiene sentido que se pueda modificar fuera de la clase Estadistica");
        }
        catch( UnsupportedOperationException ex ){
        }
        catch( Exception ex ){
            fail( "¿no se usa Collection.unmodifiableMap() para hacer un Map inmutable?");
        }
    }
    
    @Test
    public void muchosPartidosGanadosConEquipoRepetido(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
                new GolI("barça","juan",2,partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 1);
        e.agregaPartido( partido3, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido3),
                new GolI("betis","manolo",1,partido3),
                new GolI("betis","manolo",2,partido3),
        }));

        PartidoI partido4 = new PartidoI("madrid", "getafe", 2);
        e.agregaPartido( partido4, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido4),
                new GolI("getafe","jesús",1,partido4),
                new GolI("getafe","jesús",2,partido4),
        }));

        PartidoI partido5 = new PartidoI("betis", "getafe", 3);
        e.agregaPartido( partido5, Arrays.asList( new Gol[]{
                new GolI("betis","manolo",0,partido5),
                new GolI("getafe","jesús",1,partido5),
                new GolI("getafe","jesús",2,partido5),
        }));
        
        
        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Debería haber cinco equipos, hay:" + equipoToGanados.size(), equipoToGanados.size() == 5 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça", "getafe"} ){
            assertTrue( equipo + " debería estar en la estadística", equipoToGanados.containsKey(equipo) );
        }
        for( String equipo: new String[]{ "sevilla", "madrid" } ){
            assertTrue( "El equipo no ganó ningún partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(0) );
        }
        for( String equipo: new String[]{ "betis", "barça" } ){
            assertTrue( "El equipo ganó un partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(1) );
        }
        for( String equipo: new String[]{ "getafe" } ){
            assertTrue( "El equipo ganó dos partido:" + equipo+ " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(2) );
        }
    }

    @Test
    public void muchosMasPartidosGanadosConEquipoRepetido(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));

        e.agregaPartido( new PartidoI("malaga", "getafe", 0), Arrays.asList( new Gol[]{
                
        }));

        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
                new GolI("barça","juan",2,partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 1);
        e.agregaPartido( partido3, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido3),
                new GolI("betis","manolo",1,partido3),
                new GolI("betis","manolo",2,partido3),
        }));

        PartidoI partido4 = new PartidoI("madrid", "getafe", 2);
        e.agregaPartido( partido4, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido4),
                new GolI("getafe","jesús",1,partido4),
                new GolI("getafe","jesús",2,partido4),
        }));

        PartidoI partido5 = new PartidoI("betis", "getafe", 3);
        e.agregaPartido( partido5, Arrays.asList( new Gol[]{
                new GolI("betis","manolo",0,partido5),
                new GolI("getafe","jesús",1,partido5),
                new GolI("getafe","jesús",2,partido5),
        }));
        
        PartidoI partido6 = new PartidoI("betis", "malaga", 4);
        e.agregaPartido( partido6, Arrays.asList( new Gol[]{
                new GolI("malaga","jose",1,partido6),
                new GolI("malaga","jose",2,partido6),
        }));

        
        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();
        assertTrue( "Debería haber seis equipos, hay:" + equipoToGanados.size(), equipoToGanados.size() == 6 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça", "getafe", "malaga"} ){
            assertTrue( equipo + " debería estar en la estadística", equipoToGanados.containsKey(equipo) );
        }
        for( String equipo: new String[]{ "sevilla", "madrid" } ){
            assertTrue( "El equipo no ganó ningún partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(0) );
        }
        for( String equipo: new String[]{ "betis", "barça", "malaga" } ){
            assertTrue( "El equipo ganó un partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(1) );
        }
        for( String equipo: new String[]{ "getafe" } ){
            assertTrue( "El equipo ganó dos partido:" + equipo+ " pero la estadistica dice:" + equipoToGanados.get(equipo), equipoToGanados.get(equipo).equals(2) );
        }
    }


   @Test
    public void muchosMasPartidosGanadosConEquipoRepetidoYColeccionReutilizada(){
        Estadistica e = new Estadistica();
        Map<String, Integer> equipoToGanados = e.numeroDePartidosGanadosPorEquipo();        
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));

        e.agregaPartido( new PartidoI("malaga", "getafe", 0), Arrays.asList( new Gol[]{
                
        }));

        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
                new GolI("barça","juan",2,partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 1);
        e.agregaPartido( partido3, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido3),
                new GolI("betis","manolo",1,partido3),
                new GolI("betis","manolo",2,partido3),
        }));

        PartidoI partido4 = new PartidoI("madrid", "getafe", 2);
        e.agregaPartido( partido4, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido4),
                new GolI("getafe","jesús",1,partido4),
                new GolI("getafe","jesús",2,partido4),
        }));

        PartidoI partido5 = new PartidoI("betis", "getafe", 3);
        e.agregaPartido( partido5, Arrays.asList( new Gol[]{
                new GolI("betis","manolo",0,partido5),
                new GolI("getafe","jesús",1,partido5),
                new GolI("getafe","jesús",2,partido5),
        }));
        
        PartidoI partido6 = new PartidoI("betis", "malaga", 4);
        e.agregaPartido( partido6, Arrays.asList( new Gol[]{
                new GolI("malaga","jose",1,partido6),
                new GolI("malaga","jose",2,partido6),
        }));

        
        
        assertTrue( "Debería haber seis equipos, hay:" + equipoToGanados.size(), equipoToGanados.size() == 6 );
        for( String equipo: new String[]{ "betis", "sevilla", "madrid", "barça", "getafe", "malaga"} ){
            assertTrue( equipo + " debería estar en la estadística. Sigue valiendo la clasificacion tras introducir mas partidos?", equipoToGanados.containsKey(equipo) );
        }
        for( String equipo: new String[]{ "sevilla", "madrid" } ){
            assertTrue( "El equipo no ganó ningún partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo) + ". Sigue valiendo la clasificacion tras introducir mas partidos?", equipoToGanados.get(equipo).equals(0) );
        }
        for( String equipo: new String[]{ "betis", "barça", "malaga" } ){
            assertTrue( "El equipo ganó un partido:" + equipo + " pero la estadistica dice:" + equipoToGanados.get(equipo) + ". Sigue valiendo la clasificacion tras introducir mas partidos?", equipoToGanados.get(equipo).equals(1) );
        }
        for( String equipo: new String[]{ "getafe" } ){
            assertTrue( "El equipo ganó dos partido:" + equipo+ " pero la estadistica dice:" + equipoToGanados.get(equipo) +". Sigue valiendo la clasificacion tras introducir mas partidos?", equipoToGanados.get(equipo).equals(2) );
        }
    }

}
