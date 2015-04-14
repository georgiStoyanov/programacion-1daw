package examen;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RelojTest {

    @Rule
    public Timeout globalTimeout = new Timeout(10000);

    @Test
    public void relojPorDefectoCreadoEnMedianoche() {
        Reloj r = new Reloj();

        assertTrue("El reloj por defecto se crea en medianoche",
                r.getHoras() == 0);
        assertTrue("El reloj por defecto se crea en medianoche",
                r.getMinutos() == 0);
        assertTrue("El reloj por defecto se crea en medianoche",
                r.getSegundos() == 0);
    }

    @Test
    public void relojCreadoEnHora() {
        for (int i = 0; i < 23; i++) {
            Reloj r = new Reloj(i, 0, 0);

            assertTrue("El reloj creado con hora " + i + " no tiene esa hora",
                    r.getHoras() == i);
        }
    }

    @Test
    public void relojCreadoEnMinuto() {
        for (int i = 0; i < 60; i++) {
            Reloj r = new Reloj(0, i, 0);

            assertTrue("El reloj creado con minuto " + i
                    + " no tiene ese minuto", r.getMinutos() == i);
        }
    }

    @Test
    public void relojCreadoEnSegundo() {
        for (int i = 0; i < 60; i++) {
            Reloj r = new Reloj(0, 0, i);

            assertTrue("El reloj creado con segundo " + i
                    + " no tiene ese segundo", r.getSegundos() == i);
        }
    }

    @Test
    public void creadoEnHoraMenorDeCero() {
        boolean exception = false;
        try {
            new Reloj(-1, 0, 0);
        } 
        catch (Exception e) {
            exception = true;
        }
        assertTrue("No deberia crearse un reloj con hora negativa", exception);
    }

    @Test
    public void creadoEnHoraMayorDe23() {
        boolean exception = false;
        try {
            new Reloj(24, 0, 0);
        }
        catch (Exception e) {
            exception = true;
        }
        assertTrue("No deberia crearse un reloj con hora mayor de 23",
                exception);
    }

    @Test
    public void creadoEnMinutoMenorDeCero() {
        boolean exception = false;
        try {
            new Reloj(0, -1, 0);
        }
        catch (Exception e) {
            exception = true;
        }
        assertTrue("No deberia crearse un reloj con minuto negativo", exception);
    }

    @Test
    public void creadoEnMinutoMayorDe59() {
        boolean exception = false;
        try {
            new Reloj(0, 60, 0);
        }
        catch (Exception e) {
            exception = true;
        }
        assertTrue("No deberia crearse un reloj con minuto mayor de 59",
                exception);
    }

    @Test
    public void creadoEnSegundoMenorDeCero() {
        boolean exception = false;
        try {
            new Reloj(0, 0, -1);
        }
        catch (Exception e) {
            exception = true;
        }
        assertTrue("No deberia crearse un reloj con segundo negativo",
                exception);
    }

    @Test
    public void creadoEnSegundoMayorDe59() {
        boolean exception = false;
        try {
            new Reloj(0, 0, 60);
        }
        catch (Exception e) {
            exception = true;
        }
        assertTrue("No deberia crearse un reloj con segundo mayor de 59",
                exception);
    }

    private static String cadena(int hora, int minuto, int segundo) {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    @Test
    public void segundosRotanConUnTick() {
        Reloj r = new Reloj(0, 0, 59);
        r.tick();
        assertTrue("Los segundos deben rotar de 59 a 0 con tick",
                r.getSegundos() == 0);
        assertTrue(
                "Los minutos deben avanzar al rotar los segundos de 59 a 0 con tick",
                r.getMinutos() == 1);
    }

    @Test
    public void minutosRotanConUnTick() {
        Reloj r = new Reloj(0, 59, 59);
        r.tick();
        assertTrue("Los minutos deben rotar de 59 a 0 con tick ",
                r.getMinutos() == 0);
        assertTrue(
                "Las horas deben avanzar al rotar los minutos de 59 a 0 con tick",
                r.getHoras() == 1);
    }

    @Test
    public void horasRotanConUnTick() {
        Reloj r = new Reloj(23, 59, 59);
        r.tick();
        assertTrue("Las horas deben rotar de 23 a 0 con tick",
                r.getHoras() == 0);
    }

    @Test
    public void representacionComoCadenaEnCreacion() {
        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    Reloj r = new Reloj(h, m, s);
                    assertTrue(
                            "Representacion de cadena incorrecta al crear un reloj con h:"
                                    + h + " m:" + m + " s:" + s,
                            cadena(h, m, s).equals(r.toString()));
                }
            }
        }
    }

    
    @Test
    public void representacionComoCadenaConTickCompuesto() {
        for (int h = 0; h < 24; h += 5) {
            for (int m = 0; m < 60; m += 5) {
                for (int s = 0; s < 60; s += 5) {
                    Reloj r = new Reloj();
                    r.tick(h, m, s);
                    assertTrue(
                            "Representacion de cadena incorrecta al avanzar  un reloj con tick h:"
                                    + h + " m:" + m + " s:" + s + " --- " + r.toString(),
                            cadena(h, m, s).equals(r.toString()));
                }
            }
        }
    }

    @Test
    public void tickCompuesto2(){
        tickCompuesto();
    }
    
    @Test
    public void tickCompuesto() {
        for (int h = 0; h < 24; h += 5) {
            for (int m = 0; m < 60; m += 5) {
                for (int s = 0; s < 60; s += 5) {
                    Reloj r = new Reloj();
                    r.tick(h, m, s);
                    assertTrue( "los segundos deberían ser " + s + " tras tick("+ h + "," + m + "," + s + "):" + r.getSegundos() + " -- " + r.toString(), r.getSegundos() == s );
                    assertTrue( "los minutos deberían ser " + m + " tras tick("+ h + "," + m + "," + s + "):" + r.getMinutos() + " -- " + r.toString(), r.getMinutos() == m );
                    assertTrue( "los horas deberían ser " + h + " tras tick("+ h + "," + m + "," + s + "):" + r.getHoras() + " -- " + r.toString(), r.getHoras() == h );
                }
            }
        }
    }
    
    @Test
    public void representacionComoCadenaConTickSimple() {
        for (int h = 0; h < 24; h += 4) {
            for (int m = 0; m < 60; m += 4) {
                for (int s = 0; s < 60; s += 4) {
                    Reloj r = new Reloj();
                    for (int t = 0; t < h * 60 * 60 + m * 60 + s; t++) {
                        r.tick();
                    }
                    assertTrue(
                            "Representacion de cadena incorrecta al avanzar un reloj varias veces con tick h:"
                                    + h + " m:" + m + " s:" + s,
                            cadena(h, m, s).equals(r.toString()));
                }
            }
        }
    }
    
    
    @Test
    public void tickSimple2(){
        tickSimple();
    }

    @Test
    public void tickSimple3(){
        tickSimple();
    }

    @Test
    public void tickSimple() {
        for (int h = 0; h < 24; h += 5) {
            for (int m = 0; m < 60; m += 5) {
                for (int s = 0; s < 60; s += 5) {
                    Reloj r = new Reloj();
                    int ticks = h * 60 * 60 + m * 60 + s;
                    for( int t = 0 ; t < ticks ; t += 1 ){
                        r.tick();
                    }
                    assertTrue( "los segundos deberían ser " + s + " tras " + ticks + " ticks: " + r.getSegundos() + " -- " + r.toString(), r.getSegundos() == s );
                    assertTrue( "los minutos deberían ser " + m + " tras " + ticks + " ticks: " + r.getMinutos() + " -- " + r.toString(), r.getMinutos() == m );
                    assertTrue( "los horas deberían ser " + h + " tras " + ticks + " ticks: " + r.getHoras() + " -- " + r.toString(), r.getHoras() == h );
                }
            }
        }
    }

}
