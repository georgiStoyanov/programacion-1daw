package explorer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class Explorer extends JFrame {

	private JPanel contentPane;
	private JSplitPane _splitPane;
	private JList<File> list;
	private JTextPane textPane;
	private ArbolDirectorios _arbol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explorer frame = new Explorer();
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
	public Explorer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		_splitPane = new JSplitPane();
		contentPane.add(_splitPane, BorderLayout.CENTER);

		_arbol = new ArbolDirectorios();
		_arbol.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				Object seleccionado = e.getPath().getLastPathComponent();
				llenaLista(seleccionado);
				llenaEditor(seleccionado);
			}
		});
		_splitPane.setLeftComponent(_arbol);

		JTabbedPane _tabPane = new JTabbedPane(JTabbedPane.TOP);
		_splitPane.setRightComponent(_tabPane);

		list = new JList<File>();
		_tabPane.addTab("New tab", null, list, null);

		textPane = new JTextPane();
		_tabPane.addTab("New tab", null, textPane, null);
	}

	private void llenaLista(Object o) {
		if (o instanceof File) {
			File f = (File) o;
			list.setModel(new FicherosListModel(f));
		}
	}

	private void llenaEditor(Object o) {
		if (o instanceof File) {
			File f = (File) o;
			if (f.isFile()) {
				try (FileReader reader = new FileReader(f);
						StringWriter writer = new StringWriter()) {

					char[] buffer = new char[512];
					int leido = reader.read(buffer);
					while (leido != -1) {
						writer.write(buffer, 0, leido);
						leido = reader.read(buffer);
					}
					textPane.setText(writer.toString());
				}
				catch( Exception e ){
					textPane.setText( "Imposible leer:" + f);
				}
			}
		}
	}
}
