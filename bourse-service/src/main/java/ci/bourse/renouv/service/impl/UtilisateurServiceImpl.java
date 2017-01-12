package ci.bourse.renouv.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dao.UtilisateurDao;
import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.exception.MetierException;
import ci.bourse.renouv.model.Utilisateur;
import ci.bourse.renouv.service.UtilisateurService;

@Service
@Transactional
public class UtilisateurServiceImpl extends AbstractService implements UtilisateurService {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	private UtilisateurDao utilisateurDao;

	/**
	 * @throws MetierException
	 * @see ci.bourse.renouv.service.UtilisateurService#creerUtilisateur(ci.bourse.renouv.dto.UtilisateurDto)
	 */
	@Override
	public void creerUtilisateur(final UtilisateurDto utilisateur) throws MetierException {

		final Utilisateur user = utilisateurDao.findByLogin(utilisateur.getLogin(), true);
		if (user != null) {
			throw new MetierException("Un compte avec le même utilisateur existe.");
		}

		utilisateurDao.save(getMapper().map(utilisateur, Utilisateur.class));
	}

	/**
	 * @see ci.bourse.renouv.service.UtilisateurService#modifierUtilisateur(ci.bourse.renouv.dto.UtilisateurDto)
	 */
	@Override
	public void modifierUtilisateur(final UtilisateurDto utilisateur) {
		utilisateurDao.update(getMapper().map(utilisateur, Utilisateur.class));

	}

	/**
	 * @see ci.bourse.renouv.service.UtilisateurService#findById(java.lang.Integer)
	 */
	@Override
	public UtilisateurDto findById(final Integer userId) {
		UtilisateurDto res = null;
		final Utilisateur utilisateur = utilisateurDao.findById(userId);
		if (utilisateur != null) {
			res = getMapper().map(utilisateur, UtilisateurDto.class);
		}
		return res;
	}

	/**
	 * @see ci.bourse.renouv.service.UtilisateurService#findAllUtitisateur()
	 */
	@Override
	public List<UtilisateurDto> findAllUtitisateur() {
		final List<UtilisateurDto> res = new ArrayList<UtilisateurDto>();
		final List<Utilisateur> listUtilisateur = utilisateurDao.findAllUtilisateur();
		if (!CollectionUtils.isEmpty(listUtilisateur)) {
			for (final Utilisateur utilisateur : listUtilisateur) {
				res.add(getMapper().map(utilisateur, UtilisateurDto.class));
			}
		}
		return res;
	}

	/**
	 * @see ci.bourse.renouv.service.UtilisateurService#findByLogin(java.lang.String)
	 */
	@Override
	public UtilisateurDto findByLogin(final String login) {
		UtilisateurDto res = null;
		final Utilisateur utilisateur = utilisateurDao.findByLogin(login, false);
		if (utilisateur != null) {
			res = getMapper().map(utilisateur, UtilisateurDto.class);
		}
		return res;
	}

	@Override
	public boolean mettreAJourNombreConnexion(final UtilisateurDto utilisateur, final boolean reinitialiser) {
		boolean compteBloque = false;
		if (utilisateur != null && utilisateur.getId() != null) {
			final Utilisateur user = utilisateurDao.findById(utilisateur.getId());
			if (user != null) {

				if (reinitialiser) {
					user.setNbTentatifsRestant(BourseConstant.NOMBRE_CONNEXION_MAX);
					user.setCompteBloque(false);
				} else {
					user.setNbTentatifsRestant(user.getNbTentatifsRestant() - 1);
					compteBloque = user.getNbTentatifsRestant() <= Integer.valueOf(0);
					user.setCompteBloque(compteBloque);
				}

				utilisateurDao.update(user);
			}
		}
		return compteBloque;
	}

	@Override
	public void mettreAJourDateDerniereConnexion(final UtilisateurDto utilisateur, final Timestamp dateDuJour) {
		if (utilisateur != null && utilisateur.getId() != null) {
			final Utilisateur user = utilisateurDao.findById(utilisateur.getId());
			if (user != null) {
				user.setDateDerniereConnexion(dateDuJour);
				utilisateurDao.update(user);
			}
		}
	}

	@Override
	public void bloquerDebloquerUtilisateur(final Integer userId, final boolean bloquer) throws MetierException {
		final Utilisateur user = utilisateurDao.findById(userId);
		if (user == null) {
			throw new MetierException("Utilisateur non trouvé");
		}

		user.setCompteBloque(bloquer);
		utilisateurDao.update(user);
	}

	@Override
	public void supprimerUtilisateur(final Integer userId) throws MetierException {
		final Utilisateur user = utilisateurDao.findById(userId);
		if (user == null) {
			throw new MetierException("Utilisateur non trouvé");
		}

		user.setSupprime(true);
		utilisateurDao.update(user);
	}

}
