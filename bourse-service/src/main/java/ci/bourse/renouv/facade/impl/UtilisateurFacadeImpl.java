package ci.bourse.renouv.facade.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import ci.bourse.renouv.constant.ProfilConstant;
import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.dto.UtilisateurDtoLight;
import ci.bourse.renouv.exception.MetierException;
import ci.bourse.renouv.facade.UtilisateurFacade;
import ci.bourse.renouv.securite.ProfilEnum;
import ci.bourse.renouv.service.UtilisateurService;
import ci.bourse.renouv.utils.PasswordUtils;

/**
 * @author euchoux
 */
@Service
public class UtilisateurFacadeImpl extends AbstractFacade implements UtilisateurFacade {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	UtilisateurService utilisateurService;

	@Override
	@Secured({ ProfilConstant.ROLE_ADMIN_BOURSE, ProfilConstant.ROLE_ADMIN_MINISTERE })
	public void creerUtilisateur(final UtilisateurDto utilisateur) throws MetierException {
		utilisateurService.creerUtilisateur(utilisateur);
	}

	@Override
	@Secured({ ProfilConstant.ROLE_ADMIN_BOURSE, ProfilConstant.ROLE_ADMIN_MINISTERE })
	public void modifierUtilisateur(final UtilisateurDto utilisateur) {
		utilisateurService.modifierUtilisateur(utilisateur);

	}

	@Override
	public UtilisateurDto findById(final Integer userId) {
		return utilisateurService.findById(userId);
	}

	@Override
	@Secured({ ProfilConstant.ROLE_ADMIN_BOURSE, ProfilConstant.ROLE_ADMIN_MINISTERE })
	public List<UtilisateurDto> findAllUtitisateur() {
		return utilisateurService.findAllUtitisateur();
	}

	@Override
	public UtilisateurDto findByLogin(final String login) {
		return utilisateurService.findByLogin(login);
	}

	@Override
	public UtilisateurDtoLight verifierLoginMdp(final String login, final String password, final Timestamp dateDuJour)
			throws MetierException {

		final UtilisateurDto utilisateur = findByLogin(login);

		if (utilisateur == null) {
			throw new MetierException("Le login saisi est incorrect.");
		}

		// Le login est correct.
		if (utilisateur.isCompteBloque()) {
			throw new MetierException("Votre compte est bloqué. Veuillez vous adresser à votre adminitrateur.");
		}

		// Vérification du mot de passe
		if (!PasswordUtils.isPasswordValid(utilisateur.getPassword(), login + password)) {
			final boolean compteBloque = utilisateurService.mettreAJourNombreConnexion(utilisateur, false);
			if (compteBloque) {
				throw new MetierException(
						"Le mot de passe saisi est incorrect. Le nombre maximal de de tentative est atteint. Votre compte est désormais bloqué.");
			}
			throw new MetierException("Le mot de passe saisi est incorrect. Nombre de tentatives restantes: "
					+ String.valueOf(utilisateur.getNbTentatifsRestant() - 1));
		}

		// L'utilisateur est correctement autentifié. On met à jour sa date de
		// dernière connexion et on réinitialise le nombre de tentatives.
		utilisateurService.mettreAJourNombreConnexion(utilisateur, true);
		utilisateurService.mettreAJourDateDerniereConnexion(utilisateur, dateDuJour);

		final UtilisateurDtoLight res = getMapper().map(utilisateur, UtilisateurDtoLight.class);
		res.setUserProfil(ProfilEnum.valueOf(utilisateur.getProfil().getLibelle()));
		return res;
	}

	@Override
	@Secured({ ProfilConstant.ROLE_ADMIN_BOURSE, ProfilConstant.ROLE_ADMIN_MINISTERE })
	public void supprimerUtilisateur(final Integer userId) throws MetierException {
		utilisateurService.supprimerUtilisateur(userId);
	}

	@Override
	@Secured({ ProfilConstant.ROLE_ADMIN_BOURSE, ProfilConstant.ROLE_ADMIN_MINISTERE })
	public void bloquerDebloquerUtilisateur(final Integer userId, final boolean bloquer) throws MetierException {
		utilisateurService.bloquerDebloquerUtilisateur(userId, bloquer);
	}

}
