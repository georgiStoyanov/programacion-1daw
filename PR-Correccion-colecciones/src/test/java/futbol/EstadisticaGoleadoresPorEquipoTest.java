package futbol;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class EstadisticaGoleadoresPorEquipoTest {
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
    public void ningunPartido() {
        Estadistica e = new Estadistica();
        Map<String, Set<String>> equipoToGoleadores = e.goleadoresPorEquipo();
        assertTrue("Sin datos no debería haber goles de jugadores", equipoToGoleadores.size() == 0);
    }

    @Test
    public void goles1() {
        Estadistica e = new Estadistica();
        e.agregaPartido(new PartidoI("betis", "sevilla", 0), Arrays.asList(new Gol[] {

                }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido(partido2, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido2),
                new GolI("barça", "juan", 1, partido2),
        }));

        Map<String, Set<String>> equipoToGoleadores = e.goleadoresPorEquipo();
        assertTrue("Debería haber 4 equipos", equipoToGoleadores.size() == 4);

        assertTrue(
                "madrid debería tener como goleadores a: pepe",
                e.goleadoresPorEquipo().get("madrid")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "pepe" }))));
        assertTrue("barça debería tener como goleadores a: juan",
                e.goleadoresPorEquipo().get("barça")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "juan" }))));
        assertTrue(
                "betis debería no tener goleadores",
                e.goleadoresPorEquipo().get("betis")
                        .equals(new HashSet<String>(Arrays.asList(new String[] {}))));
        assertTrue(
                "sevilla debería no tener goleadores",
                e.goleadoresPorEquipo().get("sevilla")
                        .equals(new HashSet<String>(Arrays.asList(new String[] {}))));
    }

    @Test
    public void goles2() {
        Estadistica e = new Estadistica();
        e.agregaPartido(new PartidoI("betis", "sevilla", 0), Arrays.asList(new Gol[] {

                }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido(partido2, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido2),
                new GolI("barça", "juan", 1, partido2),
                new GolI("barça", "juanito", 1, partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 0);
        e.agregaPartido(partido3, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido3),
                new GolI("betis", "manolo", 1, partido3),
        }));

        Map<String, Set<String>> equipoToGoleadores = e.goleadoresPorEquipo();
        assertTrue("Debería haber 4 equipos", equipoToGoleadores.size() == 4);

        assertTrue(
                "madrid debería tener como goleadores a: pepe",
                e.goleadoresPorEquipo().get("madrid")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "pepe" }))));
        assertTrue("barça debería tener como goleadores a: juan, juanito",
                e.goleadoresPorEquipo().get("barça")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "juan", "juanito" }))));
        assertTrue("betis debería tener como goleadores a: manolo",
                e.goleadoresPorEquipo().get("betis")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "manolo" }))));
        assertTrue(
                "sevilla debería no tener goleadores",
                e.goleadoresPorEquipo().get("sevilla")
                        .equals(new HashSet<String>(Arrays.asList(new String[] {}))));
    }

    @Test
    public void partidosGanadosConEquipoRepetido() {
        Estadistica e = new Estadistica();
        e.agregaPartido(new PartidoI("betis", "sevilla", 0), Arrays.asList(new Gol[] {

                }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido(partido2, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido2),
                new GolI("barça", "juan", 1, partido2),
                new GolI("barça", "juan", 2, partido2),
                new GolI("barça", "juanito", 2, partido2),
                new GolI("barça", "juanito", 2, partido2),
                new GolI("barça", "juanito", 2, partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 0);
        e.agregaPartido(partido3, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido3),
                new GolI("betis", "manolo", 1, partido3),
                new GolI("betis", "manolo", 2, partido3),
        }));

        Map<String, Set<String>> equipoToGoleadores = e.goleadoresPorEquipo();
        assertTrue("Debería haber 4 equipos", equipoToGoleadores.size() == 4);

        assertTrue(
                "madrid debería tener como goleadores a: pepe",
                e.goleadoresPorEquipo().get("madrid")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "pepe" }))));
        assertTrue("barça debería tener como goleadores a: juan, juanito",
                e.goleadoresPorEquipo().get("barça")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "juan", "juanito" }))));
        assertTrue("betis debería tener como goleadores a: manolo",
                e.goleadoresPorEquipo().get("betis")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "manolo" }))));
        assertTrue(
                "sevilla debería no tener goleadores",
                e.goleadoresPorEquipo().get("sevilla")
                        .equals(new HashSet<String>(Arrays.asList(new String[] {}))));
    }

    @Test
    public void losGoleadoresPorEquipo() {
        Estadistica e = new Estadistica();
        e.agregaPartido(new PartidoI("betis", "sevilla", 0), Arrays.asList(new Gol[] {

                }));
        try {
            e.goleadoresPorEquipo().put("hola", new HashSet<String>());
            fail("La estadística de goles por jugador no tiene sentido que se pueda modificar fuera de la clase Estadistica");
        }
        catch (UnsupportedOperationException ex) {
        }
        catch (Exception ex) {
            fail("¿no se usa Collection.unmodifiableMap() para hacer un Map inmutable?");
        }
    }

    @Test
    public void muchosPartidosGanadosConEquipoRepetido() {
        Estadistica e = new Estadistica();
        e.agregaPartido(new PartidoI("betis", "sevilla", 0), Arrays.asList(new Gol[] {

                }));
        PartidoI partido2 = new PartidoI("madrid", "barça", 0);
        e.agregaPartido(partido2, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido2),
                new GolI("barça", "juan", 1, partido2),
                new GolI("barça", "juan", 2, partido2),
                new GolI("barça", "juanito", 2, partido2),
                new GolI("barça", "juanete", 2, partido2),
        }));

        PartidoI partido3 = new PartidoI("madrid", "betis", 1);
        e.agregaPartido(partido3, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido3),
                new GolI("betis", "manolo", 1, partido3),
                new GolI("betis", "manolo", 2, partido3),
        }));

        PartidoI partido4 = new PartidoI("madrid", "getafe", 2);
        e.agregaPartido(partido4, Arrays.asList(new Gol[] {
                new GolI("madrid", "pepe", 0, partido4),
                new GolI("getafe", "jesús", 1, partido4),
                new GolI("getafe", "jesús", 2, partido4),
                new GolI("getafe", "jesusón", 2, partido4),
        }));

        PartidoI partido5 = new PartidoI("betis", "getafe", 3);
        e.agregaPartido(partido4, Arrays.asList(new Gol[] {
                new GolI("betis", "manolo", 0, partido5),
                new GolI("getafe", "jesús", 1, partido5),
                new GolI("getafe", "jesusito", 2, partido5),
        }));

        Map<String, Set<String>> equipoToGoleadores = e.goleadoresPorEquipo();
        assertTrue("Debería haber 5 equipos", equipoToGoleadores.size() == 5);

        assertTrue(
                "madrid debería tener como goleadores a: pepe",
                e.goleadoresPorEquipo().get("madrid")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "pepe" }))));
        assertTrue("barça debería tener como goleadores a: juan, juanito,juanete",
                e.goleadoresPorEquipo().get("barça")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "juan", "juanito", "juanete" }))));
        assertTrue("betis debería tener como goleadores a: manolo",
                e.goleadoresPorEquipo().get("betis")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "manolo" }))));
        assertTrue("getafe debería tener como goleadores a: jesús, jesusón, jesusito",
                e.goleadoresPorEquipo().get("getafe")
                        .equals(new HashSet<String>(Arrays.asList(new String[] { "jesús", "jesusón", "jesusito" }))));
        assertTrue(
                "sevilla debería no tener goleadores",
                e.goleadoresPorEquipo().get("sevilla")
                        .equals(new HashSet<String>(Arrays.asList(new String[] {}))));
    }


}
