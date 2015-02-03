package futbol;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import futbol.Estadistica;
import futbol.Gol;
import futbol.Partido;

public class EstadisticaClasificaionEquiposTest {

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
        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Sin datos no debería haber equipos en la clasificación", clasificacion.size() == 0 );
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
        
        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Debería haber cuatro equipos en la clasificación", clasificacion.size() == 4 );
        List<String> esperada = Arrays.asList( new String[]{"barça",  "betis", "madrid", "sevilla" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + clasificacion, esperada.equals(clasificacion) );
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

        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Debería haber cuatro equipos en la clasificación", clasificacion.size() == 4 );
        List<String> esperada = Arrays.asList( new String[]{"barça", "betis", "madrid", "sevilla" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + clasificacion, esperada.equals(clasificacion) );
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

        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Debería haber cuatro equipos en la clasificación", clasificacion.size() == 4 );
        List<String> esperada = Arrays.asList( new String[]{"madrid", "barça",  "betis", "sevilla" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + clasificacion, esperada.equals(clasificacion) );

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

        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Debería haber cuatro equipos en la clasificación", clasificacion.size() == 4 );
        List<String> esperada = Arrays.asList( new String[]{ "barça",  "betis", "madrid", "sevilla" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + clasificacion, esperada.equals(clasificacion) );
    }

    @Test
    public void laClasificacionEsInmutable(){
        Estadistica e = new Estadistica();
        e.agregaPartido( new PartidoI("betis", "sevilla", 0), Arrays.asList( new Gol[]{
                
        }));
        try{
            e.clasificacionEquipos().add("hola");
            fail( "la clasificación de equipos no tiene sentido que se pueda modificar fuera de la clase Estadistica");
        }
        catch( UnsupportedOperationException ex ){
        }
        catch( Exception ex ){
            fail( "¿no se usa Collection.unmodificableList() para hacer un List inmutable?");
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
        
        
        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Debería haber cuatro equipos en la clasificación", clasificacion.size() == 5 );
        List<String> esperada = Arrays.asList( new String[]{ "getafe",  "barça", "betis", "madrid", "sevilla" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + clasificacion, esperada.equals(clasificacion) );
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

        List<String> clasificacion = e.clasificacionEquipos();
        assertTrue( "Debería haber cuatro equipos en la clasificación", clasificacion.size() == 6 );
        List<String> esperada = Arrays.asList( new String[]{ "getafe",  "barça", "betis", "malaga", "madrid", "sevilla" } );
        assertTrue( "La clasificación esperada era " + esperada + "  pero se consigue:" + clasificacion, esperada.equals(clasificacion) );
    }
}
