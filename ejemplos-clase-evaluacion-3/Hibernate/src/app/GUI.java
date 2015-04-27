package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

public class GUI extends JFrame {

    private JPanel contentPane;
    private JButton imagenIcon;
    private JTable clientesTable;
    private ClientesTableModel _clientesTableModel;
    private EntityManager _entityManager;

    private class ClientesTableModel implements TableModel {

        private List<Cliente> _clientes;
        private String[] _columnNames = { "ID", "Nombre", "Apellidos" };
        private List<TableModelListener> _listeners = new ArrayList<TableModelListener>();

        public ClientesTableModel() {
            _clientes = leerClientes();
        }

        private List<Cliente> leerClientes() {
            EntityTransaction tx = getEntityManager().getTransaction();
            try {
                tx.begin();
                Query query = getEntityManager().createQuery("FROM Cliente");
                @SuppressWarnings("unchecked")
                List<Cliente> ret = query.getResultList();
                {
                    for (Cliente c : ret) {
                        System.out.println(c);
                    }
                }
                return ret;
            }
            finally {
                tx.commit();
            }

        }


        @Override
        public int getRowCount() {
            return _clientes.size();
        }

        @Override
        public int getColumnCount() {
            return _columnNames.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return _columnNames[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return !getColumnName(columnIndex).equals("ID");
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Cliente c = _clientes.get(rowIndex);
            String column = getColumnName(columnIndex);
            if (column.equals("ID"))
                return "" + c.getIdCliente();
            if (column.equals("Nombre"))
                return c.getNombre();
            if (column.equals("Apellidos"))
                return c.getApellidos();
            return "???";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            String value = aValue.toString();
            Cliente c = _clientes.get(rowIndex);
            String column = getColumnName(columnIndex);
            if (column.equals("Nombre"))
                c.setNombre(value);
            if (column.equals("Apellidos"))
                c.setApellidos(value);

            salvarCliente(c);
            TableModelEvent e = new TableModelEvent(this, rowIndex);
            fireTableChanged(e);
        }

        private void fireTableChanged(TableModelEvent e) {
            for (TableModelListener l : _listeners) {
                l.tableChanged(e);
            }
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
            _listeners.add(l);
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
            _listeners.remove(l);
        }

        public Cliente getCliente(int row) {
            return _clientes.get(row);
        }

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                    frame.inicializaBaseDeDatos();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void inicializaBaseDeDatos() {
        clientesTable.setModel(getClientesTableModel());
    }

    /**
     * Create the frame.
     */
    public GUI() {
        initComponents();
        initListeners();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel clientesPanel = new JPanel();
        contentPane.add(clientesPanel, BorderLayout.CENTER);
        clientesPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        clientesPanel.add(scrollPane, BorderLayout.CENTER);

        clientesTable = new JTable();
        scrollPane.setViewportView(clientesTable);

        JPanel panel = new JPanel();

        clientesPanel.add(panel, BorderLayout.SOUTH);

        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 64, 0 };
        gbl_panel.rowHeights = new int[] { 64, 0, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        imagenIcon = new JButton("New button");
        imagenIcon.setPreferredSize(new Dimension(64, 64));
        imagenIcon.setMinimumSize(new Dimension(64, 64));
        imagenIcon.setMaximumSize(new Dimension(64, 64));
        GridBagConstraints gbc_imagenIcon = new GridBagConstraints();
        gbc_imagenIcon.insets = new Insets(0, 0, 5, 0);
        gbc_imagenIcon.gridx = 0;
        gbc_imagenIcon.gridy = 0;
        panel.add(imagenIcon, gbc_imagenIcon);

        JButton cambiarImagenButton = new JButton("Cambiar...");
        cambiarImagenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarImagen();
            }
        });
        GridBagConstraints gbc_cambiarImagenButton = new GridBagConstraints();
        gbc_cambiarImagenButton.weightx = 1.0;
        gbc_cambiarImagenButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_cambiarImagenButton.anchor = GridBagConstraints.NORTH;
        gbc_cambiarImagenButton.gridx = 0;
        gbc_cambiarImagenButton.gridy = 1;
        panel.add(cambiarImagenButton, gbc_cambiarImagenButton);
        
    }

    
    private void initListeners(){
        clientesTable.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Cliente c = getClienteSeleccionado();
                if( c == null || c.getImagen() == null ){
                    imagenIcon.setIcon(null);
                    return;
                }
                Icon icon = new ImageIcon(c.getImagen());
                imagenIcon.setIcon(icon);
            }
        });
    }
    
    protected void cambiarImagen() {
        Cliente c = getClienteSeleccionado();
        if (c == null) {
            return;
        }
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Imágenes", "png", "jpg", "gif", "jpeg", "bmp"));
        int ret = jfc.showOpenDialog(this);
        if (ret != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File f = jfc.getSelectedFile();
        setImage(c, f);
        salvarCliente(c);
    }

    private void setImage(Cliente c, File f) {
        try {
            InputStream in = new FileInputStream(f);
            byte buffer[] = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int leidos = in.read(buffer);
            while (leidos > 0) {
                baos.write(buffer, 0, leidos);
                leidos = in.read(buffer);
            }
            in.close();
            baos.close();
            c.setImagen(baos.toByteArray());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Cliente getClienteSeleccionado() {
        int selectedRow = clientesTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return _clientesTableModel.getCliente(selectedRow);
    }

    private ClientesTableModel getClientesTableModel() {
        if (_clientesTableModel == null) {
            _clientesTableModel = new ClientesTableModel();

        }

        return _clientesTableModel;
    }

    private EntityManager getEntityManager() {
        if (_entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplo-derby");
            _entityManager = emf.createEntityManager();
        }
        return _entityManager;
    }
    
    private void salvarCliente(Cliente c) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            getEntityManager().persist(c);
        }
        finally {
            tx.commit();
        }
    }

}
