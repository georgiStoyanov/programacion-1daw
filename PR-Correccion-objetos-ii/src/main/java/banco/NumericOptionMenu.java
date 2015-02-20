package banco;


public abstract class NumericOptionMenu extends Menu {

    private Opcion[] _opciones;
    private String[] _cabecera;

    public NumericOptionMenu( String cabecera[], Opcion[] os) {
        _opciones = os;
        _cabecera = cabecera;
    }

    @Override
    public String[] cabecera(){
        return _cabecera;   
    }


    @Override 
    public Opcion[] opciones(){
        return _opciones.clone();
    }

}
