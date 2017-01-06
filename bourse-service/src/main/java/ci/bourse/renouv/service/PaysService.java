package ci.bourse.renouv.service;

import java.io.Serializable;

import ci.bourse.renouv.dto.PaysDto;

public interface PaysService extends Serializable {
	
	/**
	 * Permet de trouver un pays par son identifiant.
	 * 
	 * @param paysId
	 */
	PaysDto trouverPaysParId(final Integer paysId);

}
