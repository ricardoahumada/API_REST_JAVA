package es.bit;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class UsuarioJSONSchemaTest {

	@Test
	public void testInvalidusuario() {

		JSONObject jsonSchema = new JSONObject(
				new JSONTokener(UsuarioJSONSchemaTest.class.getResourceAsStream("/usuario_schema.json")));
		JSONObject jsonSubject = new JSONObject(
				new JSONTokener(UsuarioJSONSchemaTest.class.getResourceAsStream("/usuario_invalid.json")));

		Schema schema = SchemaLoader.load(jsonSchema);
		schema.validate(jsonSubject);
	}

	@Test
	public void testValidusuario() {

		JSONObject jsonSchema = new JSONObject(
				new JSONTokener(UsuarioJSONSchemaTest.class.getResourceAsStream("/usuario_schema.json")));
		JSONObject jsonSubject = new JSONObject(
				new JSONTokener(UsuarioJSONSchemaTest.class.getResourceAsStream("/usuario_valid.json")));

		Schema schema = SchemaLoader.load(jsonSchema);
		schema.validate(jsonSubject);
	}
}