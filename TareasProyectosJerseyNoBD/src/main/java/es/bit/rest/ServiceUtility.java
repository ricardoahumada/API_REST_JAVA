package es.bit.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.JsonWebKeySet;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

public class ServiceUtility {
	private static Logger logger = Logger.getLogger("JSONService");
	static List<JsonWebKey> jwkList = null;

	static {
		logger.info("Inside static initializer...");
		jwkList = new LinkedList<JsonWebKey>();
		// Creating three keys, will use one now
		for (int kid = 1; kid <= 3; kid++) {
			JsonWebKey jwk = null;
			try {
				jwk = RsaJwkGenerator.generateJwk(2048);
				logger.info("PUBLIC KEY (" + kid + "): " + jwk.toJson(JsonWebKey.OutputControlLevel.PUBLIC_ONLY));
			} catch (JoseException e) {
				e.printStackTrace();
			}
			jwk.setKeyId(String.valueOf(kid));
			jwkList.add(jwk);
		}

	}

	/* AUX */
	public static String getUserEmailFromToken(String token) {
		if (token == null)
			return null;

		String userEmail = null;

		try {

			JsonWebKeySet jwks = new JsonWebKeySet(jwkList);
			JsonWebKey jwk = jwks.findJsonWebKey("1", null, null, null);
			logger.log(Level.INFO, "JWK (1) ===> " + jwk.toJson());

			// Validate Token's authenticity and check claims
			JwtConsumer jwtConsumer = new JwtConsumerBuilder().setRequireExpirationTime()
					.setAllowedClockSkewInSeconds(30).setRequireSubject().setExpectedIssuer("netmind.com")
					.setVerificationKey(jwk.getKey()).build();

			// Validate the JWT and process it to the Claims
			JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
			logger.log(Level.INFO, "JWT validation succeeded! " + jwtClaims.getSubject().toString());
			userEmail = jwtClaims.getSubject().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userEmail;
	}

}