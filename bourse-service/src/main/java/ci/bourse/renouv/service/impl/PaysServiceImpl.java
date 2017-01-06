package ci.bourse.renouv.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bourse.renouv.dao.PaysDao;
import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.model.Pays;
import ci.bourse.renouv.service.PaysService;

@Service
@Transactional
public class PaysServiceImpl extends AbstractService implements PaysService {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	PaysDao paysDao;

	@Override
	public PaysDto trouverPaysParId(final Integer paysId) {
		PaysDto res = null;
		final Pays pays = paysDao.findById(paysId);
		if (pays != null) {
			res = getMapper().map(pays, PaysDto.class);
		}
		return res;

	}


}
