package ci.bourse.renouv.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.exception.MetierException;
import ci.bourse.renouv.facade.NomenclatureFacade;
import ci.bourse.renouv.facade.UtilisateurFacade;
import ci.bourse.renouv.utils.DateUtils;
import ci.bourse.renouv.utils.PasswordUtils;

/**
 * La ressource REST de gestion des transactions concernant l'utilisateur.
 * 
 * @author euchoux
 */
@Component
@Path("/utilisateurs")
public class UtilisateurResource {

	private static final Logger LOGGER = Logger.getLogger(UtilisateurResource.class);

	public static final String CHARSET_UTF8 = "UTF-8";
	public static final String CHARSET_UTF8_PROPERTY = "; charset=" + CHARSET_UTF8;

	@Autowired
	private UtilisateurFacade utilisateurFacade;

	@Autowired
	private NomenclatureFacade nomenclatureFacade;

	public UtilisateurResource() {
	}

	@POST
	@Path("/creer")
	@Produces(MediaType.APPLICATION_JSON)
	public String creerUtilisateur(@QueryParam("nom") final String nom, @QueryParam("prenoms") final String prenoms,
			@QueryParam("dateNaissance") final String dateNaissance, @QueryParam("login") final String login,
			@QueryParam("mdp") final String mdp, @QueryParam("telephone") final String telephone,
			@QueryParam("paysId") final int paysId, @QueryParam("sexeId") final int sexeId) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("creation utilisateur : " + prenoms + " " + nom);
		}
		String response;

		final UtilisateurDto utilisateur = new UtilisateurDto();
		utilisateur.setLogin(login);
		utilisateur.setNom(nom);
		utilisateur.setPrenoms(prenoms);
		utilisateur.setTelephone(telephone);
		utilisateur.setPassword(PasswordUtils.hacherMessageSHA256(mdp));
		try {
			utilisateur.setDateNaissance(DateUtils.fromString(dateNaissance));
		} catch (final MetierException e) {
			e.printStackTrace();
		}
		utilisateur.setPays(nomenclatureFacade.trouverPaysParId(paysId));
		utilisateur.setSexe(nomenclatureFacade.trouverSexeParId(sexeId));
		try {
			utilisateurFacade.creerUtilisateur(utilisateur);
			response = "L'utilisateur a été correctement créé.";
		} catch (final MetierException e) {
			response = "Un utilisateur avec le même login existe déjà.";
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fin creation utilisateur : " + prenoms + " " + nom);
			LOGGER.debug(response);
		}

		return response;
	}
}
