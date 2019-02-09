package es.bit.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.bit.models.Proyecto;
import es.bit.models.StatusMessage;
import es.bit.models.Tarea;
import es.bit.models.Usuario;
import es.bit.persistence.TareasManager;
import es.bit.persistence.UsuariosManager;

@Path("/tareas")
public class TareasService {
	private static Logger logger = Logger.getLogger("TareasService");

	private static List<Tarea> tareas;
	static {
		tareas = new ArrayList();
		tareas.add(new Tarea(1, "Crear site", 20, new Proyecto(), new Usuario()));
		tareas.add(new Tarea(2, "Lanzar pruebas pre", 10, new Proyecto(), new Usuario()));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTareas() {

		try {
			List<Tarea> tareas = TareasManager.getInstance().getTareas();

			return Response.
					status(Response.Status.OK).
					entity(tareas).
					build();
			
		} catch (Exception e) {
			logger.severe("!!!!Exception:" + e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new StatusMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Ooopsss..."))
					.build();
		}
	}
	
	@GET()
	@Path("/{tid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("tid") int tid) {

		Tarea tarea;
		try {
			tarea = TareasManager.getInstance().getTarea(tid);
			return Response.status((tarea != null) ? Response.Status.OK : Response.Status.NOT_FOUND)
					.entity((tarea != null) ? tarea
							: new StatusMessage(Response.Status.NOT_FOUND.getStatusCode(), "No encontrado"))
					.build();
		} catch (Exception e) {
			logger.severe("!!!!Exception:" + e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new StatusMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Ooopsss..."))
					.build();
		}

	}

	
	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTarea(Tarea nuevo) {

		try {
			int nid = TareasManager.getInstance().createTarea(nuevo);
			nuevo.setId(nid);
			return Response.status(Response.Status.CREATED).entity(nuevo).build();
		} catch (Exception e) {
			logger.severe("!!!!Exception:" + e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(new StatusMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "Ooopsss..."))
					.build();
		}

	}
}
