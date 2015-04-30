package ejemploSwing;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class TablaDeAlumnos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPaneAlumnos;
	private JTable tablaAlumnos;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel numeroAlumnosLabel;
	private JPanel panel_1;
	private JButton borrarAlumnoButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaDeAlumnos frame = new TablaDeAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TablaDeAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Object[][] datosAlumnos = {
				{ "pepe", "gonzalez", "20", "5" },
				{ "juan", "perez", "18", "6" },
		};
		Object[] cabeceras = {
				"Nombre", "Apellidos", "Edad", "Nota"
		};
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("DefaultTableModel", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel( new DefaultTableModel(datosAlumnos,cabeceras) );
		final MiTableModel model = new MiTableModel();
		
		panel = new JPanel();
		tabbedPane.addTab("MiTableModel", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPaneAlumnos = new JScrollPane();
		panel.add(scrollPaneAlumnos);
		
		tablaAlumnos = new JTable();
		scrollPaneAlumnos.setViewportView(tablaAlumnos);
		tablaAlumnos.setModel( model );
		
		numeroAlumnosLabel = new JLabel("Media de notas: -");
		panel.add(numeroAlumnosLabel, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{148, 136, 0};
		gbl_panel_1.rowHeights = new int[]{25, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnNewButton = new JButton("Añadir alumno");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.weightx = 1.0;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		borrarAlumnoButton = new JButton("Borrar alumno");
		borrarAlumnoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarAlumnoSeleccionado();
			}

		});
		GridBagConstraints gbc_borrarAlumnoButton = new GridBagConstraints();
		gbc_borrarAlumnoButton.anchor = GridBagConstraints.WEST;
		gbc_borrarAlumnoButton.weightx = 1.0;
		gbc_borrarAlumnoButton.gridx = 1;
		gbc_borrarAlumnoButton.gridy = 0;
		panel_1.add(borrarAlumnoButton, gbc_borrarAlumnoButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.nuevoAlumnoVacio();
			}
		});
		
		model.addTableModelListener( new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				int filas = model.getRowCount();
				double media = 0;
				for( int i = 0 ; i < filas ; i++ ){
					double nota = intentaPasarADouble( model.getAlumno(i).getNota() );
					media += nota;
				}
				numeroAlumnosLabel.setText( "Media de notas:" + media/filas );
			}

			private double intentaPasarADouble(String nota) {
				try{
					return Double.valueOf(nota);
				}
				catch( NumberFormatException e ){
					return 0;
				}
			}
		});
	}
	

	private void borrarAlumnoSeleccionado() {
		int selected = tablaAlumnos.getSelectedRow();
		if( selected == -1 ){
			return;
		}
		((MiTableModel)tablaAlumnos.getModel()).borraAlumno(selected);
		
		
	}
}
