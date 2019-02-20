package es.bit.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import es.bit.models.Tarea;

public class TareasManager {
	private static TareasManager instancia = null;
	private static SessionFactory sf = null;
	private static List<Tarea> tareas;

	public static TareasManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new TareasManager();

		return instancia;
	}

	private TareasManager() throws Exception {
		tareas = new ArrayList<>();
		UsuariosManager um = UsuariosManager.getInstance();
		ProyectosManager pm = ProyectosManager.getInstance();
		
		tareas.add(new Tarea(1, "Primera tarea", 1, pm.getProyecto(1), um.getUsuario(1)));
		tareas.add(new Tarea(2, "Segunda tarea", 2, pm.getProyecto(1), um.getUsuario(1)));
		tareas.add(new Tarea(3, "Tercera tarea", 3, pm.getProyecto(1), um.getUsuario(2)));
		tareas.add(new Tarea(4, "Cuarta tarea", 4, pm.getProyecto(1), um.getUsuario(2)));
		tareas.add(new Tarea(5, "Quinta tarea", 5, pm.getProyecto(1), um.getUsuario(3)));
		tareas.add(new Tarea(6, "Sexta tarea", 6, pm.getProyecto(1), um.getUsuario(3)));
	}
	
	public long createTarea(Tarea newT) throws Exception {
	    long id = new Date().getTime();
	    newT.setId(id);
	    tareas.add(newT);
	    return id;
	}

	public List<Tarea> getTareas() throws Exception {
	    return tareas;
	}

	public Tarea getTarea(int id) throws Exception {
	    Tarea recU = null;
	    for (Tarea tarea : tareas) {
	        if (id == tarea.getId()) {
	            recU = tarea;
	            break;
	        }
	    }
	    return recU;
	}

	public boolean updateTarea(Tarea aT) throws Exception {
	    Tarea recU = null;
	    for (Tarea tarea : tareas) {
	        if (aT.getId() == tarea.getId()) {
	            tareas.remove(tarea);
	            tareas.add(aT);
	            recU = aT;
	            break;
	        }
	    }

	    return (recU != null);
	}

	public boolean deleteTarea(Tarea aT) throws Exception {
	    Tarea recU = null;
	    for (Tarea tarea : tareas) {
	        if (aT.getId() == tarea.getId()) {
	            tareas.remove(tarea);
	            recU = aT;
	            break;
	        }
	    }

	    return (recU != null);
	}

}
