package es.bit.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "responsable" })
@XmlRootElement
public class Proyecto {

	private long pid;
	
	private String titulo;
	
	@JsonIgnore
	private Date fecha_inicio;
	
	@JsonIgnore
	private Date fecha_fin;
	
	@JsonIgnore
	private Usuario responsable= new Usuario(1, "", "", "", "");
	
	public Proyecto() {
	}

	public Proyecto(long pid, String titulo, Date fecha_inicio, Date fecha_fin, Usuario responsable) {
		this.pid = pid;
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.responsable = responsable;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
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
