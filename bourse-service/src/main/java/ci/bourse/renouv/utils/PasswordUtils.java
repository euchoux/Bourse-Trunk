package ci.bourse.renouv.utils;

import org.apache.commons.lang3.Validate;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import ci.bourse.renouv.constant.BourseConstant;

/**
 * Utilitaire de gestion du mot de passe.
 * 
 * @author euchoux
 */
public class PasswordUtils {

	public PasswordUtils() {
	}

	/**
	 * Permet de hasher un mot de passe.
	 * 
	 * <pre>
	 * 	- Ajout un sel de hash 
	 * 	- hash selon l'algorithme précisé dans les paramètres de l'application
	 * </pre>
	 * 
	 * @param message
	 * @param mdp
	 * @return
	 */
	public static String hacherMessageSHA256(final String login, final String mdp)
    {
		// Contrôle des paramètres
		Validate.notEmpty(login);
		Validate.notEmpty(login);

		final Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		return md5.encodePassword(login + mdp, BourseConstant.SEL_MPS);
    }
	
	/**
	 * Permet de vérifier si le mot de passe est valide.
	 * 
	 * @param hashPassword
	 *            le hash du mot de passe stocké
	 * @param loginPasswordAVerifier
	 *            la combinaison login+mot de passe à vérifier
	 * @return
	 */
	public static boolean isPasswordValid(final String hashPassword, final String loginPasswordAVerifier)
    {
		// Contrôle des paramètres
		Validate.notEmpty(hashPassword);
		Validate.notEmpty(loginPasswordAVerifier);

		final Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		return md5.isPasswordValid(hashPassword, loginPasswordAVerifier, BourseConstant.SEL_MPS);
    }

}
