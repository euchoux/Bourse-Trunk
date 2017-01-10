package ci.bourse.renouv.service;

import java.io.Serializable;

import ci.bourse.renouv.dto.ProfilDto;

public interface ProfilService extends Serializable {
	
	/**
	 * Permet de trouver un profil à partir de son code.
	 * 
	 * @param codeProfil
	 */
	ProfilDto trouverProfilParCode(String codeProfil);

}
