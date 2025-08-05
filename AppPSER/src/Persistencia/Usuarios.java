package Persistencia;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

import com.google.gson.Gson;

public class Usuarios {

	String rutaFile = "./users";
	private LinkedList<Usuario> users;
	private HashSet<Integer> IDs_HuellasOcupadas;

	public Usuarios() {
		users = new LinkedList<>();
		IDs_HuellasOcupadas = new HashSet<>();

		try {

			File archivo = new File(rutaFile);
			if (archivo.exists()) {

				BufferedReader br = new BufferedReader(new FileReader(archivo));

				String user_line;
				while ((user_line = br.readLine()) != null) {
					Usuario user = new Gson().fromJson(user_line, Usuario.class);
					users.add(user);
					IDs_HuellasOcupadas.add(Integer.parseInt(user.getIdHuella()));
				}

				br.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LinkedList<Usuario> getUsers() {
		return users;
	}
	
	public Usuario getUser(String idHuella) {
		for (Usuario user : users)
			if(user.getIdHuella().equals(idHuella))
				return user;
		return null;
	}

	public void addUser(Usuario user) {
		IDs_HuellasOcupadas.add(Integer.parseInt(user.getIdHuella()));
		users.add(user);
	}

	public void removeUser(String IDHuellaUser) {
		IDs_HuellasOcupadas.remove(Integer.parseInt(IDHuellaUser));
		for (int i = 0; i < users.size(); i++) {
			Usuario user = users.get(i);
			if (user.getIdHuella().equals(IDHuellaUser))
				users.remove(user);
		}
	}

	public int getIDHuellaLibre() {
		for (int i = 1; i <= 9999; i++)
			if (!IDs_HuellasOcupadas.contains(i))
				return i;
		return -1;
	}

	public HashSet<Integer> getIDs_HuellasOcupadas() {
		return IDs_HuellasOcupadas;
	}

	public void saveUsers() {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(rutaFile), false));

			for (Usuario user : users)
				bw.write(new Gson().toJson(user) + "\n");

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return users.toString();
	}
}
