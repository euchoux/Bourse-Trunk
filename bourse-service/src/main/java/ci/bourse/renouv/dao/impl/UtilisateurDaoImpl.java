package ci.bourse.renouv.dao.impl;

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
	public Utilisateur findByLogin(final String login) {

		final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

		final CriteriaQuery<Utilisateur> criteria = builder.createQuery( Utilisateur.class );
		final Root<Utilisateur> root = criteria.from( Utilisateur.class );
		criteria.select( root );
		criteria.where(builder.equal(root.get("Utilisateur.login"), login));

		return getEntityManager().createQuery(criteria).getSingleResult();
	}

}
