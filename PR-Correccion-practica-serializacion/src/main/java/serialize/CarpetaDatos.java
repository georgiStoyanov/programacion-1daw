package serialize;



public interface CarpetaDatos extends Dato{

    public Dato[] getDatos();
    public DatoTexto addDatoTexto( String nombre, String valor );
    public CarpetaDatos addCarpetaDatos( String nombre );
}
