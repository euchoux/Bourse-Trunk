package ci.bourse.renouv.rest;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.exception.MetierException;
import ci.bourse.renouv.facade.UtilisateurFacade;

/**
 * La ressource REST permettant de gérer l'authentification de l'utilisateur.
 * (Premier niveau de sécurité).
 * 
 * @author euchoux
 */
@Component
@Path("/security")
public class AuthentificationResource {

	private static final Logger LOGGER = Logger.getLogger(AuthentificationResource.class);

	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CHARSET_UTF8_PROPERTY = "; charset=" + CHARSET_UTF8;

	@Autowired
	private UtilisateurFacade utilisateurFacade;

	public AuthentificationResource() {
	}

	/**
	 * Le service REST permettant de vérifier l'authentification de
	 * l'utilisateur. Si l'authentification vautre, une reponse UNAUTHORIZED est
	 * renvoyée Sinon Une reponse 200 OK est retournée avec quelques infos de
	 * l'utilisateur et un jeton à renvoyer lors des prochaines requêtes.
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	@POST
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(@FormParam("login") final String login,
			@FormParam("password") final String password) {

		try {

			Validate.notBlank(login);
			Validate.notBlank(password);

			// Authenticate the user using the credentials provided
			authenticate(login, password);

			// Issue a token for the user
			final String token = issueToken(login);

			// Return the token on the response
			return Response.ok(token).build();

		} catch (final Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
		}
	}

	/**
	 * Gestion du contrôle du login/pwd.
	 * 
	 * @param login
	 * @param password
	 * @throws MetierException
	 */
	private void authenticate(final String login, final String password) throws MetierException {
		// TODO: Retourner l'utilisateur si authentifcation ok.
		utilisateurFacade.verifierLoginMdp(login, password);
	}

	/**
	 * Génération et stockage du tocken d'authentification.
	 * 
	 * @param username
	 * @return
	 */
	private String issueToken(final String username) {

		String token = "";
		try {
			token = JWT.create().withIssuer(BourseConstant.ISSUER_JETON)
					.sign(Algorithm.HMAC256(BourseConstant.CLE_JETON));
			LOGGER.debug("Jeton correctement créé");
			LOGGER.debug("----- Debut stockage en session");

			// TODO: EBO - Implémenter stockage en session

			LOGGER.debug("----- Fin stockage en session");

		} catch (final JWTCreationException | IllegalArgumentException | UnsupportedEncodingException exception) {
			LOGGER.error("Erreur de génération du token.");
		}

		return token;
	}
}
