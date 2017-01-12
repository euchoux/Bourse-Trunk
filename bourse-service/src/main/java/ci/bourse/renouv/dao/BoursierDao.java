package ci.bourse.renouv.dao;

import ci.bourse.renouv.model.Boursier;

/**
 * @author euchoux
 */
public interface BoursierDao extends DefaultRepository<Boursier, Integer> {

	/**
	 * Calcul le montant total des bourses attribuées pour une année
	 * 
	 * @param anneeCourante
	 * @return
	 */
	Double trouverMontantBoursePour(Integer anneeCourante);

}
