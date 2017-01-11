package ci.bourse.renouv.dao;

import java.util.List;

import ci.bourse.renouv.model.Utilisateur;

/**
 * @author euchoux
 */
public interface UtilisateurDao extends DefaultRepository<Utilisateur, Integer> {

	/**
	 * Trouve un utilisateur à partir de son login.
	 * 
	 * @param login
	 * @return
	 */
	Utilisateur findByLogin(String login, boolean avecSupprime);

	/**
	 * Trouve tous les utilisateurs qui ne sont pas supprimés
	 * 
	 * @return
	 */
	List<Utilisateur> findAllUtilisateur();

}
