package ci.bourse.renouv.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.dto.SexeDto;
import ci.bourse.renouv.facade.NomenclatureFacade;

/**
 * La ressource REST permettant de gérer l'authentification de l'utilisateur.
 * (Premier niveau de sécurité).
 * 
 * @author euchoux
 */
@Component
@Path("/nomenclature")
public class NomenclatureResource {

	@Autowired
	private NomenclatureFacade nomenclatureFacade;

	final ObjectMapper jsonMapper = new ObjectMapper();

	public NomenclatureResource() {
	}

	/**
	 * Le service REST permettant de la liste de tous les pays.
	 * 
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("/listepays")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllPays() throws JsonProcessingException {
		final List<PaysDto> listPays = nomenclatureFacade.findAllPays();
		return Response.ok(jsonMapper.writeValueAsString(listPays))
					.build();
	}

	/**
	 * Le service REST permettant de la liste de tous les profils.
	 * 
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("/listeprofil")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProfil() throws JsonProcessingException {
		final List<ProfilDto> listProfils = nomenclatureFacade.findAllProfil();
		return Response.ok(jsonMapper.writeValueAsString(listProfils)).build();
	}

	/**
	 * Le service REST permettant de la liste de tous les sexes.
	 * 
	 * @return
	 * @throws JSONException
	 */
	@GET
	@Path("/listesexe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSexe() throws JsonProcessingException {
		final List<SexeDto> listSexe = nomenclatureFacade.findAllSexe();
		return Response.ok(jsonMapper.writeValueAsString(listSexe)).build();
	}
}
