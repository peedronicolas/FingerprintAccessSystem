package Arduino;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;
import com.fazecast.jSerialComm.SerialPort;

import Vistas.PanelInicio;

public class Arduino {

	// ATRIBUTOS:
	private SerialPort serialPort;
	private PanelInicio panelInicio;
	private JTextArea textAreaArduinoInicio;
	private JTextArea textAreaArduinoRegistro;

	// CONSTRUCTOR:
	public Arduino(PanelInicio panelInicio, JTextArea textAreaArduinoInicio, JTextArea textAreaArduinoRegistro) {
		this.panelInicio = panelInicio;
		this.textAreaArduinoInicio = textAreaArduinoInicio;
		this.textAreaArduinoRegistro = textAreaArduinoRegistro;
	}

	// METODOS:
	public void lanzarArduino() {

		serialPort = SerialPort.getCommPort("COM3");
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
		if (!serialPort.openPort())
			System.out.println("No es posible conectarse al Arduino.");

		Thread thread = new Thread() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(serialPort.getInputStream());
				String previusLine = "";
				while (scanner.hasNextLine()) {
					try {

						String line = scanner.nextLine();
						if (!line.equals(previusLine))
							procesLine(line);
						previusLine = line;

					} catch (Exception e) {
					}
				}
				scanner.close();
			}
		};
		thread.start();
	}

	public void sendData(String data) {
		serialPort.writeBytes(data.getBytes(), data.length());
	}

	public void procesLine(String line) {

		textAreaArduinoInicio.append(" " + line + "\n");
		textAreaArduinoRegistro.append(" " + line + "\n");

		if (line.startsWith("Found ID")) {
			Pattern pat = Pattern.compile("#([0-9]*)");
			Matcher mat = pat.matcher(line);
			mat.find();
			panelInicio.showUser(mat.group(1));
		}

		if (line.startsWith("Did not find a match")) {
			panelInicio.showErrorUser();
		}
	}
}