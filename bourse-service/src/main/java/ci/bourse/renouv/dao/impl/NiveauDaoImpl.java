package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.NiveauDao;
import ci.bourse.renouv.model.Niveau;

/**
 * @author euchoux
 */
@Repository
public class NiveauDaoImpl extends AbstractHibernateRepository<Niveau, Integer> implements NiveauDao {

    public NiveauDaoImpl() {
        super();
    }


}
