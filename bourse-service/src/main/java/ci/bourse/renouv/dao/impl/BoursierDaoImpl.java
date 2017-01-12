package ci.bourse.renouv.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.BoursierDao;
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

}
