package futbol;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;


public class EstadisticaGolesPorJugadorTest {
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

    }

    @Test
    public void ningunPartido(){
        Estadistica e = new Estadistica();
        Map<String, Integer> equipoToGanados = e.numeroDeGolesMarcadosPorJugador();
        assertTrue( "Sin datos no debería haber goles de jugadores", equipoToGanados.size() == 0 );
    }

    @Test
    public void goles1(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido( partido2, Arrays.asList( new Gol[]{
                new GolI("madrid","pepe",0,partido2),
                new GolI("barça","juan",1,partido2),
        }));
        
        Map<String, Integer> jugadorToGoles = e.numeroDeGolesMarcadosPorJugador();
        assertTrue( "Debería haber 2 jugadores", jugadorToGoles.size() == 2 );
        for( String jugador: new String[]{ "pepe", "juan"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 1 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(1) );
        }
    }

    @Test
    public void goles2(){
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

        Map<String, Integer> jugadorToGoles = e.numeroDeGolesMarcadosPorJugador();
        assertTrue( "Debería haber 3 jugadores", jugadorToGoles.size() ==3 );
        for( String jugador: new String[]{ "juan", "manolo"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 1 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(1) );
        }
        for( String jugador: new String[]{ "pepe"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 2 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(2) );
        }
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

        Map<String, Integer> jugadorToGoles = e.numeroDeGolesMarcadosPorJugador();
        assertTrue( "Debería haber 3 jugadores", jugadorToGoles.size() ==3 );
        for( String jugador: new String[]{ "pepe", "juan", "manolo"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 2 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(2) );
        }
    }

    @Test
    public void losGolesPorJugador(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        try{
            e.numeroDeGolesMarcadosPorJugador().put("hola",4);
            fail( "La estadística de goles por jugador no tiene sentido que se pueda modificar fuera de la clase Estadistica");
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
        e.agregaPartido( partido4, Arrays.asList( new Gol[]{
                new GolI("betis","manolo",0,partido5),
                new GolI("getafe","jesús",1,partido5),
                new GolI("getafe","jesús",2,partido5),
        }));
        
        
        Map<String, Integer> jugadorToGoles = e.numeroDeGolesMarcadosPorJugador();
        assertTrue( "Debería haber 4 jugadores", jugadorToGoles.size() == 4 );
        for( String jugador: new String[]{ "juan"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 2 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(2) );
        }
        for( String jugador: new String[]{ "pepe", "manolo"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 3 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(3) );
        }
        for( String jugador: new String[]{ "jesús"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 4 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(4) );
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
        e.agregaPartido( partido4, Arrays.asList( new Gol[]{
                new GolI("betis","manolo",0,partido5),
                new GolI("getafe","jesús",1,partido5),
                new GolI("getafe","jesús",2,partido5),
        }));
        
        PartidoI partido6 = new PartidoI("betis", "malaga", 4);
        e.agregaPartido( partido6, Arrays.asList( new Gol[]{
                new GolI("malaga","jose",1,partido6),
                new GolI("malaga","jose",2,partido6),
        }));

        
        Map<String, Integer> jugadorToGoles = e.numeroDeGolesMarcadosPorJugador();
        assertTrue( "Debería haber 5 jugadores", jugadorToGoles.size() == 5 );
        for( String jugador: new String[]{ "juan", "jose"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 2 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(2) );
        }
        for( String jugador: new String[]{ "pepe", "manolo"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 3 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(3) );
        }
        for( String jugador: new String[]{ "jesús"} ){
            assertTrue( jugador + " debería estar en la estadística", jugadorToGoles.containsKey(jugador) );
            assertTrue( jugador + " ha marcado 4 gol, la estadística dice:" + jugadorToGoles.get(jugador), jugadorToGoles.get(jugador).equals(4) );
        }
    }


}
