package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.HistoScolariteDao;
import ci.bourse.renouv.model.HistoScolarite;

/**
 * @author euchoux
 */
@Repository
public class HistoScolariteDaoImpl extends AbstractHibernateRepository<HistoScolarite, Integer>
		implements HistoScolariteDao {

    public HistoScolariteDaoImpl() {
        super();
    }


}
