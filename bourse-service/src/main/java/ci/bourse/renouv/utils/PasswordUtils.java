package ci.bourse.renouv.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.Validate;
import org.springframework.util.Base64Utils;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.exception.MetierException;

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
	 * @return
	 */
	public static String hacherMessageSHA256(String message)
    {
        // Contrôle du paramètre
        Validate.notEmpty(message);

        MessageDigest md;
        // ajout du sel pour le hashage
        message = message + BourseConstant.SEL_MPS;
        byte[] result = null;
        try
        {
            // récupération d'une instance d'un objet Mac
			md = MessageDigest.getInstance(BourseConstant.ALGO_MDP);
            // affectation du message a hacher
            md.update(message.getBytes());
            // hachage
            result = md.digest();
			return Base64Utils.encodeToString(result);
        }
		catch (final NoSuchAlgorithmException e)
        {
			new MetierException("Erreur de conversion du mot de passe");
        }
		return null;
    }
	
}
