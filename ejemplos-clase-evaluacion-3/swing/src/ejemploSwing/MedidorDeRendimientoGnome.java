package ejemploSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MedidorDeRendimientoGnome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedidorDeRendimientoGnome frame = new MedidorDeRendimientoGnome();
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
	public MedidorDeRendimientoGnome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("CPU History"); 
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnIma = new JButton("Imagina la gráfica");
		GridBagConstraints gbc_btnIma = new GridBagConstraints();
		gbc_btnIma.gridwidth = 5;
		gbc_btnIma.weighty = 1.0;
		gbc_btnIma.weightx = 1.0;
		gbc_btnIma.fill = GridBagConstraints.BOTH;
		gbc_btnIma.insets = new Insets(0, 0, 5, 0);
		gbc_btnIma.gridx = 0;
		gbc_btnIma.gridy = 1;
		contentPane.add(btnIma, gbc_btnIma);
		
		JLabel lblAsdfasdf = new JLabel("CPU1 45%");
		lblAsdfasdf.setIcon(new ImageIcon(MedidorDeRendimientoGnome.class.getResource("/ejemploSwing/rectangle-red.png")));
		GridBagConstraints gbc_lblAsdfasdf = new GridBagConstraints();
		gbc_lblAsdfasdf.weightx = 5.0;
		gbc_lblAsdfasdf.anchor = GridBagConstraints.WEST;
		gbc_lblAsdfasdf.insets = new Insets(0, 75, 5, 5);
		gbc_lblAsdfasdf.gridx = 0;
		gbc_lblAsdfasdf.gridy = 2;
		contentPane.add(lblAsdfasdf, gbc_lblAsdfasdf);
		
		JLabel lblCpu = new JLabel("CPU2 45%");
		lblCpu.setIcon(new ImageIcon(MedidorDeRendimientoGnome.class.getResource("/ejemploSwing/rectangle-red.png")));
		GridBagConstraints gbc_lblCpu = new GridBagConstraints();
		gbc_lblCpu.anchor = GridBagConstraints.WEST;
		gbc_lblCpu.weightx = 5.0;
		gbc_lblCpu.insets = new Insets(0, 75, 5, 5);
		gbc_lblCpu.gridx = 2;
		gbc_lblCpu.gridy = 2;
		contentPane.add(lblCpu, gbc_lblCpu);
		
		JLabel lblMemoryAndSwap = new JLabel("Memory and Swap History");
		lblMemoryAndSwap.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblMemoryAndSwap = new GridBagConstraints();
		gbc_lblMemoryAndSwap.anchor = GridBagConstraints.WEST;
		gbc_lblMemoryAndSwap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMemoryAndSwap.gridx = 0;
		gbc_lblMemoryAndSwap.gridy = 3;
		contentPane.add(lblMemoryAndSwap, gbc_lblMemoryAndSwap);
		
		JButton button = new JButton("Imagina la gráfica");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 5;
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 4;
		contentPane.add(button, gbc_button);
		
		JLabel lblNetworkHistory = new JLabel("Network History");
		lblNetworkHistory.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNetworkHistory = new GridBagConstraints();
		gbc_lblNetworkHistory.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetworkHistory.anchor = GridBagConstraints.WEST;
		gbc_lblNetworkHistory.gridx = 0;
		gbc_lblNetworkHistory.gridy = 6;
		contentPane.add(lblNetworkHistory, gbc_lblNetworkHistory);
		
		JButton button_1 = new JButton("Imagina la gráfica");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridwidth = 5;
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 7;
		contentPane.add(button_1, gbc_button_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 75, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblAdfadsf = new JLabel("");
		lblAdfadsf.setIcon(new ImageIcon(MedidorDeRendimientoGnome.class.getResource("/ejemploSwing/rectangle-red.png")));
		GridBagConstraints gbc_lblAdfadsf = new GridBagConstraints();
		gbc_lblAdfadsf.insets = new Insets(0, 0, 0, 5);
		gbc_lblAdfadsf.gridheight = 2;
		gbc_lblAdfadsf.gridx = 0;
		gbc_lblAdfadsf.gridy = 0;
		panel.add(lblAdfadsf, gbc_lblAdfadsf);
		
		JLabel lblNewLabel_1 = new JLabel("Receiving");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("90 byte/s");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Total Received");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("1000MB");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 1;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 75, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 8;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MedidorDeRendimientoGnome.class.getResource("/ejemploSwing/rectangle-red.png")));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridheight = 2;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("Receiving");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("90 byte/s");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 0;
		panel_1.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("Total Received");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("1000MB");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 1;
		panel_1.add(label_4, gbc_label_4);
	}
}
