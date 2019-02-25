package es.bit.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.bit.models.Proyecto;

public class ProyectosManager {
	private static ProyectosManager instancia = null;
	private static List<Proyecto> proyectos;

	public static ProyectosManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new ProyectosManager();

		return instancia;
	}

	private ProyectosManager() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		proyectos = new ArrayList<>();
		UsuariosManager um = UsuariosManager.getInstance();
		proyectos.add(new Proyecto(1, "App gestión de cuentas", sdf.parse("23-12-2018"), sdf.parse("02-10-2019"), um.getUsuario(1)));
		proyectos.add(new Proyecto(2, "Web incendios", sdf.parse("23-12-2018"), sdf.parse("02-10-2019"), um.getUsuario(1)));
		proyectos.add(new Proyecto(3, "Infraestructura IoC", sdf.parse("23-12-2018"), sdf.parse("02-10-2019"), um.getUsuario(1)));
	}

	public long createProyecto(Proyecto newP) throws Exception {
		long id = new Date().getTime();
		newP.setPid(id);
		proyectos.add(newP);
		return id;
	}

	public List<Proyecto> getProyectos() throws Exception {
		return proyectos;
	}

	public Proyecto getProyecto(int id) throws Exception {
		Proyecto recU = null;
		for (Proyecto proyecto : proyectos) {
			if (id == proyecto.getPid()) {
				recU = proyecto;
				break;
			}
		}
		return recU;
	}

	public boolean updateProyecto(Proyecto aP) throws Exception {
		Proyecto recU = null;
		for (Proyecto proyecto : proyectos) {
			if (aP.getPid() == proyecto.getPid()) {
				proyectos.remove(proyecto);
				proyectos.add(aP);
				recU = aP;
				break;
			}
		}

		return (recU != null);
	}

	public boolean deleteProyecto(Proyecto aP) throws Exception {
		Proyecto recU = null;
		for (Proyecto proyecto : proyectos) {
			if (aP.getPid() == proyecto.getPid()) {
				proyectos.remove(proyecto);
				recU = aP;
				break;
			}
		}

		return (recU != null);
	}

}
