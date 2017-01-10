package ci.bourse.renouv.constant;

/**
 * Constante de gestion des valeurs globles de l'application.
 * 
 * @author euchoux
 */
public final class BourseConstant {

	private BourseConstant() {
	}

	/**
	 * Sel de hashage permettant de brouiller la découverte du mot de passe.
	 */
	public static final String SEL_MPS = "&gh(dgg02";

	/**
	 * Algorithme utilisé pour hasher le mot de passe.
	 */
	public static final String ALGO_MDP = "SHA-256";

	/**
	 * Code de servant pour la génération du jeton.
	 */
	public static final String CLE_JETON = "kgsdHGE2@";

	/**
	 * Le nom donné à l'intance contenant l'ensemble des jetons JWT
	 */
	public static final String ISSUER_JETON = "bourseJWT";

	/**
	 * Le nom de la propriété header HTTP contenant le jeton.
	 */
	public static final String AUTHORIZATION_PROPERTY = "Authorization";

	/**
	 * Le schema de stockage du jeton.
	 */
	public static final String AUTHENTICATION_SCHEME = "Bearer ";
	
	/**
	 * Durée de vie du jeton en minute.
	 */
	public static final Integer DUREE_JETON = 30;

	public static final String CLAIM_ID = "userId";
	public static final String CLAIM_NOM = "nom";
	public static final String CLAIM_PRENOMS = "prenoms";
	public static final String CLAIM_PROFIL = "profil";

}
