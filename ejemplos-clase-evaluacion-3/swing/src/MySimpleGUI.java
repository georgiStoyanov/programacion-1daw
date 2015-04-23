import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.sound.sampled.AudioSystem;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MySimpleGUI extends JFrame {
	
	private class HanDadoEnAceptarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("han pinchado en aceptar");
			String usuario = usuarioTextField.getText();
			String pass = new String( passwordField.getPassword() );
			
			if( !usuario.equals(USUARIO) ){
				errorLabel.setText("El usuario no existe");
				System.out.println("El usuario no existe");
				return;
			}
			if( !pass.equals(PASS) ){
				errorLabel.setText("La contraseña es incorrecta");
				System.out.println("La contraseña es incorrecta");
				return;
			}
			
			errorLabel.setText("");
			System.out.println("Login correcto");
			
			MySimpleGUI.this.setVisible(false);
			new AreaRectanguloFrame().setVisible(true);
		}
		
	}
	
	private static final String USUARIO = "asd";
	private static final String PASS = "asd";
	
	private JTextField usuarioTextField;
	private JPasswordField passwordField;
	private JLabel errorLabel;
	public MySimpleGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		
		JLabel lblUnaEtiqueta = new JLabel("Nombre");
		lblUnaEtiqueta.setBounds(59, 51, 70, 15);
		getContentPane().add(lblUnaEtiqueta);
		
		usuarioTextField = new JTextField();
		usuarioTextField.setBounds(159, 49, 114, 19);
		getContentPane().add(usuarioTextField);
		usuarioTextField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(59, 93, 70, 19);
		getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 93, 125, 19);
		getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("Aceptar");
		btnOk.addActionListener(new HanDadoEnAceptarListener());
		btnOk.setBounds(142, 124, 114, 25);
		getContentPane().add(btnOk);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySimpleGUI.this.setVisible(false);
				System.exit(0);
			}
		});
		btnCancelar.setBounds(273, 124, 117, 25);
		getContentPane().add(btnCancelar);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(59, 12, 293, 15);
		getContentPane().add(errorLabel);
		setBackground(Color.ORANGE);
		setSize(400, 200);
		setTitle("Ventana de tipo JFrame");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MySimpleGUI gui = new MySimpleGUI();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
