package ci.bourse.renouv.service;

import java.io.Serializable;
import java.util.List;

import ci.bourse.renouv.dto.SexeDto;

public interface SexeService extends Serializable {
	
	/**
	 * Permet de trouver un sexe par son identifiant.
	 * 
	 * @param sexeId
	 */
	SexeDto trouverSexeParId(final Integer sexeId);

	/**
	 * Charge la liste de tous les sexes.
	 * 
	 * @return
	 */
	List<SexeDto> findAllSexe();

}
