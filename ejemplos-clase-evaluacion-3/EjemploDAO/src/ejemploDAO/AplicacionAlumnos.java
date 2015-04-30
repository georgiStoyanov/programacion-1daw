package ejemploDAO;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AplicacionAlumnos extends JFrame{
	
	private Connection conn;
	private AlumnoDAO dao;
	private JList<Alumno> alumnosList;
	
	
	private class AlumnoRenderer extends DefaultListCellRenderer{
		
		
		@Override
		public Component getListCellRendererComponent(JList<?> list,
				Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Component ret = super.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);
			JLabel label = (JLabel) ret;
			Alumno a = (Alumno) value;
			label.setText( a.getApellidos() + ", " + a.getNombre() );
			
			if( a.getNombre().equals("Álvaro") ){
				label.setFont( Font.decode("arial-24") );
			}
			
			System.out.println("Pintando la fila " + index );
			return ret;
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		Connection c = Conexiones.createConnection();
		AplicacionAlumnos f = new AplicacionAlumnos();
		f.setConnection(c);
		f.pack();
		f.setVisible(true);
	}
	
	public AplicacionAlumnos() throws Exception {
		initComponents();
		alumnosList.setCellRenderer( new AlumnoRenderer() );
	}
	
	public void setConnection(Connection conn) throws Exception{
		this.conn = conn;
		dao = new AlumnoSQLDAO(conn);
		llenarListaAlumnos();
	}
	
	private void llenarListaAlumnos() throws Exception {
		List<Alumno> alumnos = dao.findAll();
		
		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();
		for( Alumno a: alumnos ){
			model.addElement(a);
		}
		
		alumnosList.setModel(model);
	}

	public void initComponents(){
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		alumnosList = new JList<Alumno>();
		panel.add( new JScrollPane(alumnosList) );
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Nuevo alumno");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar alumno");
		panel_1.add(btnNewButton_1);
		
		JButton btnBorrarAlumno = new JButton("Borrar alumno");
		panel_1.add(btnBorrarAlumno);
	}
}
