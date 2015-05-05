package ejemploHibernate;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditorAlumnoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditorAlumnoDialog dialog = new EditorAlumnoDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private EditorAlumno _editor;
	private final JPanel panel = new JPanel();
	private final JButton btnNewButton_1 = new JButton("Cancelar");
	private boolean _aceptado;
	
	public Alumno getAlumno() {
		return _editor.getAlumno();
	}

	public void setAlumno(Alumno alumno) {
		_editor.setAlumno(alumno);
	}

	public void updateAlumno() {
		_editor.updateAlumno();
	}

	public boolean isDirty() {
		return _editor.isDirty();
	}


	public EditorAlumnoDialog(Window owner) {
		super(owner);
		setBounds(100, 100, 450, 300);
		
		_editor = new EditorAlumno();
		getContentPane().add(_editor, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		panel.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}

			
		});
		panel.add(btnNewButton_1);
		
	}

	protected void aceptar() {
		_aceptado = true;
		updateAlumno();
		setVisible(false);
	}
	
	private void cancelar() {
		_aceptado = false;
		setVisible(false);
	}
	
	public boolean isAceptado(){
		return _aceptado;
	}
}
