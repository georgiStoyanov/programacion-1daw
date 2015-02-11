package futbol;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;


public class EstadisticaPichichiTest {
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
        List<String> pichichis = e.clasificacionPichichi();
        assertTrue( "Sin datos no debería haber pichichis:", pichichis.size() == 0 );
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
        
        List<String> pichichis = e.clasificacionPichichi();
        assertTrue( "Debería haber 2 jugadores en pichichis", pichichis.size() == 2 );
        List<String> esperada = Arrays.asList( new String[]{"juan","pepe" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + pichichis, esperada.equals(pichichis) );
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

        List<String> pichichis = e.clasificacionPichichi();
        assertTrue( "Debería haber 3 jugadores en pichichis", pichichis.size() == 3 );
        List<String> esperada = Arrays.asList( new String[]{"pepe","juan","manolo" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + pichichis, esperada.equals(pichichis) );

        
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

        
        List<String> pichichis = e.clasificacionPichichi();
        assertTrue( "Debería haber 3 jugadores en pichichis", pichichis.size() == 3 );
        List<String> esperada = Arrays.asList( new String[]{"juan","manolo","pepe" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + pichichis, esperada.equals(pichichis) );

        
    }

    @Test
    public void losGolesPorJugador(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        try{
            e.clasificacionPichichi().add("hola");
            fail( "La estadística de goles por jugador no tiene sentido que se pueda modificar fuera de la clase Estadistica");
        }
        catch( UnsupportedOperationException ex ){
        }
        catch( Exception ex ){
            fail( "¿no se usa Collection.unmodifiableList() para hacer un List inmutable?");
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

        List<String> pichichis = e.clasificacionPichichi();
        assertTrue( "Debería haber 4 jugadores en pichichis", pichichis.size() == 4 );
        List<String> esperada = Arrays.asList( new String[]{"jesús","manolo","pepe","juan" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + pichichis, esperada.equals(pichichis) );

        
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
                new GolI("malaga","jose",3,partido6),
                new GolI("malaga","jose",4,partido6),
                new GolI("malaga","jose",5,partido6),
        }));


        
        List<String> pichichis = e.clasificacionPichichi();
        assertTrue( "Debería haber 5 jugadores en pichichis", pichichis.size() == 5 );
        List<String> esperada = Arrays.asList( new String[]{"jose","jesús","manolo","pepe","juan" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + pichichis, esperada.equals(pichichis) );
    }


}
