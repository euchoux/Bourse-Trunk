package ci.bourse.renouv.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.bourse.renouv.facade.DashboardFacade;

/**
 * La ressource REST permettant de gérer l'authentification de l'utilisateur.
 * (Premier niveau de sécurité).
 * 
 * @author euchoux
 */
@Component
@Path("/dashboard")
public class DashboardResource {

	private static final Logger LOGGER = Logger.getLogger(DashboardResource.class);

	@Autowired
	private DashboardFacade dashboardFacade;

	public DashboardResource() {
	}

	/**
	 * Construit et retourne les indicateurs du tableau de bord.
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDashBoard() throws JsonProcessingException {
		final ObjectMapper jsonMapper = new ObjectMapper();

		return Response.ok(jsonMapper.writeValueAsString(dashboardFacade.loadDashboard()))
					.build();

	}
}
