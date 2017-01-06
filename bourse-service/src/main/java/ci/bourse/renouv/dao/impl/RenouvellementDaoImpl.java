package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

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


}
