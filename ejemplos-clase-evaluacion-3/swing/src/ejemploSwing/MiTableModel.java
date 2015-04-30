package ejemploSwing;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MiTableModel implements TableModel {


	private List<Alumno> _listaAlumnos = new ArrayList<Alumno>();

	@Override
	public int getRowCount() {
		return _listaAlumnos.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnas[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	private String[] columnas = { "#", "Nombre", "Apellidos", "Edad", "Nota" };

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Alumno a = _listaAlumnos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return rowIndex; // ORDEN
		case 1:
			return a.getNombre();
		case 2:
			return a.getApellidos();
		case 3:
			return a.getFechaNacimiento();
		case 4:
			return a.getNota();
		default:
			return "???";
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		System.out.printf( "%d,%d -> %s", rowIndex, columnIndex, aValue.toString());
		Alumno a = _listaAlumnos.get(rowIndex);
		switch (columnIndex) {
		case 1:
			a.setNombre(aValue.toString());
			break;
		case 2:
			a.setApellidos(aValue.toString());
			break;
		case 3:
			a.setFechaNacimiento( convierteAFecha(aValue.toString()) );
			break;
		case 4:
			a.setNota(aValue.toString());
			break;
		default:
			throw new IllegalArgumentException("la columna " + columnIndex + " no es editable");
		}
		laTablaHaCambiado();
		
	}

	private Date convierteAFecha(String string) {
	    String[] formatos = { "dd-MM-yyyy", "dd-MM-yy", "dd/MM/yyyy", "dd/MM/yy" };
	    for( String f : formatos ){
	        SimpleDateFormat sdf = new SimpleDateFormat(f);
	        try{
	            return sdf.parse(string);
	        }
	        catch( ParseException e ){
	            System.out.println( string + " no es una fecha con formato " + f );
	        }
	    }
	    return null;
    }

    private List<TableModelListener> _listaEscuchadores = new ArrayList<TableModelListener>();
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		_listaEscuchadores.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		_listaEscuchadores.remove(l);
	}
	
	public void nuevoAlumnoVacio(){
		_listaAlumnos.add( new Alumno("<vacio>", "<vacio>", new Date(), 6, "<vacio>") );
		laTablaHaCambiado();
	}

	private void laTablaHaCambiado() {
		for( TableModelListener l: _listaEscuchadores ){
			l.tableChanged( new TableModelEvent(this) );
		}
	}
	
	public Alumno getAlumno(int i){
		return _listaAlumnos.get(i);
	}
	
	public void borraAlumno(int i){
		_listaAlumnos.remove(i);
		laTablaHaCambiado();
	}

}
