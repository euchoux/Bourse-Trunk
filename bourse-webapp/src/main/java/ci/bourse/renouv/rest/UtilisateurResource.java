package ci.bourse.renouv.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.dto.SexeDto;
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
	public Response creerUtilisateur(@QueryParam("nom") final String nom, @QueryParam("prenoms") final String prenoms,
			@QueryParam("dateNaissance") final String dateNaissance, @QueryParam("login") final String login,
			@QueryParam("mdp") final String mdp, @QueryParam("telephone") final String telephone,
			@QueryParam("paysId") final Integer paysId, @QueryParam("sexeId") final Integer sexeId,
			@QueryParam("codeProfil") final String codeProfil) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("creation utilisateur : " + prenoms + " " + nom);
		}
		
		// Vérification des information envoyées.
		Validate.notBlank(nom);
		Validate.notBlank(prenoms);
		Validate.notBlank(dateNaissance);
		Validate.notBlank(login);
		Validate.notBlank(login);
		Validate.notBlank(mdp);
		Validate.notBlank(telephone);
		Validate.notNull(paysId);
		Validate.notNull(sexeId);
		Validate.notBlank(codeProfil);
		
		final PaysDto pays = nomenclatureFacade.trouverPaysParId(paysId);
		if (pays == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("L'identifiant du pays est inconnu.").build();
		}

		final SexeDto sexe = nomenclatureFacade.trouverSexeParId(sexeId);
		if (sexe == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("L'identifiant du sexe est inconnu.").build();
		}

		final ProfilDto profil = nomenclatureFacade.trouverProfilParCode(codeProfil);
		if (profil == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Le code du profil est inconnu.").build();
		}

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

		utilisateur.setPays(pays);
		utilisateur.setProfil(profil);
		utilisateur.setSexe(sexe);
		
		try {
			utilisateurFacade.creerUtilisateur(utilisateur);
		} catch (final MetierException e) {
			return Response.status(Response.Status.CONFLICT).entity("Un utilisateur avec le même login existe déjà.")
					.build();
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fin creation utilisateur : " + prenoms + " " + nom);
		}

		return Response.ok("L'utilisateur a été correctement créé.").build();
	}
}
