import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.border.Border;


public class MiTexto extends JTextField{

	
	Border border;
	
	public MiTexto() {
		super();
		// TODO Auto-generated constructor stub
		enganchaListeners();
	}

	public MiTexto(String text) {
		super(text);
		// TODO Auto-generated constructor stub
		enganchaListeners();
	}

	private void enganchaListeners() {
		disimula();
		addFocusListener( new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				disimula();

				
			}
			

			@Override
			public void focusGained(FocusEvent e) {
				aparenta();
				
			}

		});
	}

	private void disimula() {
		if( border == null ){
			border = getBorder();
		}
		setBorder(null);
		setOpaque(false);
		System.out.println("disimula");		
		
	}

	private void aparenta() {
		setOpaque(true);
		setBorder(border);
		System.out.println("aparenta");
	}
	
}
