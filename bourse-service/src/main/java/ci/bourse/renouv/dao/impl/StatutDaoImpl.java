package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.StatutDao;
import ci.bourse.renouv.model.Statut;

/**
 * @author euchoux
 */
@Repository
public class StatutDaoImpl extends AbstractHibernateRepository<Statut, Integer> implements StatutDao {

    public StatutDaoImpl() {
        super();
    }


}
