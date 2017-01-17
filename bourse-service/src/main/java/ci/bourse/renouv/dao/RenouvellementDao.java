package ci.bourse.renouv.dao;

import ci.bourse.renouv.model.Renouvellement;

/**
 * @author euchoux
 */
public interface RenouvellementDao extends DefaultRepository<Renouvellement, Integer> {

	/**
	 * Permet de trouver le pourcentage des demandes refusées.
	 * 
	 * @return
	 */
	Double trouverPourcentageDemandesRefusees();

	/**
	 * Permet de trouver le pourcentage des demandes ayant un document manquant.
	 * 
	 * @return
	 */
	Double trouverPourcentageDocumentsManquants();

	/**
	 * Calcule le nombre total de demandes de renouvellements reçues.
	 * 
	 * @return
	 */
	Double trouverTotaleDemandesRecues();

	/**
	 * Trouve le nombre de demandes en attente de fiches confidentielles.
	 * 
	 * @return
	 */
	Integer trouverNbEnAttenteFicheConfidentielle();

	/**
	 * Trouve le nombre de demandes en attente de validation par l'ambassade
	 * 
	 * @return
	 */
	Integer trouverNbEnAttenteValidationAmbassade();

	/**
	 * Trouve le nombre de demandes en attente de validation par la DOB
	 * 
	 * @return
	 */
	Integer trouverNbEnAttenteValidationDob();

}
