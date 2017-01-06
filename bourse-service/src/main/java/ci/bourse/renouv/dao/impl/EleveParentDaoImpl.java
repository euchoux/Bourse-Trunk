package ci.bourse.renouv.dao.impl;

import org.springframework.stereotype.Repository;

import ci.bourse.renouv.dao.EleveParentDao;
import ci.bourse.renouv.model.EleveParent;
import ci.bourse.renouv.model.EleveParentPk;

/**
 * @author euchoux
 */
@Repository
public class EleveParentDaoImpl extends AbstractHibernateRepository<EleveParent, EleveParentPk>
		implements EleveParentDao {

    public EleveParentDaoImpl() {
        super();
    }


}
