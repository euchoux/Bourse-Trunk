package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.FiliationDao;
import ci.bourse.renouv.model.Filiation;

/**
 * @author euchoux
 */
@Repository
public class FiliationDaoImpl extends AbstractHibernateRepository<Filiation, Integer> implements FiliationDao {

    public FiliationDaoImpl() {
        super();
    }


}
