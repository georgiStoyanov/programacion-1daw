package futbol;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import futbol.Estadistica;
import futbol.Gol;
import futbol.Partido;

public class EstadisticaGanaPartidoTest {

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
    public void partidoEmpatadoSinGoles() {
        Estadistica e = new Estadistica();
        Partido partido = new PartidoI("l", "v", 0);
        List<Gol> goles = Arrays.asList(new Gol[0]);
        String ganador = e.equipoGanador(partido, goles);
        assertTrue("Sin goles no deberia haber ganador", "".equals(ganador));

    }

    @Test
    public void partidoEmpatadoConGoles() {
        Estadistica e = new Estadistica();
        Partido partido = new PartidoI("l", "v", 0);
        List<Gol> goles = Arrays.asList(new Gol[] {
                new GolI("l", "pepe l", 0, partido),
                new GolI("l", "pepe l", 1, partido),
                new GolI("v", "juan v", 2, partido),
                new GolI("v", "juan v", 3, partido),
        });
        String ganador = e.equipoGanador(partido, goles);
        assertTrue("Debería ser empate 2-2", "".equals(ganador));
    }

    
    @Test
    public void partidoGanaVisitante() {
        Estadistica e = new Estadistica();
        Partido partido = new PartidoI("l", "v", 0);
        List<Gol> goles = Arrays.asList(new Gol[] {
                new GolI("l", "pepe l", 0, partido),
                new GolI("l", "pepe l", 1, partido),
                new GolI("v", "juan v", 2, partido),
                new GolI("v", "juan v", 3, partido),
                new GolI("v", "juan v", 4, partido),
        });
        String ganador = e.equipoGanador(partido, goles);
        assertTrue("Debería ganar el visitante", "v".equals(ganador));
    }

    @Test
    public void partidoGanaVisitanteACero() {
        Estadistica e = new Estadistica();
        Partido partido = new PartidoI("l", "v", 0);
        List<Gol> goles = Arrays.asList(new Gol[] {
                new GolI("v", "juan v", 2, partido),
                new GolI("v", "juan v", 3, partido),
                new GolI("v", "juan v", 4, partido),
        });
        String ganador = e.equipoGanador(partido, goles);
        assertTrue("Debería ganar el visitante", "v".equals(ganador));
    }
    
    
    @Test
    public void partidoGanaLocal() {
        Estadistica e = new Estadistica();
        Partido partido = new PartidoI("l", "v", 0);
        List<Gol> goles = Arrays.asList(new Gol[] {
                new GolI("l", "pepe l", 0, partido),
                new GolI("l", "pepe l", 1, partido),
                new GolI("v", "juan v", 4, partido),
        });
        String ganador = e.equipoGanador(partido, goles);
        assertTrue("Debería ganar el local", "l".equals(ganador));
    }

    @Test
    public void partidoGanaLocalACero() {
        Estadistica e = new Estadistica();
        Partido partido = new PartidoI("l", "v", 0);
        List<Gol> goles = Arrays.asList(new Gol[] {
                new GolI("l", "pepe l", 0, partido),
                new GolI("l", "pepe l", 1, partido),
        });
        String ganador = e.equipoGanador(partido, goles);
        assertTrue("Debería ganar el local", "l".equals(ganador));
    }

}
