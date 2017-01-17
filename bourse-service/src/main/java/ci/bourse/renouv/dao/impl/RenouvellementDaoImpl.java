package ci.bourse.renouv.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dao.RenouvellementDao;
import ci.bourse.renouv.model.Renouvellement;

/**
 * @author euchoux
 */
@Repository
public class RenouvellementDaoImpl extends AbstractHibernateRepository<Renouvellement, Integer>
		implements RenouvellementDao {

    public RenouvellementDaoImpl() {
        super();
    }

	@Override
	public Double trouverPourcentageDemandesRefusees(){

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final Metamodel metamodel = getSession().getMetamodel();
		final EntityType<Renouvellement> renouvEntity = metamodel
				.entity(Renouvellement.class);

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Renouvellement> root = criteria.from(Renouvellement.class);

		final Join statut = root.join(renouvEntity.getSingularAttribute("statut"),
				JoinType.LEFT);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.and(
				builder.equal(statut.get("code"), BourseConstant.CODE_STATUT_REFUSEE),
				builder.isFalse(root.get("archive"))));

		final Long nb = getSession().createQuery(criteria).getSingleResult();
		return nb.doubleValue();
	}

	@Override
	public Double trouverPourcentageDocumentsManquants(){

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final Metamodel metamodel = getSession().getMetamodel();
		final EntityType<Renouvellement> renouvEntity = metamodel
				.entity(Renouvellement.class);

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Renouvellement> root = criteria.from(Renouvellement.class);

		final Join statut = root.join(renouvEntity.getSingularAttribute("statut"),
				JoinType.LEFT);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.and(
				builder.equal(statut.get("code"),
						BourseConstant.CODE_STATUT_DOCUMENT_MANQUANT),
				builder.isFalse(root.get("archive"))));

		final Long nb = getSession().createQuery(criteria).getSingleResult();
		return nb.doubleValue();
	}

	@Override
	public Double trouverTotaleDemandesRecues(){

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Renouvellement> root = criteria.from(Renouvellement.class);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.isFalse(root.get("archive")));

		final Long nb = getSession().createQuery(criteria).getSingleResult();

		return nb.doubleValue();
	}

	@Override
	public Integer trouverNbEnAttenteFicheConfidentielle(){

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Renouvellement> root = criteria.from(Renouvellement.class);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.and(builder.isFalse(root.get("archive")),
				builder.isNull(root.get("ficheConfidentielle"))));

		final Long nb = getSession().createQuery(criteria).getSingleResult();

		return nb.intValue();
	}

	@Override
	public Integer trouverNbEnAttenteValidationAmbassade(){

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Renouvellement> root = criteria.from(Renouvellement.class);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.and(builder.isFalse(root.get("archive")),
				builder.isNull(root.get("dateValidationAmbassade"))));

		final Long nb = getSession().createQuery(criteria).getSingleResult();

		return nb.intValue();
	}

	@Override
	public Integer trouverNbEnAttenteValidationDob(){

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Renouvellement> root = criteria.from(Renouvellement.class);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.and(builder.isFalse(root.get("archive")),
				builder.and(builder.isNull(root.get("dateValidationDob")),
						builder.isNotNull(root.get("dateValidationAmbassade")))));

		final Long nb = getSession().createQuery(criteria).getSingleResult();

		return nb.intValue();
	}

}
