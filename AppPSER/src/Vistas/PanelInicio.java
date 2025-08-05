package Vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import Persistencia.Usuario;
import Persistencia.Usuarios;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelInicio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuarios usuarios;
	private JLabel lblImagen;
	private ImageIcon imagen;
	private Icon icono;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldHuella;
	private JTextField textFieldFNacimiento;
	private JTextField textFieldFUltAcceso;

	/**
	 * Create the panel.
	 */
	public PanelInicio(Usuarios usuarios, JTextArea textAreaArduino) {

		this.usuarios = usuarios;

		setLayout(new BorderLayout(0, 0));

		JPanel panel_norte = new JPanel();
		add(panel_norte, BorderLayout.NORTH);
		panel_norte.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JLabel lblUltimoAcceso = new JLabel("Ultimo acceso:");
		lblUltimoAcceso.setHorizontalAlignment(SwingConstants.LEFT);
		lblUltimoAcceso.setFont(new Font("Arial", Font.ITALIC, 18));
		panel_norte.add(lblUltimoAcceso);

		JPanel panel_sur = new JPanel();
		add(panel_sur, BorderLayout.SOUTH);

		JPanel panel_centro = new JPanel();
		add(panel_centro, BorderLayout.CENTER);
		GridBagLayout gbl_panel_centro = new GridBagLayout();
		gbl_panel_centro.columnWidths = new int[] { 25, 90, 35, 25, 0 };
		gbl_panel_centro.rowHeights = new int[] { 10, 120, 0, 0, 0, 0, 0, 30, 0, 0, 10, 0 };
		gbl_panel_centro.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_centro.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		panel_centro.setLayout(gbl_panel_centro);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		panel_centro.add(panel, gbc_panel);

		lblImagen = new JLabel("");
		panel.add(lblImagen);
		pintarImagen("src/recursos/user.png");

		JLabel lblNewLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_centro.add(lblNewLabel, gbc_lblNewLabel);

		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;
		panel_centro.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(20);

		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel_centro.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setEditable(false);
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellidos.gridx = 2;
		gbc_textFieldApellidos.gridy = 3;
		panel_centro.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(20);

		JLabel lblNewLabel_2 = new JLabel("ID Huella:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel_centro.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldHuella = new JTextField();
		textFieldHuella.setEditable(false);
		GridBagConstraints gbc_textFieldHuella = new GridBagConstraints();
		gbc_textFieldHuella.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHuella.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHuella.gridx = 2;
		gbc_textFieldHuella.gridy = 4;
		panel_centro.add(textFieldHuella, gbc_textFieldHuella);
		textFieldHuella.setColumns(20);

		JLabel lblNewLabel_3 = new JLabel("F. Nacimiento:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		panel_centro.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textFieldFNacimiento = new JTextField();
		textFieldFNacimiento.setEditable(false);
		GridBagConstraints gbc_textFieldFNacimiento = new GridBagConstraints();
		gbc_textFieldFNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFNacimiento.gridx = 2;
		gbc_textFieldFNacimiento.gridy = 5;
		panel_centro.add(textFieldFNacimiento, gbc_textFieldFNacimiento);
		textFieldFNacimiento.setColumns(20);

		JLabel lblNewLabel_4 = new JLabel("F. Ult. Acceso:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		panel_centro.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textFieldFUltAcceso = new JTextField();
		textFieldFUltAcceso.setEditable(false);
		GridBagConstraints gbc_textFieldFUltAcceso = new GridBagConstraints();
		gbc_textFieldFUltAcceso.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFUltAcceso.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFUltAcceso.gridx = 2;
		gbc_textFieldFUltAcceso.gridy = 6;
		panel_centro.add(textFieldFUltAcceso, gbc_textFieldFUltAcceso);
		textFieldFUltAcceso.setColumns(20);

		JLabel lblNewLabel_5 = new JLabel("Log:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		panel_centro.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JScrollPane scrollPane = new JScrollPane(textAreaArduino);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 9;
		panel_centro.add(scrollPane, gbc_scrollPane);
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				e.getAdjustable().setValue(e.getAdjustable().getMaximum());
			}
		});
	}

	private void pintarImagen(String pahtImage) {
		imagen = new ImageIcon(pahtImage);
		Image image = imagen.getImage();
		Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		icono = new ImageIcon(newimg);
		lblImagen.setIcon(icono);
		this.repaint();
	}

	public void showUser(String idUser) {
		Usuario user = usuarios.getUser(idUser);
		textFieldNombre.setText(" " + user.getNombre());
		textFieldApellidos.setText(" " + user.getApellidos());
		textFieldHuella.setText(" " + user.getIdHuella());
		textFieldFNacimiento.setText(" " + user.getFechaNacimiento());
		textFieldFUltAcceso.setText(" " + user.getFechaUltimoAcceso());
		pintarImagen(user.getFoto());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		user.setFechaUltimoAcceso(formatter.format(date));
	}

	public void showErrorUser() {
		textFieldNombre.setText(" -");
		textFieldApellidos.setText(" -");
		textFieldHuella.setText(" -");
		textFieldFNacimiento.setText(" -");
		textFieldFUltAcceso.setText(" -");
		pintarImagen("src/recursos/iconX.png");
	}
}