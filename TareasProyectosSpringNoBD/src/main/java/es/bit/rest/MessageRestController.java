package es.bit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.bit.models.StatusMessage;


@RestController
public class MessageRestController {
	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value="/message/{mid}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public StatusMessage message(@PathVariable int mid) {// REST Endpoint.

		StatusMessage msg = new StatusMessage(mid,"Hello");		
		return msg;
	}

	@RequestMapping(value = "/messages", method = RequestMethod.POST)
	public ResponseEntity<StatusMessage> updateMessage(@RequestBody StatusMessage msg) {

		System.out.println("Entra:" + msg);

		if (msg != null) {
			msg.setMessage("ECHO " + msg.getMessage());
		}

		return new ResponseEntity<StatusMessage>(msg, HttpStatus.OK);
	}
}
