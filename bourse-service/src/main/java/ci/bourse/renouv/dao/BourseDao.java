package ci.bourse.renouv.dao;

import java.util.Map;

import ci.bourse.renouv.model.Bourse;

/**
 * @author euchoux
 */
public interface BourseDao extends DefaultRepository<Bourse, Integer> {

	/**
	 * Permet de trouver le nombre de boursier par pays.
	 * 
	 * @return
	 */
	Map<String, Integer> trouverNombreBoursierParPays();
}
