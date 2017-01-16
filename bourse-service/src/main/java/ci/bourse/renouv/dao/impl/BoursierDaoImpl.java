package ci.bourse.renouv.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dao.BoursierDao;
import ci.bourse.renouv.model.Bourse;
import ci.bourse.renouv.model.Boursier;
import ci.bourse.renouv.utils.DateUtils;

/**
 * @author euchoux
 */
@Repository
public class BoursierDaoImpl extends AbstractHibernateRepository<Boursier, Integer> implements BoursierDao {

	public BoursierDaoImpl() {
		super();
	}

	@Override
	public Double trouverMontantBoursePour(final Integer anneeCourante) {

		Double res = Double.valueOf(0);

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Boursier> criteria = builder.createQuery(Boursier.class);
		final Root<Boursier> root = criteria.from(Boursier.class);
		criteria.select(root);
		criteria.where(builder.between(root.get("dateAttribution"), DateUtils.borneMinDate(anneeCourante),
				DateUtils.borneMaxDate(anneeCourante)));

		final List<Boursier> list = getSession().createQuery(criteria).getResultList();

		if (!CollectionUtils.isEmpty(list)) {
			for (final Boursier boursier : list) {
				res += boursier.getBourse().getMontant();
			}
		}

		return res;
	}

	@Override
	public Integer trouverNombreTotalBoursier(){

		Integer res = Integer.valueOf(0);

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final Metamodel metamodel = getSession().getMetamodel();
		final EntityType<Boursier> boursierEntity = metamodel.entity(Boursier.class);
		final EntityType<Bourse> bourseEntity = metamodel.entity(Bourse.class);

		final CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		final Root<Boursier> root = criteria.from(Boursier.class);

		final Join bourse = root.join(boursierEntity.getSingularAttribute("bourse"),
				JoinType.LEFT);
		final Join statut = bourse.join(bourseEntity.getSingularAttribute("statut"),
				JoinType.LEFT);

		criteria.multiselect(builder.count(root.get("id")));
		criteria.where(builder.and(
				builder.notEqual(statut.get("code"), BourseConstant.CODE_STATUT_REFUSEE),
				builder.notEqual(statut.get("code"),
						BourseConstant.CODE_STATUT_SUSPENDU)));

		final Long nb = getSession().createQuery(criteria)
				.getSingleResult();
		res = nb.intValue();

		return res;
	}

}
