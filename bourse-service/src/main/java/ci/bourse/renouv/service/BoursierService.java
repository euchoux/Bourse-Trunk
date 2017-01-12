package ci.bourse.renouv.service;

import java.io.Serializable;
import java.util.Map;

public interface BoursierService extends Serializable {
	
	/**
	 * Permet de trouver le montant de bourse par année sur les X dernières
	 * années.
	 * 
	 * @return
	 */
	Map<String, Double> trouverMontantBourseParAnnee(Integer nbAnneeMax);

	/**
	 * Permet de trouver le nombre de boursier par pays.
	 * 
	 * @return
	 */
	Map<String, Integer> trouverNombreBoursierParPays();
}
