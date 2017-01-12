package ci.bourse.renouv.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * La ressource REST permettant de gérer les transaction avec l'application
 * mobile.
 * 
 * @author euchoux
 */
@Component
@Path("/mobile")
public class MobileResource {

	private static final Logger LOGGER = Logger.getLogger(MobileResource.class);

	public MobileResource() {
	}


	/**
	 * Recupérer, contrôler et sauvegarder la fiche du boursier.
	 * 
	 * @param nom
	 * @param prenoms
	 * @param dateNaissance
	 * @param paysId
	 * @param sexeId
	 * @return
	 */
	@POST
	@Path("/ajouterFiche")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ajouterFicheBoursier(@QueryParam("nom") final String nom,
			@QueryParam("prenoms") final String prenoms,
			@QueryParam("dateNaissance") final String dateNaissance,
			@QueryParam("paysId") final int paysId, @QueryParam("sexeId") final int sexeId) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("creation utilisateur : " + prenoms + " " + nom);
		}

		// TODO EBO: à implémenter.

		return null;
	}
}
