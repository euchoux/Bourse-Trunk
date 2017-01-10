package ci.bourse.renouv.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.ProfilDao;
import ci.bourse.renouv.model.Profil;

/**
 * @author euchoux
 */
@Repository
public class ProfilDaoImpl extends AbstractHibernateRepository<Profil, Integer> implements ProfilDao {

    public ProfilDaoImpl() {
        super();
    }

	@Override
	public Profil findByCode(final String codeProfil) {

		Profil res;

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Profil> criteria = builder.createQuery(Profil.class);
		final Root<Profil> root = criteria.from(Profil.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("code"), codeProfil));

		try {
			res = getSession().createQuery(criteria).getSingleResult();
		} catch (final NoResultException e) {
			res = null;
		}

		return res;
	}

}
