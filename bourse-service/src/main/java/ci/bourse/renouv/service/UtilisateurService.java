package ci.bourse.renouv.service;

import java.io.Serializable;
import java.sql.Timestamp;
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

	/**
	 * Met à jour le nombre de tentatif de connexion restant. Cet service est
	 * appelé à chaque echec de connexion
	 * 
	 * @param utilisateur
	 * @param reinitialiser
	 *            permet de debloquer le compte de l'utilisateur lorsque
	 *            celui-ci est bloqué
	 */
	boolean mettreAJourNombreConnexion(UtilisateurDto utilisateur, boolean reinitialiser);

	/**
	 * Permet de mettre à jour la date de dernière connexion lorsque
	 * l'utilisateur est correctement authentifié.
	 * 
	 * @param utilisateur
	 * @param dateDuJour
	 */
	void mettreAJourDateDerniereConnexion(UtilisateurDto utilisateur, Timestamp dateDuJour);

	/**
	 * Bloque ou débloque un utilisateur.
	 * 
	 * @param userId
	 * @param bloquer
	 * @throws MetierException
	 */
	void bloquerDebloquerUtilisateur(Integer userId, boolean bloquer) throws MetierException;

	/**
	 * Supprime de façon logique (supprime=true) un utilisateur de la base de
	 * données.
	 * 
	 * @param userId
	 * @throws MetierException
	 */
	void supprimerUtilisateur(Integer userId) throws MetierException;

}
