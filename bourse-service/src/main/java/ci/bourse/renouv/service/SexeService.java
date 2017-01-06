package ci.bourse.renouv.service;

import java.io.Serializable;

import ci.bourse.renouv.dto.SexeDto;

public interface SexeService extends Serializable {
	
	/**
	 * Permet de trouver un sexe par son identifiant.
	 * 
	 * @param sexeId
	 */
	SexeDto trouverSexeParId(final Integer sexeId);

}
