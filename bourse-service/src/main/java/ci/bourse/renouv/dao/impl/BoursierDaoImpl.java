package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.BoursierDao;
import ci.bourse.renouv.model.Boursier;

/**
 * @author euchoux
 */
@Repository
public class BoursierDaoImpl extends AbstractHibernateRepository<Boursier, Integer> implements BoursierDao {

    public BoursierDaoImpl() {
        super();
    }


}
