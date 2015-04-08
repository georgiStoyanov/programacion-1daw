import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Border extends JFrame {

	private JPanel contentPane;
	private JButton btnCentro;
	private JButton btnOeste;
	private JButton btnEste;
	private JButton btnSur;
	private JButton btnNorte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Border frame = new Border();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void ocultar( JButton b ){
		JButton[] botones = {
				btnNorte, btnCentro, btnEste, btnOeste, btnSur
		};
		for( JButton button: botones ){
			button.setVisible(true);
		}
		b.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public Border() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnNorte = new JButton("Norte");
		btnNorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultar((JButton)e.getSource());
			}
		});
		contentPane.add(btnNorte, BorderLayout.NORTH);
		
		btnSur = new JButton("Sur");
		btnSur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultar((JButton)e.getSource());
			}
		});
		contentPane.add(btnSur, BorderLayout.SOUTH);
		
		btnEste = new JButton("Este");
		btnEste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultar((JButton)e.getSource());
			}
		});
		contentPane.add(btnEste, BorderLayout.EAST);
		
		btnOeste = new JButton("Oeste");
		btnOeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultar((JButton)e.getSource());
			}
		});
		contentPane.add(btnOeste, BorderLayout.WEST);
		
		btnCentro = new JButton("Centro");
		btnCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultar((JButton)e.getSource());
			}
		});
		contentPane.add(btnCentro, BorderLayout.CENTER);
	}

}
