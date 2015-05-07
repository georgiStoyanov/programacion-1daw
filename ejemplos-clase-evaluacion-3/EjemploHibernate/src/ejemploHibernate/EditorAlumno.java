package ejemploHibernate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class EditorAlumno extends JPanelConImagenDeFondo {

	
	private EntityManager _entityManager;
	
	
    public EntityManager getEntityManager() {
		return _entityManager;
	}

	public void setEntityManager(EntityManager _entityManager) {
		this._entityManager = _entityManager;
	}

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame f = new JFrame();

                    final EditorAlumno editor = new EditorAlumno();
                    editor.setImage("fondo-azul.jpg");
                    editor.setAjustaImagen(true);
                    f.getContentPane().add(editor, BorderLayout.CENTER);
                    f.pack();
                    f.setVisible(true);
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    final Alumno alumno = new Alumno(1,"Álvaro", "Gonzalez", new Date(), 6,
                            "Hola que tal\nyobien gracias\n hasta luego",null);
                    
                    System.out.println("alumno inicial:" + alumno);

                    editor.setAlumno(alumno);

                    f.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            System.out.println("Hace falta actualizar alumno:" + editor.isDirty() );
                            editor.updateAlumno();
                            System.out.println("alumno final:" + alumno);
                        }
                    });

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Alumno _alumno; 
    private JTextField nombreText;
    private JTextField apellidosText;
    private JSpinner nacimientoSpinner;
    private JEditorPane notaEditor;
    private boolean _dirty;
    private JSpinner calificacionSpinner;
    private JButton imagenLabel;
    private JLabel lblMatriculaciones;
    private JScrollPane scrollPane;
    private JList matriculacionesList;
    private JScrollPane scrollPane_1;
    private JPanel panel;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

    public Alumno getAlumno() {
        return _alumno;
    }

    public void setAlumno(Alumno alumno) {
        _alumno = alumno;
        nombreText.setText(_alumno.getNombre());
        apellidosText.setText(_alumno.getApellidos());

        if( _alumno.getFechaNacimiento() != null ){
        	nacimientoSpinner.setValue(_alumno.getFechaNacimiento());
        }
        calificacionSpinner.setValue(_alumno.getCalificacion());
        notaEditor.setText(_alumno.getNota());
        Image imagen ;
		try {
			imagen = ImageIO.read( new ByteArrayInputStream(_alumno.getImagen()) );
	        imagenLabel.setIcon( new ImageIcon(imagen));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DefaultListModel model = new DefaultListModel();
		for( Matriculacion m : _alumno.getMatriculaciones() ){
			model.addElement(m);
		}
		matriculacionesList.setModel(model);
		
        _dirty = false;
    }

    public void updateAlumno() {
        _alumno.setNombre(nombreText.getText());
        _alumno.setApellidos(apellidosText.getText());
        _alumno.setFechaNacimiento((Date) nacimientoSpinner.getValue());
        _alumno.setCalificacion(((Double) calificacionSpinner.getValue()).doubleValue());
        _alumno.setNota(notaEditor.getText());
        try {
            ImageIcon icon = (ImageIcon) imagenLabel.getIcon();
            BufferedImage image = (BufferedImage) icon.getImage();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(image,"png",out);
	        byte[] bytes = out.toByteArray();
			_alumno.setImagen( bytes );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        DefaultListModel model = (DefaultListModel) matriculacionesList.getModel();
        ArrayList<Matriculacion> matriculaciones = new ArrayList<Matriculacion>();
        for( int i = 0 ; i < model.getSize() ; i+=1 ){
        	Matriculacion m = (Matriculacion) model.getElementAt(i);
        	matriculaciones.add(m);
        }
        _alumno.setMatriculaciones(matriculaciones);
        
        _dirty = false;
    }

    public boolean isDirty() {
        return _dirty;
    }

    /**
     * Create the frame.
     */
    public EditorAlumno() {
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0 };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0 };
        setLayout(gbl_contentPane);

        imagenLabel = new JButton("");
        imagenLabel.setMaximumSize(new Dimension(128, 128));
        imagenLabel.setMinimumSize(new Dimension(128, 128));
        imagenLabel.setPreferredSize(new Dimension(128, 128));
        imagenLabel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cambiaImagen();
        	}
        });
        imagenLabel.setIcon(new ImageIcon(EditorAlumno.class.getResource("alumno-small.png")));
        GridBagConstraints gbc_imagenLabel = new GridBagConstraints();
        gbc_imagenLabel.anchor = GridBagConstraints.NORTH;
        gbc_imagenLabel.gridheight = 8;
        gbc_imagenLabel.insets = new Insets(0, 0, 0, 5);
        gbc_imagenLabel.gridx = 0;
        gbc_imagenLabel.gridy = 0;
        add(imagenLabel, gbc_imagenLabel);

        JLabel lblNewLabel = new JLabel("Nombre");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblApellidos = new JLabel("Apellidos");
        GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
        gbc_lblApellidos.anchor = GridBagConstraints.EAST;
        gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
        gbc_lblApellidos.gridx = 1;
        gbc_lblApellidos.gridy = 1;
        add(lblApellidos, gbc_lblApellidos);

        apellidosText = new JTextField();
        apellidosText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                setDirty();
            }
        });
        GridBagConstraints gbc_apellidosText = new GridBagConstraints();
        gbc_apellidosText.insets = new Insets(0, 0, 5, 0);
        gbc_apellidosText.fill = GridBagConstraints.HORIZONTAL;
        gbc_apellidosText.gridx = 2;
        gbc_apellidosText.gridy = 1;
        add(apellidosText, gbc_apellidosText);
        apellidosText.setColumns(10);

        JLabel lblEdad = new JLabel("Fecha nacimiento");
        GridBagConstraints gbc_lblEdad = new GridBagConstraints();
        gbc_lblEdad.anchor = GridBagConstraints.EAST;
        gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
        gbc_lblEdad.gridx = 1;
        gbc_lblEdad.gridy = 2;
        add(lblEdad, gbc_lblEdad);

        nacimientoSpinner = new JSpinner();
        nacimientoSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setDirty();
            }
        });
        nacimientoSpinner.setModel(new SpinnerDateModel(new Date(1430344800000L), null, null, Calendar.DATE));
        nacimientoSpinner.setEditor(new JSpinner.DateEditor(nacimientoSpinner, "dd-MM-yyyy"));
        nacimientoSpinner.setPreferredSize(new Dimension(100, 20));
        nacimientoSpinner.setMinimumSize(new Dimension(100, 20));
        GridBagConstraints gbc_nacimientoSpinner = new GridBagConstraints();
        gbc_nacimientoSpinner.anchor = GridBagConstraints.WEST;
        gbc_nacimientoSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_nacimientoSpinner.gridx = 2;
        gbc_nacimientoSpinner.gridy = 2;
        add(nacimientoSpinner, gbc_nacimientoSpinner);

        JLabel lblCalificacin = new JLabel("Calificación");
        GridBagConstraints gbc_lblCalificacin = new GridBagConstraints();
        gbc_lblCalificacin.anchor = GridBagConstraints.EAST;
        gbc_lblCalificacin.insets = new Insets(0, 0, 5, 5);
        gbc_lblCalificacin.gridx = 1;
        gbc_lblCalificacin.gridy = 3;
        add(lblCalificacin, gbc_lblCalificacin);

        calificacionSpinner = new JSpinner();
        calificacionSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setDirty();
            }
        });
        calificacionSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, 100.0, 1));
        GridBagConstraints gbc_calificacionSpinner = new GridBagConstraints();
        gbc_calificacionSpinner.anchor = GridBagConstraints.WEST;
        gbc_calificacionSpinner.insets = new Insets(0, 0, 5, 0);
        gbc_calificacionSpinner.gridx = 2;
        gbc_calificacionSpinner.gridy = 3;
        add(calificacionSpinner, gbc_calificacionSpinner);

        JSeparator separator = new JSeparator();
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.fill = GridBagConstraints.HORIZONTAL;
        gbc_separator.insets = new Insets(0, 0, 5, 0);
        gbc_separator.gridx = 2;
        gbc_separator.gridy = 4;
        add(separator, gbc_separator);

        JLabel lblNota = new JLabel("Nota");
        GridBagConstraints gbc_lblNota = new GridBagConstraints();
        gbc_lblNota.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblNota.insets = new Insets(0, 0, 5, 5);
        gbc_lblNota.gridx = 1;
        gbc_lblNota.gridy = 5;
        add(lblNota, gbc_lblNota);

        nombreText = new JTextField();
        nombreText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                setDirty();
            }
        });
        GridBagConstraints gbc_nombreText = new GridBagConstraints();
        gbc_nombreText.insets = new Insets(0, 0, 5, 0);
        gbc_nombreText.weightx = 1.0;
        gbc_nombreText.fill = GridBagConstraints.HORIZONTAL;
        gbc_nombreText.gridx = 2;
        gbc_nombreText.gridy = 0;
        add(nombreText, gbc_nombreText);
        nombreText.setColumns(10);
        
        scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 5;
        add(scrollPane, gbc_scrollPane);
        
                notaEditor = new JEditorPane();
                scrollPane.setViewportView(notaEditor);
                notaEditor.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        setDirty();
                    }
                });
        
        lblMatriculaciones = new JLabel("Matriculaciones");
        GridBagConstraints gbc_lblMatriculaciones = new GridBagConstraints();
        gbc_lblMatriculaciones.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblMatriculaciones.insets = new Insets(0, 0, 5, 5);
        gbc_lblMatriculaciones.gridx = 1;
        gbc_lblMatriculaciones.gridy = 6;
        add(lblMatriculaciones, gbc_lblMatriculaciones);
        
        panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 2;
        gbc_panel.gridy = 6;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        panel.setLayout(gbl_panel);
        matriculacionesList = new JList();
        
         scrollPane_1 = new JScrollPane(matriculacionesList);
         GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
         gbc_scrollPane_1.weighty = 1.0;
         gbc_scrollPane_1.weightx = 1.0;
         gbc_scrollPane_1.gridheight = 3;
         gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
         gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
         gbc_scrollPane_1.gridx = 0;
         gbc_scrollPane_1.gridy = 0;
         panel.add(scrollPane_1, gbc_scrollPane_1);
        
        btnNewButton = new JButton("Añadir matriculación");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addMatriculacion();
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 0;
        panel.add(btnNewButton, gbc_btnNewButton);
        
        btnNewButton_1 = new JButton("Borrar matriculación");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		removeMatriculacion();
        	}

        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 1;
        panel.add(btnNewButton_1, gbc_btnNewButton_1);
        
        
    }

    protected void addMatriculacion() {
    	Matriculacion m = new Matriculacion();
    	m.setNombreAsignatura("Una asignatura de " + _alumno.getNombre() );
    	m.setAlumno(_alumno);
    	if( getEntityManager() != null ){
    		System.out.println("Persistiendo:" + m );
    		getEntityManager().persist(m);
    	}
    	DefaultListModel model = (DefaultListModel) matriculacionesList.getModel();
    	model.addElement(m);
	}

	private void removeMatriculacion() {
		Matriculacion m = (Matriculacion)matriculacionesList.getSelectedValue();
		if( m == null ){
			return;
		}
    	DefaultListModel model = (DefaultListModel) matriculacionesList.getModel();
    	model.removeElement(m);
    	if( getEntityManager() != null ){
    		System.out.println("borrando:" + m );
    		getEntityManager().remove(m);
    	}
    	
	}

	protected void cambiaImagen() {
    	JFileChooser chooser = new JFileChooser();
    	chooser.setFileFilter( new FileNameExtensionFilter("Imagenes", "jpg", "png", "gif") );
    	int result = chooser.showOpenDialog(this);
    	if( result != JFileChooser.APPROVE_OPTION ){
    		return;
    	}
    	
    	File file = chooser.getSelectedFile();
    	
    	try {
			BufferedImage image = ImageIO.read(file);
			imagenLabel.setIcon( new ImageIcon(image) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	
	}

	protected void setDirty() {
        System.out.println("algo ha cambiado");
        _dirty = true;
    }

}

