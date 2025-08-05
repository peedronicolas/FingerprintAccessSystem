package Persistencia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String fechaUltimoAcceso;
	private String foto = "src/recursos/user.png";
	private String idHuella;

	public Usuario(String nombre, String apellidos, String fechaNacimiento, String foto, String idHuella) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.foto = foto;
		this.idHuella = idHuella;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
		this.fechaUltimoAcceso = dtf.format(LocalDateTime.now());
	}

	public Usuario(String nombre, String apellidos, String fechaNacimiento, String idHuella) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.idHuella = idHuella;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
		this.fechaUltimoAcceso = dtf.format(LocalDateTime.now());
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getFoto() {
		return foto;
	}

	public String getIdHuella() {
		return idHuella;
	}

	public String getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(String fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	@Override
	public String toString() {
		return nombre + "; " + apellidos + "; " + fechaNacimiento + "; " + fechaUltimoAcceso + "; " + foto + "; "
				+ idHuella;
	}
}
