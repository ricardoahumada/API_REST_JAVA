package es.bit.models;

import java.util.Date;

public class Proyecto {

	public int pid;
	public String titulo;
	public Date fecha_inicio;
	public Date fecha_fin;
	public Usuario responsable;
	
	public Proyecto() {
	}

	public Proyecto(int pid, String titulo, Date fecha_inicio, Date fecha_fin, Usuario responsable) {
		this.pid = pid;
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.responsable = responsable;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	
	 
}
