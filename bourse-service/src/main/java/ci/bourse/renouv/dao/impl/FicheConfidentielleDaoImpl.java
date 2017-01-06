package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.FicheConfidentielleDao;
import ci.bourse.renouv.model.FicheConfidentielle;

/**
 * @author euchoux
 */
@Repository
public class FicheConfidentielleDaoImpl extends AbstractHibernateRepository<FicheConfidentielle, Integer>
		implements FicheConfidentielleDao {

    public FicheConfidentielleDaoImpl() {
        super();
    }


}
