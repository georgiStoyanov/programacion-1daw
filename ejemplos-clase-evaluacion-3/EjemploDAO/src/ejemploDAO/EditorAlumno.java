package ejemploDAO;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EditorAlumno extends JPanelConImagenDeFondo {

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

                    final Alumno alumno = new Alumno("Álvaro", "Gonzalez", new Date(), 6,
                            "Hola que tal\nyobien gracias\n hasta luego");
                    
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

    public Alumno getAlumno() {
        return _alumno;
    }

    public void setAlumno(Alumno alumno) {
        _alumno = alumno;
        nombreText.setText(_alumno.getNombre());
        apellidosText.setText(_alumno.getApellidos());

        nacimientoSpinner.setValue(_alumno.getFechaNacimiento());
        calificacionSpinner.setValue(_alumno.getCalificacion());
        notaEditor.setText(_alumno.getNota());
        _dirty = false;
    }

    public void updateAlumno() {
        _alumno.setNombre(nombreText.getText());
        _alumno.setApellidos(apellidosText.getText());
        _alumno.setFechaNacimiento((Date) nacimientoSpinner.getValue());
        _alumno.setCalificacion(((Double) calificacionSpinner.getValue()).doubleValue());
        _alumno.setNota(notaEditor.getText());
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
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0 };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 };
        setLayout(gbl_contentPane);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(EditorAlumno.class.getResource("alumno-small.png")));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel_1.gridheight = 7;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 0;
        add(lblNewLabel_1, gbc_lblNewLabel_1);

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

        notaEditor = new JEditorPane();
        notaEditor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                setDirty();
            }
        });
        GridBagConstraints gbc_notaEditor = new GridBagConstraints();
        gbc_notaEditor.insets = new Insets(0, 0, 5, 0);
        gbc_notaEditor.fill = GridBagConstraints.BOTH;
        gbc_notaEditor.gridx = 2;
        gbc_notaEditor.gridy = 5;
        add(notaEditor, gbc_notaEditor);
    }

    protected void setDirty() {
        System.out.println("algo ha cambiado");
        _dirty = true;
    }

}

