package ci.bourse.renouv.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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

	@Autowired
	private UtilisateurFacade utilisateurFacade;

	@Autowired
	private NomenclatureFacade nomenclatureFacade;

	public UtilisateurResource() {
	}

	@POST
	@Path("/{userId}/bloquer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response bloquerDebloquerUtilisateur(@PathParam("userId") final Integer userId,
			@QueryParam("bloquer") final boolean bloquer) {

		try {
			utilisateurFacade.bloquerDebloquerUtilisateur(userId, bloquer);
		} catch (final MetierException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("L'identifant fourni n'est assicié à aucun utilisateur.").build();
		}

		return Response.ok("L'utilisateur a été correctement mis à jour.").build();
	}

	@DELETE
	@Path("/{userId}/supprimer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response supprimerUtilisateur(@PathParam("userId") final Integer userId) {

		try {
			utilisateurFacade.supprimerUtilisateur(userId);
		} catch (final MetierException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("L'identifant fourni n'est assicié à aucun utilisateur.").build();
		}

		return Response.ok("L'utilisateur a été correctement supprimé.").build();
	}

	@POST
	@Path("/creer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response creerUtilisateur(final String json) throws JSONException {

		final JSONObject jsonObj = new JSONObject(json);

		final String nom = jsonObj.getString("nom");
		final String prenoms = jsonObj.getString("prenoms");
		final String dateNaissance = jsonObj.getString("dateNaissance");
		final String login = jsonObj.getString("login");
		final String password = jsonObj.getString("password");
		final String telephone = jsonObj.getString("telephone");
		final Integer paysId = jsonObj.getInt("paysId");
		final Integer sexeId = jsonObj.getInt("sexeId");
		final String codeProfil = jsonObj.getString("codeProfil");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("creation utilisateur : " + prenoms + " " + nom);
		}

		// Vérification des information envoyées.
		validerInformation(nom, prenoms, dateNaissance, login, password, telephone,
				paysId, sexeId, codeProfil);

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

		final UtilisateurDto utilisateur = initialiserUtilisateurDto(nom, prenoms,
				dateNaissance, login, password, telephone,
				paysId, sexeId, codeProfil, pays, profil, sexe);

		try {
			utilisateur.setDateNaissance(DateUtils.fromString(dateNaissance, DateUtils.CLASSIQUE_FORMAT));
		} catch (final MetierException e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
		}

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

	@POST
	@Path("/{userId}/modifier")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modifierUtilisateur(@PathParam("userId") final Integer userId,
			final String json) throws JSONException {

		final JSONObject jsonObj = new JSONObject(json);

		final String nom = jsonObj.getString("nom");
		final String prenoms = jsonObj.getString("prenoms");
		final String dateNaissance = jsonObj.getString("dateNaissance");
		final String login = jsonObj.getString("login");
		final String password = jsonObj.getString("password");
		final String telephone = jsonObj.getString("telephone");
		final Integer paysId = jsonObj.getInt("paysId");
		final Integer sexeId = jsonObj.getInt("sexeId");
		final String codeProfil = jsonObj.getString("codeProfil");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("modification utilisateur : " + prenoms + " " + nom);
		}

		// Vérification des information envoyées.
		validerInformation(nom, prenoms, dateNaissance, login, password, telephone,
				paysId, sexeId, codeProfil);
		Validate.notNull(userId);

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

		final UtilisateurDto utilisateur = initialiserUtilisateurDto(nom, prenoms,
				dateNaissance, login, password, telephone,
				paysId, sexeId, codeProfil, pays, profil, sexe);

		utilisateur.setId(userId);

		try {
			utilisateur.setDateNaissance(DateUtils.fromString(dateNaissance, DateUtils.CLASSIQUE_FORMAT));
		} catch (final MetierException e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
		}

		utilisateurFacade.modifierUtilisateur(utilisateur);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Fin modification utilisateur : " + prenoms + " " + nom);
		}

		return Response.ok("L'utilisateur a été correctement modifié.").build();
	}

	private UtilisateurDto initialiserUtilisateurDto(final String nom, final String prenoms, final String dateNaissance,
			final String login, final String mdp, final String telephone, final Integer paysId, final Integer sexeId,
			final String codeProfil, final PaysDto pays, final ProfilDto profil, final SexeDto sexe) {

		final UtilisateurDto utilisateur = new UtilisateurDto();
		utilisateur.setLogin(login);
		utilisateur.setNom(nom);
		utilisateur.setPrenoms(prenoms);
		utilisateur.setTelephone(telephone);
		utilisateur.setPassword(PasswordUtils.hacherMessageSHA256(login, mdp));

		utilisateur.setPays(pays);
		utilisateur.setProfil(profil);
		utilisateur.setSexe(sexe);
		return utilisateur;
	}

	private void validerInformation(final String nom, final String prenoms, final String dateNaissance,
			final String login, final String mdp, final String telephone, final Integer paysId, final Integer sexeId,
			final String codeProfil) {
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
	}
}
