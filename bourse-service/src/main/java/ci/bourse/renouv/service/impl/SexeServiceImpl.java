package ci.bourse.renouv.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bourse.renouv.dao.SexeDao;
import ci.bourse.renouv.dto.SexeDto;
import ci.bourse.renouv.model.Sexe;
import ci.bourse.renouv.service.SexeService;

@Service
@Transactional
public class SexeServiceImpl extends AbstractService implements SexeService {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	SexeDao paysDao;

	@Override
	public SexeDto trouverSexeParId(final Integer sexeId) {
		SexeDto res = null;
		final Sexe pays = paysDao.findById(sexeId);
		if (pays != null) {
			res = getMapper().map(pays, SexeDto.class);
		}
		return res;

	}


}
