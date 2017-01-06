package ci.bourse.renouv.facade;

import java.io.Serializable;

import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.SexeDto;

/**
 * @author euchoux
 */
public interface NomenclatureFacade extends Serializable {
	
	/**
	 * Permet de trouver un pays à partir de son identifiant.
	 * 
	 * @param paysId
	 */
	PaysDto trouverPaysParId(Integer paysId);

	/**
	 * Permet de trouver un sexe à partir de son identifiant.
	 * 
	 * @param sexe
	 */
	SexeDto trouverSexeParId(Integer sexeId);



}
