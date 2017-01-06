package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

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


}
