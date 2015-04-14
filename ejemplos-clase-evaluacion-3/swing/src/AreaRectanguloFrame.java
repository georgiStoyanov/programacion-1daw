import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class AreaRectanguloFrame extends JFrame {

	private JPanel contentPane;
	private JTextField anchoText;
	private JTextField altoText;
	private JTextField areaText;
	private JSlider anchoSlider;
	private JSlider altoSlider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaRectanguloFrame frame = new AreaRectanguloFrame();
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
	public AreaRectanguloFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		anchoSlider = new JSlider();
		anchoSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if( anchoSlider == null || altoSlider == null ){
					return;
				}
				int ancho = anchoSlider.getValue();
				int alto = altoSlider.getValue();
				if( anchoText != null){
					anchoText.setText(String.valueOf(ancho));
				}
				if( areaText != null ){
					areaText.setText(""+(alto*ancho));
				}
			}
		});
		anchoSlider.setMajorTickSpacing(10);
		anchoSlider.setPaintTicks(true);
		anchoSlider.setMinimum(5);
		anchoSlider.setBounds(75, 19, 200, 38);
		contentPane.add(anchoSlider);
		
		altoSlider = new JSlider();
		altoSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if( anchoSlider == null || altoSlider == null ){
					return;
				}
				
				int ancho = anchoSlider.getValue();
				int alto = altoSlider.getValue();
				if( altoText != null){
					altoText.setText(String.valueOf(alto));
				}
				if( areaText != null ){
					areaText.setText(""+(alto*ancho));
				}
			}
		});
		altoSlider.setPaintTicks(true);
		altoSlider.setMajorTickSpacing(10);
		altoSlider.setMinorTickSpacing(10);
		altoSlider.setMinimum(5);
		altoSlider.setBounds(75, 69, 200, 33);
		contentPane.add(altoSlider);
		
		anchoText = new MiTexto();
		anchoText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String s = anchoText.getText();
				if( !esEntero(s) ){
					int oldValue = anchoSlider.getValue();
					anchoSlider.setValue(0);
					anchoSlider.setValue(oldValue);
					
				}
				else{
					anchoSlider.setValue(Integer.valueOf(s));
				}
			}

		});
		anchoText.setBounds(287, 19, 114, 19);
		contentPane.add(anchoText);
		anchoText.setColumns(10);
		
		altoText = new MiTexto();
		altoText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String s = altoText.getText();
				if( !esEntero(s) ){
					int oldValue = altoSlider.getValue();
					altoSlider.setValue(0);
					altoSlider.setValue(oldValue);
					
				}
				else{
					altoSlider.setValue(Integer.valueOf(s));
				}
			}
		});
		altoText.setBounds(287, 69, 114, 19);
		contentPane.add(altoText);
		altoText.setColumns(10);
		
		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(12, 19, 70, 15);
		contentPane.add(lblAncho);
		
		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setBounds(12, 70, 70, 15);
		contentPane.add(lblAlto);
		
		JLabel lblrea = new JLabel("Área");
		lblrea.setBounds(12, 118, 70, 15);
		contentPane.add(lblrea);
		
		areaText = new JTextField();
		areaText.setEditable(false);
		areaText.setBounds(75, 116, 114, 19);
		contentPane.add(areaText);
		areaText.setColumns(10);
		
		anchoSlider.setValue(5);
		altoSlider.setValue(5);
	}
	
	private boolean esEntero(String s) {
		try{
			Integer.parseInt(s);
			return true;
		}
		catch( NumberFormatException e ){
			return false;
		}
	}

}
