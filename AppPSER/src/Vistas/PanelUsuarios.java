package Vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Arduino.Arduino;
import Persistencia.Usuario;
import Persistencia.Usuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelUsuarios extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	/**
	 * Create the panel.
	 */
	public PanelUsuarios(Usuarios usuarios, Arduino arduino) {

		setLayout(new BorderLayout(0, 0));

		JPanel panel_norte = new JPanel();
		add(panel_norte, BorderLayout.NORTH);
		panel_norte.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JLabel lblUsuarios = new JLabel("Usuarios:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuarios.setFont(new Font("Arial", Font.ITALIC, 18));
		panel_norte.add(lblUsuarios);

		JPanel panel_sur = new JPanel();
		add(panel_sur, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					String idUser = (String) table.getValueAt(row, 3);
					usuarios.removeUser(idUser);
					model.removeRow(row);
					arduino.sendData("2");
					arduino.sendData(idUser);
					JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
				} else
					JOptionPane.showMessageDialog(btnNewButton, "No has seleccionado el usuario a eliminar.", "ERROR",
							0);
			}
		});
		panel_sur.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("F. Nacimiento");
		model.addColumn("ID Huella");
		model.addColumn("F. Ult. Acceso");
		table.setModel(model);
		for (Usuario user : usuarios.getUsers()) {
			Object[] fila = { user.getNombre(), user.getApellidos(), user.getFechaNacimiento(), user.getIdHuella(),
					user.getFechaUltimoAcceso() };
			model.addRow(fila);
		}
	}
}