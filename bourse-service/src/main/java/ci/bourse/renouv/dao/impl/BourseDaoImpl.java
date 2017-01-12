package ci.bourse.renouv.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dao.BourseDao;
import ci.bourse.renouv.model.Bourse;

/**
 * @author euchoux
 */
@Repository
public class BourseDaoImpl extends AbstractHibernateRepository<Bourse, Integer> implements BourseDao {

    public BourseDaoImpl() {
        super();
    }

	@Override
	public Map<String, Integer> trouverNombreBoursierParPays() {

		final Map<String, Integer> res = new HashMap<String, Integer>();

		final CriteriaBuilder builder = getSession().getCriteriaBuilder();

		final CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		final Root<Bourse> root = criteria.from(Bourse.class);
		criteria.multiselect(root.get("pays.code"), builder.count(root.get("id")));
		criteria.where(builder.and(builder.notEqual(root.get("statut.id"), BourseConstant.ID_STATUT_REFUSEE),
				builder.notEqual(root.get("statut.id"), BourseConstant.ID_STATUT_SUSPENDU)));
		criteria.groupBy(root.get("pays.code"));

		final List<Object[]> listObjets = getSession().createQuery(criteria).getResultList();
		if(!CollectionUtils.isEmpty(listObjets)){
			for (final Object[] values : listObjets) {
				res.put((String) values[0], (Integer) values[1]);
			}
		}

		return res;
	}


}
