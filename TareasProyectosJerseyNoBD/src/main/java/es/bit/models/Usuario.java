package es.bit.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {

	private long uid;

	private String nombre;
	
	private String email;
	
	private String password;
	
	private String foto;
	
	public Usuario() {
	}
	
	
	public Usuario(int uid, String nombre, String email, String pass, String foto) {
		this.uid = uid;
		this.nombre = nombre;
		this.email = email;
		this.password=pass;
		this.foto = foto;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getPassword() {		
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}	
	
	
}
