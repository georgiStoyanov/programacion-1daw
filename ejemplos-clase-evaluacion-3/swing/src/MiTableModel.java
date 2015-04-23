import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MiTableModel implements TableModel {

	public class Alumno {
		String nombre;
		String apellidos;
		String edad;
		String nota;

		public Alumno(String nombre, String apellidos, String edad, String nota) {
			super();
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.edad = edad;
			this.nota = nota;
		}
	}

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
			return a.nombre;
		case 2:
			return a.apellidos;
		case 3:
			return a.edad;
		case 4:
			return a.nota;
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
			a.nombre = aValue.toString();
			break;
		case 2:
			a.apellidos = aValue.toString();
			break;
		case 3:
			a.edad = aValue.toString();
			break;
		case 4:
			a.nota = aValue.toString();
			break;
		default:
			throw new IllegalArgumentException("la columna " + columnIndex + " no es editable");
		}
		laTablaHaCambiado();
		
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
		_listaAlumnos.add( new Alumno("<vacio>", "<vacio>", "<vacio>", "<vacio>") );
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

}
