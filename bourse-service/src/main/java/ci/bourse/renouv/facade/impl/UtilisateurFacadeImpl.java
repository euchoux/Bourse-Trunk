package ci.bourse.renouv.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.exception.MetierException;
import ci.bourse.renouv.facade.UtilisateurFacade;
import ci.bourse.renouv.service.UtilisateurService;
import ci.bourse.renouv.utils.PasswordUtils;

/**
 * @author euchoux
 */
@Service
public class UtilisateurFacadeImpl implements UtilisateurFacade {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	UtilisateurService utilisateurService;

	@Override
	// @Secured({ ProfilConstant.ADMIN_BOURSE, ProfilConstant.ADMIN_MINISTERE })
	public void creerUtilisateur(final UtilisateurDto utilisateur) throws MetierException {
		utilisateurService.creerUtilisateur(utilisateur);
	}

	@Override
	// @Secured({ ProfilConstant.ADMIN_BOURSE, ProfilConstant.ADMIN_MINISTERE })
	public void modifierUtilisateur(final UtilisateurDto utilisateur) {
		utilisateurService.modifierUtilisateur(utilisateur);

	}

	@Override
	// @Secured({ ProfilConstant.ADMIN_BOURSE, ProfilConstant.ADMIN_MINISTERE })
	public UtilisateurDto findById(final Integer userId) {
		return utilisateurService.findById(userId);
	}

	@Override
	// @Secured({ ProfilConstant.ADMIN_BOURSE, ProfilConstant.ADMIN_MINISTERE })
	public List<UtilisateurDto> findAllUtitisateur() {
		return utilisateurService.findAllUtitisateur();
	}

	@Override
	public UtilisateurDto findByLogin(final String login) {
		return utilisateurService.findByLogin(login);
	}

	@Override
	public void verifierLoginMdp(final String login, final String password) throws MetierException {
		final UtilisateurDto utilisateur = findByLogin(login);

		if (utilisateur == null) {
			throw new MetierException("Le login saisi est incorrect.");
		}
		// Le login est correct. Vérification du mot de passe
		final String mdpHash = PasswordUtils.hacherMessageSHA256(password);
		if (!mdpHash.equals(utilisateur.getPassword())) {
			throw new MetierException("Le mot de passe saisi est incorrect.");
		}

		// Le login et le mot de passe saisis sont corrects. On ajoute
		// l'utilisateur dans la session serveur.

	}

}
