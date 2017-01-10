package ci.bourse.renouv.facade;

import java.io.Serializable;
import java.util.List;

import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.dto.UtilisateurDtoLight;
import ci.bourse.renouv.exception.MetierException;

/**
 * @author euchoux
 */
public interface UtilisateurFacade extends Serializable {
	
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

	/**
	 * Verifie le login et le mot de passe de l'utisateur puis renvoie une
	 * exception en cas d'erreur.
	 * 
	 * @param login
	 * @param password
	 * @return {@link UtilisateurDtoLight}
	 * @throws MetierException
	 */
	UtilisateurDtoLight verifierLoginMdp(String login, String password) throws MetierException;

}
