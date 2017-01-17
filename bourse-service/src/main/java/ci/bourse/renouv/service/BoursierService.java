package ci.bourse.renouv.service;

import java.io.Serializable;
import java.util.Map;

public interface BoursierService extends Serializable {
	
	/**
	 * Permet de trouver le montant de bourse par année sur les X dernières
	 * années.
	 * 
	 * @param nbAnneeMax
	 * @param anneeCourante
	 * @return
	 */
	Map<String, Double> trouverMontantBourseParAnnee(Integer nbAnneeMax,
			final Integer anneeCourante);

	/**
	 * Permet de trouver le nombre de boursier par pays.
	 * 
	 * @return
	 */
	Map<String, Integer> trouverNombreBoursierParPays();

	/**
	 * Trouve le nombre total de boursier ayant une bourse active.
	 * 
	 * @return
	 */
	Integer trouverNombreTotalBoursier();
}
