package ci.bourse.renouv.facade;

import java.io.Serializable;
import java.util.List;

import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
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

	/**
	 * Permet de trouver un profil à partir de son code.
	 * 
	 * @param codeProfil
	 */
	ProfilDto trouverProfilParCode(String codeProfil);

	/**
	 * Charge la liste de tous les sexes.
	 * 
	 * @return
	 */
	List<SexeDto> findAllSexe();

	/**
	 * Charge la liste de tous le profils.
	 * 
	 * @return
	 */
	List<ProfilDto> findAllProfil();

	/**
	 * Charge la liste de tous les pays.
	 * 
	 * @return
	 */
	List<PaysDto> findAllPays();

}
