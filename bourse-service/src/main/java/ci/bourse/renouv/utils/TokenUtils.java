package ci.bourse.renouv.utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dto.UtilisateurDtoLight;
import ci.bourse.renouv.exception.TechniqueException;
import ci.bourse.renouv.securite.ProfilEnum;

/**
 * Utilitaire de gestion du jeton de connexion.
 * 
 * @author euchoux
 */
public class TokenUtils {

	private static final Logger LOGGER = Logger.getLogger(TokenUtils.class);

	public TokenUtils() {
	}

	/**
	 * Génération et stockage du tocken d'authentification.
	 * 
	 * @param username
	 * @param user
	 * @return
	 * @throws TechniqueException
	 */
	public static String issueToken(final String username, final UtilisateurDtoLight user) throws TechniqueException {

		String token = null;
		final Date now = new Date();
		try {
			token = JWT.create().withIssuer(BourseConstant.ISSUER_JETON)
					.withJWTId(username)
					.withClaim(BourseConstant.CLAIM_ID, user.getId()).withClaim(BourseConstant.CLAIM_NOM, user.getNom())
					.withClaim(BourseConstant.CLAIM_PRENOMS, user.getPrenoms())
					.withClaim(BourseConstant.CLAIM_PROFIL, user.getUserProfil().name())
					.withIssuedAt(now).withExpiresAt(DateUtils.addMinutes(now, BourseConstant.DUREE_JETON))
					.sign(Algorithm.HMAC256(BourseConstant.CLE_JETON));
			LOGGER.debug("Jeton correctement créé: id= " + username);
		} catch (final JWTCreationException | IllegalArgumentException | UnsupportedEncodingException e) {
			LOGGER.error("Erreur de génération du token. login: " + username);
			throw new TechniqueException("Erreur lors de la génération du jeton d'authentification.", e);
		}

		return token;
	}
	
	/**
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static UtilisateurDtoLight verifierToken(final String token) throws Exception {
		try {
			LOGGER.debug("------------Début vérification du jeton: " + token);

			// Valider signature
			final Verification verifier = JWT.require(Algorithm.HMAC256(BourseConstant.CLE_JETON));
			verifier.acceptExpiresAt(DateUtils.getFragmentInSeconds(new Date(), Calendar.DAY_OF_YEAR) - 1);

			final JWTVerifier jwtVerifier = verifier.build();

			final DecodedJWT jwt = jwtVerifier.verify(token);

			// Valider header
			validerIdentite(jwt.getIssuer());

			// Valider algorithme signature
			validerAlgorithme(jwt.getAlgorithm());

			// Valider validité
			validerExpiration(jwt.getExpiresAt());

			final Map<String, Claim> mapClaim = jwt.getClaims();
			final UtilisateurDtoLight user = new UtilisateurDtoLight();

			// Valider les informations de l'utilisateur.
			validerClaims(mapClaim);

			for (final Entry<String, Claim> entry : mapClaim.entrySet()) {
				switch (entry.getKey()) {
				case BourseConstant.CLAIM_ID:
					user.setId(entry.getValue().asInt());
					break;
				case BourseConstant.CLAIM_NOM:
					user.setNom(entry.getValue().asString());
					break;
				case BourseConstant.CLAIM_PRENOMS:
					user.setPrenoms(entry.getValue().asString());
					break;
				case BourseConstant.CLAIM_PROFIL:
					user.setUserProfil(ProfilEnum.valueOf(entry.getValue().asString()));
					break;
				default:
					break;
				}
			}
			LOGGER.debug("---------Fin vérification du jeton----------");
			return user;

		} catch (final JWTVerificationException | IllegalArgumentException
				| UnsupportedEncodingException e) {
			LOGGER.error("Erreur lors de la vérification du token: " + token, e);

			if (e instanceof InvalidClaimException) {
				throw e;
			}
			throw new TechniqueException("Erreur lors de la vérification du token du jeton d'authentification.", e);

		}
	}

	private static void validerClaims(final Map<String, Claim> mapClaim) {
		if (MapUtils.isEmpty(mapClaim)) {
			throw new IllegalArgumentException("Le jeton n'est pas valide.");
		}

	}

	private static void validerExpiration(final Date expiresAt) {
		final Date now = new Date();
		if (expiresAt == null || expiresAt.before(now)) {
			throw new IllegalArgumentException("Le jeton a expiré.");
		}

	}

	private static void validerAlgorithme(final String algorithm)
			throws IllegalArgumentException, UnsupportedEncodingException {
		if (StringUtils.isBlank(algorithm)
				|| !Algorithm.HMAC256(BourseConstant.CLE_JETON).getName().equals(algorithm)) {
			throw new IllegalArgumentException("Algorithme non valide");
		}

	}

	private static void validerIdentite(final String issuer) {
		if (StringUtils.isBlank(issuer) || !BourseConstant.ISSUER_JETON.equals(issuer)) {
			throw new IllegalArgumentException("Issuer non valide");
		}
	}

}
