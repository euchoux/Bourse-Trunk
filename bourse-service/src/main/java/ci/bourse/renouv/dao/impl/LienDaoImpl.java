package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.LienDao;
import ci.bourse.renouv.model.Lien;

/**
 * @author euchoux
 */
@Repository
public class LienDaoImpl extends AbstractHibernateRepository<Lien, Integer> implements LienDao {

    public LienDaoImpl() {
        super();
    }


}
