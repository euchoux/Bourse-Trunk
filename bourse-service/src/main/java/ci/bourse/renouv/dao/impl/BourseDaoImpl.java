package ci.bourse.renouv.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		final Metamodel metamodel = getSession().getMetamodel();
		final EntityType<Bourse> bourseEntity = metamodel.entity(Bourse.class);

		final CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		final Root<Bourse> root = criteria.from(Bourse.class);

		final Join pays = root.join(bourseEntity.getSingularAttribute("pays"),
				JoinType.LEFT);
		final Join statut = root.join(bourseEntity.getSingularAttribute("statut"),
				JoinType.LEFT);

		criteria.multiselect(pays.get("code"), builder.count(root.get("id")));
		criteria.where(builder.and(
				builder.notEqual(statut.get("code"), BourseConstant.CODE_STATUT_REFUSEE),
				builder.notEqual(statut.get("code"),
						BourseConstant.CODE_STATUT_SUSPENDU)));
		criteria.groupBy(pays.get("code"));

		final List<Object[]> listObjets = getSession().createQuery(criteria).getResultList();
		if(!CollectionUtils.isEmpty(listObjets)){
			for (final Object[] values : listObjets) {
				res.put((String) values[0], ((Long) values[1]).intValue());
			}
		}

		return res;
	}


}
