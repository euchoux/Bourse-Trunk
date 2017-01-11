package ci.bourse.renouv.rest;

import java.sql.Timestamp;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.Validate;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dto.UtilisateurDtoLight;
import ci.bourse.renouv.facade.UtilisateurFacade;
import ci.bourse.renouv.utils.TokenUtils;

/**
 * La ressource REST permettant de gérer l'authentification de l'utilisateur.
 * (Premier niveau de sécurité).
 * 
 * @author euchoux
 */
@Component
@Path("/security")
public class AuthentificationResource {

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
	 * @throws JSONException
	 */
	@POST
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(@FormParam("login") final String login,
			@FormParam("password") final String password) throws JsonProcessingException {
		final ObjectMapper jsonMapper = new ObjectMapper();
		try {

			Validate.notBlank(login);
			Validate.notBlank(password);

			// Authenticate the user using the credentials provided
			final UtilisateurDtoLight user = utilisateurFacade.verifierLoginMdp(login, password,
					new Timestamp(new Date().getTime()));

			// Issue a token for the user
			final String token = TokenUtils.issueToken(login, user);

			// Return the token on the response
			return Response.ok(jsonMapper.writeValueAsString(user))
					.header(BourseConstant.AUTHORIZATION_PROPERTY, BourseConstant.AUTHENTICATION_SCHEME + token)
					.build();

		} catch (final Exception e) {
			return Response.status(Response.Status.FORBIDDEN).entity(jsonMapper.writeValueAsString(e.getMessage()))
					.build();
		}
	}
}
