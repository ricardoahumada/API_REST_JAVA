package es.bit;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;
import static org.junit.Assert.*;

public class RESTClientTest {

	@Test
	public void getTest() {

		try {
			String response = RESTClient.getFromAPI("http://localhost:8080/TareasProyectosJersey/rest/usuarios");
			assertNotNull(response);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
	
	@Test
	public void postTest() {

		try {
			String body="{\"uid\":0,\"nombre\":\"Luis\",\"email\":\"l@l.com\",\"foto\":\"l.jpg\"}";
			String response = RESTClient.postToAPI("http://localhost:8080/TareasProyectosJersey/rest/usuarios",body);
			assertNotNull(response);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
