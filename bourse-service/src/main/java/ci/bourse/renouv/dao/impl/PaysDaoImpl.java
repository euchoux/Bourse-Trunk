package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.PaysDao;
import ci.bourse.renouv.model.Pays;

/**
 * @author euchoux
 */
@Repository
public class PaysDaoImpl extends AbstractHibernateRepository<Pays, Integer> implements PaysDao {

    public PaysDaoImpl() {
        super();
    }


}
