package ejemploHibernate;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class AplicacionAlumnos extends JFrame {

	private AlumnoDAO dao;
	private JList<Alumno> alumnosList;
	private EntityManager _em;

	private class AlumnoRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list,
				Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Component ret = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			JLabel label = (JLabel) ret;
			Alumno a = (Alumno) value;
			label.setText(a.getApellidos() + ", " + a.getNombre());

			if (a.getNombre().equals("Álvaro")) {
				label.setFont(Font.decode("arial-24"));
			}

			System.out.println("Pintando la fila " + index);
			return ret;

		}
	}

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ejemplo-oracle");
		EntityManager em = emf.createEntityManager();
		AplicacionAlumnos f = new AplicacionAlumnos();
		f.setEntityManager(em);
		f.pack();
		f.setVisible(true);
	}

	public AplicacionAlumnos() throws Exception {
		initComponents();
		alumnosList.setCellRenderer(new AlumnoRenderer());
	}

	public void setEntityManager(EntityManager em) throws Exception {
		_em = em;
		dao = new AlumnoHibernateDAO(em);
		llenarListaAlumnos();
	}

	private void llenarListaAlumnos() throws Exception {
		List<Alumno> alumnos = dao.findAll();

		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();
		for (Alumno a : alumnos) {
			model.addElement(a);
		}

		alumnosList.setModel(model);
	}

	public void initComponents() {
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		alumnosList = new JList<Alumno>();
		panel.add(new JScrollPane(alumnosList));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));

		JButton btnNewButton = new JButton("Nuevo alumno");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creaNuevoAlumno();
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Editar alumno");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarAlumnoSeleccionado();
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnBorrarAlumno = new JButton("Borrar alumno");
		btnBorrarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borraAlumnoSeleccionado();
			}
		});
		panel_1.add(btnBorrarAlumno);
	}

	protected void creaNuevoAlumno() {
		Alumno alumno = new Alumno();
		EditorAlumnoDialog dialog = new EditorAlumnoDialog(this);
		dialog.setEntityManager(_em);
		dialog.setAlumno(alumno);
		dialog.pack();
		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		EntityTransaction tx = _em.getTransaction();
		dialog.setVisible(true);
		if (!dialog.isAceptado()) {
			return;
		}
		tx.begin();
		dao.insert(alumno);
		tx.commit();
		((DefaultListModel<Alumno>) alumnosList.getModel()).addElement(alumno);
	}

	protected void editarAlumnoSeleccionado() {
		Alumno alumno = alumnosList.getSelectedValue();
		if (alumno == null) {
			return;
		}

		EditorAlumnoDialog dialog = new EditorAlumnoDialog(this);
		dialog.setEntityManager(_em);
		dialog.setAlumno(alumno);
		dialog.pack();
		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog.setVisible(true);
		if (!dialog.isAceptado()) {
			return;
		}

		EntityTransaction tx = _em.getTransaction();
		tx.begin();
		dao.update(alumno);
		tx.commit();

		// QUITO Y PONGO EL MODELO PARA REFRESCAR LA LISTA
		// HABRÍA QUE HACER UN MODELO PROPIO QUE LANZASE EVENTOS DE CAMBIO
		ListModel<Alumno> model = alumnosList.getModel();
		alumnosList.setModel(new DefaultListModel<Alumno>());
		alumnosList.setModel(model);

	}

	protected void borraAlumnoSeleccionado() {
		Alumno a = alumnosList.getSelectedValue();
		if (a == null) {
			return;
		}

		int o = JOptionPane.showConfirmDialog(this, "¿Quieres borrar el alumno"
				+ a + "?");
		if (o != JOptionPane.OK_OPTION) {
			return;
		}

		EntityTransaction tx = _em.getTransaction();
		tx.begin();
		dao.delete(a);
		tx.commit();
		DefaultListModel<Alumno> model = (DefaultListModel<Alumno>) alumnosList
				.getModel();
		model.removeElement(a);
	}
}
