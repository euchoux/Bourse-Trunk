package ci.bourse.renouv.service;

import java.io.Serializable;
import java.util.List;

import ci.bourse.renouv.dto.PaysDto;

public interface PaysService extends Serializable {
	
	/**
	 * Permet de trouver un pays par son identifiant.
	 * 
	 * @param paysId
	 */
	PaysDto trouverPaysParId(final Integer paysId);

	/**
	 * Charge la liste de tous les pays.
	 * 
	 * @return
	 */
	List<PaysDto> findAllPays();

}
