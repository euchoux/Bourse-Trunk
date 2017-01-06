package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.SexeDao;
import ci.bourse.renouv.model.Sexe;

/**
 * @author euchoux
 */
@Repository
public class SexeDaoImpl extends AbstractHibernateRepository<Sexe, Integer> implements SexeDao {

    public SexeDaoImpl() {
        super();
    }


}
