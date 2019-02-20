package es.bit.models;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.bit.persistence.ProyectosManager;

@XmlRootElement
public class Tarea {
	@JsonProperty("tid")
	private long id;
	
	
	@JsonProperty("desc")
	private String nombre;
	
	
	private double duracion;
	
	@JsonIgnore
	private Proyecto proyecto;
	
	@JsonProperty("proyecto")
	private long pid;
	
	@JsonIgnore
	private Usuario responsable= new Usuario(1, "", "", "","");
	
	public Tarea() {
		
	}

	public Tarea(int id, String nombre, double duracion, Proyecto proyecto, Usuario responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.proyecto = proyecto;
		this.responsable = responsable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Usuario getResponsable() {
		return responsable;
	}

	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}

	public long getPid() {
		this.pid=this.proyecto.getPid();
		return pid;
	}

	public void setPid(int pid) throws Exception{
		this.proyecto=ProyectosManager.getInstance().getProyecto(pid);
		this.pid = pid;
	}
		

}
