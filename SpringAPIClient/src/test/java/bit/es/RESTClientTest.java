package bit.es;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import es.bit.models.Usuario;

public class RESTClientTest {

	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void getUserTest() {
		
		String REST_URI = "http://localhost:8080/TareasProyectosJersey/rest/usuarios/{uid}";
		
		Map<String, String> params = new HashMap();
		params.put("uid", "1");

		Usuario apiUser = restTemplate.getForObject(REST_URI, Usuario.class, params);

		System.out.println(apiUser.getNombre());
		assertNotNull(apiUser);
	}
	
}
