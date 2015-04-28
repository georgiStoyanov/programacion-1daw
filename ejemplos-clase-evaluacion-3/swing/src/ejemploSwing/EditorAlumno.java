package ejemploSwing;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;


public class EditorAlumno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorAlumno frame = new EditorAlumno();
					frame.setVisible(true);
					
					Alumno alumno = new Alumno("nombre","gonzlaez","5", "Hola que tal\nyobien gracias\n hasta luego" );
					
					frame.setAlumno(alumno);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Alumno _alumno;
	private JTextField nombreText;
	private JTextField apellidosText;
	private JSpinner edadSpinner;
	private JEditorPane notaEditor;
	

	public Alumno getAlumno() {
		return _alumno;
	}


	public void setAlumno(Alumno _alumno) {
		this._alumno = _alumno;
		nombreText.setText(_alumno.nombre);
		apellidosText.setText(_alumno.apellidos);
		edadSpinner.setValue( Integer.parseInt(_alumno.edad) );
		notaEditor.setText(_alumno.nota);
	}


	/**
	 * Create the frame.
	 */
	public EditorAlumno() {
		initComponents();
		apellidosText.setInputVerifier( new InputVerifier() {
			
			@Override
			public boolean verify(JComponent input) {
				JTextField t = (JTextField) input;
				return t.getText().length() < 10;
			}
			
			@Override
			public boolean shouldYieldFocus(JComponent input) {
				JTextField t = (JTextField) input;
				int size = Math.min(10, t.getText().length() );
				String s = t.getText().substring(0, size); 
				t.setText(s);
				return true;
			}
		});
	}
	
	private void initComponents(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EditorAlumno.class.getResource("/ejemploSwing/alumno-small.png")));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridheight = 6;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 1;
		contentPane.add(lblApellidos, gbc_lblApellidos);
		
		apellidosText = new JTextField();
		GridBagConstraints gbc_apellidosText = new GridBagConstraints();
		gbc_apellidosText.insets = new Insets(0, 0, 5, 0);
		gbc_apellidosText.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidosText.gridx = 2;
		gbc_apellidosText.gridy = 1;
		contentPane.add(apellidosText, gbc_apellidosText);
		apellidosText.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.EAST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 1;
		gbc_lblEdad.gridy = 2;
		contentPane.add(lblEdad, gbc_lblEdad);
		
		edadSpinner = new JSpinner();
		edadSpinner.setPreferredSize(new Dimension(100, 20));
		edadSpinner.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_edadSpinner = new GridBagConstraints();
		gbc_edadSpinner.anchor = GridBagConstraints.WEST;
		gbc_edadSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_edadSpinner.gridx = 2;
		gbc_edadSpinner.gridy = 2;
		contentPane.add(edadSpinner, gbc_edadSpinner);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblNota = new JLabel("Nota");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNota.insets = new Insets(0, 0, 0, 5);
		gbc_lblNota.gridx = 1;
		gbc_lblNota.gridy = 4;
		contentPane.add(lblNota, gbc_lblNota);
		
		nombreText = new JTextField();
		nombreText.setToolTipText("10 caracteres máximo");
		GridBagConstraints gbc_nombreText = new GridBagConstraints();
		gbc_nombreText.insets = new Insets(0, 0, 5, 0);
		gbc_nombreText.weightx = 1.0;
		gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreText.gridx = 2;
		gbc_nombreText.gridy = 0;
		contentPane.add(nombreText, gbc_nombreText);
		nombreText.setColumns(10);
		
		notaEditor = new JEditorPane();
		GridBagConstraints gbc_notaEditor = new GridBagConstraints();
		gbc_notaEditor.fill = GridBagConstraints.BOTH;
		gbc_notaEditor.gridx = 2;
		gbc_notaEditor.gridy = 4;
		contentPane.add(notaEditor, gbc_notaEditor);
	}

}
