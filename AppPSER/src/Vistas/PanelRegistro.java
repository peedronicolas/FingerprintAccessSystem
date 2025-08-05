package Vistas;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Arduino.Arduino;
import Persistencia.Usuario;
import Persistencia.Usuarios;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelRegistro extends JPanel {

	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldFNacimiento;
	private JTextField textFieldHuella;
	private JTextField textFieldFoto;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File archivo;

	/**
	 * Create the panel.
	 */
	public PanelRegistro(Usuarios usuarios, Arduino arduino, JTextArea textAreaArduino) {

		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_norte = new JPanel();
		add(panel_norte, BorderLayout.NORTH);
		panel_norte.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JLabel lblNewLabel = new JLabel("Registrar nuevo usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 18));
		panel_norte.add(lblNewLabel);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 25, 0, 25, 10, 0, 25, 0 };
		gbl_panel.rowHeights = new int[] { 25, 0, 0, 0, 0, 0, 20, 0, 80, 0, 0, 17, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 1;
		panel.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(25);

		JLabel lblNewLabel_2 = new JLabel("Apellidos: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldApellidos = new JTextField();
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.gridwidth = 3;
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellidos.gridx = 2;
		gbc_textFieldApellidos.gridy = 2;
		panel.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(25);

		JLabel lblNewLabel_3 = new JLabel("F. Nacimiento: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textFieldFNacimiento = new JTextField();
		GridBagConstraints gbc_textFieldFNacimiento = new GridBagConstraints();
		gbc_textFieldFNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFNacimiento.gridx = 2;
		gbc_textFieldFNacimiento.gridy = 3;
		panel.add(textFieldFNacimiento, gbc_textFieldFNacimiento);
		textFieldFNacimiento.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("dd/mm/yyyy");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		JLabel lblNewLabel_4 = new JLabel("ID Huella: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textFieldHuella = new JTextField();
		textFieldHuella.setEditable(false);
		GridBagConstraints gbc_textFieldHuella = new GridBagConstraints();
		gbc_textFieldHuella.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHuella.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHuella.gridx = 2;
		gbc_textFieldHuella.gridy = 4;
		panel.add(textFieldHuella, gbc_textFieldHuella);
		textFieldHuella.setColumns(12);

		JButton btnNewButton = new JButton("Registrar Huella");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idHuella = Integer.toString(usuarios.getIDHuellaLibre());
				textFieldHuella.setText(idHuella);
				arduino.sendData("1");
				arduino.sendData(idHuella);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		panel.add(btnNewButton, gbc_btnNewButton);

		JLabel lblFoto = new JLabel("Foto: ");
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.anchor = GridBagConstraints.WEST;
		gbc_lblFoto.gridx = 1;
		gbc_lblFoto.gridy = 5;
		panel.add(lblFoto, gbc_lblFoto);

		JButton btnCargarFoto = new JButton("Seleccionar Foto");
		btnCargarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Selecciona una imagen");
				if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
					archivo = new File(fileChooser.getSelectedFile().toString());
					textFieldFoto.setText(archivo.getName());
				}
			}
		});

		textFieldFoto = new JTextField();
		textFieldFoto.setEditable(false);
		GridBagConstraints gbc_textFieldFoto = new GridBagConstraints();
		gbc_textFieldFoto.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFoto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFoto.gridx = 2;
		gbc_textFieldFoto.gridy = 5;
		panel.add(textFieldFoto, gbc_textFieldFoto);
		textFieldFoto.setColumns(10);
		GridBagConstraints gbc_btnCargarFoto = new GridBagConstraints();
		gbc_btnCargarFoto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarFoto.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarFoto.gridx = 4;
		gbc_btnCargarFoto.gridy = 5;
		panel.add(btnCargarFoto, gbc_btnCargarFoto);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNombre.getText().length() == 0) {
					JOptionPane.showMessageDialog(btnRegistrar, "El campo 'nombre' es obligatorio.", "ERROR", 0);
				} else if (textFieldApellidos.getText().length() == 0) {
					JOptionPane.showMessageDialog(btnRegistrar, "El campo 'apellidos' es obligatorio.", "ERROR", 0);
				} else if (textFieldFNacimiento.getText().length() == 0) {
					JOptionPane.showMessageDialog(btnRegistrar, "El campo 'fecha de nacimiento' es obligatorio.",
							"ERROR", 0);

				} else if (textFieldHuella.getText().length() == 0) {
					JOptionPane.showMessageDialog(btnRegistrar, "El campo 'ID Huella' es obligatorio.", "ERROR", 0);
				} else {

					Usuario user;
					if (archivo != null)
						user = new Usuario(textFieldNombre.getText(), textFieldApellidos.getText(),
								textFieldFNacimiento.getText(), archivo.getAbsolutePath(), textFieldHuella.getText());
					else
						user = new Usuario(textFieldNombre.getText(), textFieldApellidos.getText(),
								textFieldFNacimiento.getText(), textFieldHuella.getText());
					usuarios.addUser(user);

					textFieldNombre.setText("");
					textFieldApellidos.setText("");
					textFieldFNacimiento.setText("");
					textFieldHuella.setText("");
					textFieldFoto.setText("");
					archivo = null;
					JOptionPane.showMessageDialog(btnRegistrar, "Usuario registrado correctamente.");
				}
			}
		});

		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistrar.gridx = 1;
		gbc_btnRegistrar.gridy = 7;
		panel.add(btnRegistrar, gbc_btnRegistrar);

		JLabel lblNewLabel_6 = new JLabel("Log:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 9;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JScrollPane scrollPane = new JScrollPane(textAreaArduino);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 10;
		panel.add(scrollPane, gbc_scrollPane);
		scrollPane.getVerticalScrollBar().addAdjustmentListener((AdjustmentListener) new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				e.getAdjustable().setValue(e.getAdjustable().getMaximum());
			}
		});
	}
}