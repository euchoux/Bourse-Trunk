package ci.bourse.renouv.service;

import java.io.Serializable;
import java.util.List;

import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.exception.MetierException;

public interface UtilisateurService extends Serializable {
	
	/**
	 * Permet de créer un nouvel utilisateur.
	 * 
	 * @param utilisateur
	 */
	void creerUtilisateur(UtilisateurDto utilisateur) throws MetierException;

	/**
	 * Permet de modifier un utilisateur.
	 * 
	 * @param utilisateur
	 */
	void modifierUtilisateur(UtilisateurDto utilisateur);

	/**
	 * Trouve un utilisateur à partir de son identifiant.
	 * 
	 * @param userId
	 *            identifiant de l'utilisateur
	 * @return {@link UtilisateurDto}
	 */
	UtilisateurDto findById(Integer userId);

	/**
	 * Remonte tous les utilisateur de la base.
	 * 
	 * @return une liste {@link UtilisateurDto}
	 */
	List<UtilisateurDto> findAllUtitisateur();

	/**
	 * Trouve un utilisateur à partir de son login
	 * 
	 * @param login
	 * @return {@link UtilisateurDto}
	 */
	UtilisateurDto findByLogin(String login);

}
