package es.bit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
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
			String body = "{\"uid\":0,\"nombre\":\"Luis\",\"email\":\"l@l.com\",\"foto\":\"l.jpg\"}";
			String response = RESTClient.postToAPI("http://localhost:8080/TareasProyectosJersey/rest/usuarios", body);
			assertNotNull(response);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void getTestWithSchemaValidation() {

		try {
			String response = RESTClient.getFromAPI("http://localhost:8080/TareasProyectosJersey/rest/usuarios/2");
			
			JSONObject jsonSchema = new JSONObject(
					new JSONTokener(RESTClientTest.class.getResourceAsStream("/usuario_schema.json")));
			JSONObject jsonSubject = new JSONObject(new JSONTokener(response));

			Schema schema = SchemaLoader.load(jsonSchema);
			schema.validate(jsonSubject);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}
