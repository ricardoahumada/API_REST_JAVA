package es.bit.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.bit.models.StatusMessage;
import es.bit.models.Usuario;
import es.bit.persistence.UsuariosManager;


@RestController
@RequestMapping("/usuarios")
public class UserRestController {
	private static Logger logger = Logger.getLogger("UserRestController");
	
	@Autowired
	private UsuariosManager usuariosManager;
	
	@RequestMapping(
		value="", 
		produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
		method = RequestMethod.GET
	)
	public ResponseEntity<?> getUsers() {

		List<Usuario> usuarios;
		try {
			//usuarios = UsuariosManager.getInstance().getUsuarios();
			usuarios = usuariosManager.getUsuarios();
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);			
		} catch (Exception e) {
			logger.severe("!!!!Exception:" + e.getMessage());
			return new ResponseEntity<StatusMessage>(new StatusMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Ooopsss..."), HttpStatus.INTERNAL_SERVER_ERROR);			
		}

	}
	
}
