package banco;


public abstract class NumericOptionMenu extends Menu {

    private Opcion[] _opciones;

    public NumericOptionMenu( Opcion[] os) {
        _opciones = os;
    }

    @Override
    public String[] cabecera(){
        return new String[0];
    }


    @Override 
    public Opcion[] opciones(){
        return _opciones.clone();
    }

}
