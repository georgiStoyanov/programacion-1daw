import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Absolute extends JFrame {

	private JPanel contentPane;
	private JTextField txtlvaro;
	private JTextField txtApellidoss;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Absolute frame = new Absolute();
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
	public Absolute() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(27, 12, 70, 15);
		contentPane.add(lblNombre);
		
		txtlvaro = new JTextField();
		txtlvaro.setText("Álvaro");
		txtlvaro.setBounds(180, 10, 256, 19);
		contentPane.add(txtlvaro);
		txtlvaro.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(27, 46, 70, 15);
		contentPane.add(lblApellidos);
		
		txtApellidoss = new JTextField();
		txtApellidoss.setText("Apellidoss");
		txtApellidoss.setBounds(180, 41, 256, 19);
		contentPane.add(txtApellidoss);
		txtApellidoss.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 73, 70, 15);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(180, 72, 256, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(212, 130, 117, 25);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(331, 130, 117, 25);
		contentPane.add(btnCancelar);
	}
}
