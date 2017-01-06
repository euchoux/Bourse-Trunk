package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.ProfilDao;
import ci.bourse.renouv.model.Profil;

/**
 * @author euchoux
 */
@Repository
public class ProfilDaoImpl extends AbstractHibernateRepository<Profil, Integer> implements ProfilDao {

    public ProfilDaoImpl() {
        super();
    }


}
