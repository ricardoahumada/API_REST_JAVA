package es.bit.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.bit.models.Usuario;

public class UsuariosManager {
	private static UsuariosManager instancia = null;
	private static List<Usuario> usuarios;

	public static UsuariosManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new UsuariosManager();

		return instancia;
	}

	private UsuariosManager() throws Exception {

		usuarios = new ArrayList<>();
		usuarios.add(new Usuario(1, "Ricardo", "r@r.com", "rcrd", "ric.jpg"));
		usuarios.add(new Usuario(2, "Ana", "a@a.com", "ncm", "ana.jpg"));
		usuarios.add(new Usuario(3, "Petra", "p@p.com", "ppc", "petra.jpg"));
	}

	public long createUsuario(Usuario newU) throws Exception {
		long id = new Date().getTime();
		newU.setUid(id);
		usuarios.add(newU);
		return id;
	}

	public List<Usuario> getUsuarios() throws Exception {
		return usuarios;
	}

	public Usuario getUsuario(int id) throws Exception {
		Usuario recU = null;
		for (Usuario usuario : usuarios) {
			if (id == usuario.getUid()) {
				recU = usuario;
				break;
			}
		}
		return recU;
	}

	public boolean updateUsuario(Usuario aU) throws Exception {
		Usuario recU = null;
		for (Usuario usuario : usuarios) {
			if (aU.getUid() == usuario.getUid()) {
				usuarios.remove(usuario);
				usuarios.add(aU);
				recU = aU;
				break;
			}
		}

		return (recU != null);
	}

	public boolean deleteUsuario(Usuario aU) throws Exception {
		Usuario recU = null;
		for (Usuario usuario : usuarios) {
			if (aU.getUid() == usuario.getUid()) {
				usuarios.remove(usuario);
				recU = aU;
				break;
			}
		}

		return (recU != null);
	}

	public Usuario authUsuario(String email, String password) {
		Usuario recU = null;
		for (Usuario usuario : usuarios) {
			if(usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {								
				recU=usuario;
				break;
			}
		}
				
		return recU;
	}

}
