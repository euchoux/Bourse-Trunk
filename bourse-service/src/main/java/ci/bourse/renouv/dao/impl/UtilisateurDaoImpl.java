package ci.bourse.renouv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.UtilisateurDao;
import ci.bourse.renouv.model.Utilisateur;

/**
 * @author euchoux
 */
@Repository
public class UtilisateurDaoImpl extends AbstractHibernateRepository<Utilisateur, Integer> implements UtilisateurDao {

	public UtilisateurDaoImpl() {
		super();
	}

	@Override
	public Utilisateur findByLogin(final String login, final boolean avecSupprime) {

		Utilisateur res;

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Utilisateur> criteria = builder.createQuery(Utilisateur.class);
		final Root<Utilisateur> root = criteria.from(Utilisateur.class);
		criteria.select(root);
		if (avecSupprime) {
			criteria.where(builder.equal(root.get("login"), login));
		} else {
			criteria.where(builder.and(builder.equal(root.get("login"), login), builder.isFalse(root.get("supprime"))));
		}

		try {
			res = getSession().createQuery(criteria).getSingleResult();
		} catch (final NoResultException e) {
			res = null;
		}

		return res;
	}

	@Override
	public List<Utilisateur> findAllUtilisateur() {

		List<Utilisateur> res;

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Utilisateur> criteria = builder.createQuery(Utilisateur.class);
		final Root<Utilisateur> root = criteria.from(Utilisateur.class);
		criteria.select(root);
		criteria.where(builder.isFalse(root.get("supprime")));

		try {
			res = getSession().createQuery(criteria).getResultList();
		} catch (final NoResultException e) {
			res = new ArrayList<Utilisateur>();
		}

		return res;
	}

}
