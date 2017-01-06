package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.SerieDao;
import ci.bourse.renouv.model.Serie;

/**
 * @author euchoux
 */
@Repository
public class SerieDaoImpl extends AbstractHibernateRepository<Serie, Integer> implements SerieDao {

    public SerieDaoImpl() {
        super();
    }


}
