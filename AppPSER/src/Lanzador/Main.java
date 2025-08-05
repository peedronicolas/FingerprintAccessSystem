package Lanzador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Vistas.PanelInicio;
import Vistas.PanelRegistro;
import Vistas.PanelUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import Arduino.Arduino;
import Persistencia.Usuarios;
import java.awt.BorderLayout;

public class Main extends JFrame {

	// ATRIBUTOS:
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private PanelInicio panelInicio;
	private PanelRegistro panelRegistro;

	private JTextArea textAreaArduinoInicio = new JTextArea();
	private JTextArea textAreaArduinoRegistro = new JTextArea();

	private Arduino arduino;

	// METODOS:
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Usuarios usuarios = new Usuarios();

					Main frame = new Main(usuarios);
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							usuarios.saveUsers();
							System.out.println("FIN APLICACION");
						}
					});

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main(Usuarios usuarios) {

		// Propiedades de la APP
		setTitle("App de Acceso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		textAreaArduinoInicio.setEditable(false);
		textAreaArduinoInicio.setLineWrap(true);
		textAreaArduinoRegistro.setEditable(false);
		textAreaArduinoRegistro.setLineWrap(true);

		// Creamos los paneles y definimos el principal
		panelInicio = new PanelInicio(usuarios, textAreaArduinoInicio);

		arduino = new Arduino(panelInicio, textAreaArduinoInicio, textAreaArduinoRegistro);

		panelRegistro = new PanelRegistro(usuarios, arduino, textAreaArduinoRegistro);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelInicio);
		setContentPane(contentPane);

		// Definimos el MENÚ
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Inicio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(panelInicio);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Usuarios");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(new PanelUsuarios(usuarios, arduino));
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(panelRegistro);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmNewMenuItem_2);

		// Lanzamos el ARDUINO
		arduino.lanzarArduino();
	}
}