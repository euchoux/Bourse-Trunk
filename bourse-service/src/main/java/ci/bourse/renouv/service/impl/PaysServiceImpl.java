package ci.bourse.renouv.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
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

	@Override
	public List<PaysDto> findAllPays() {

		final List<PaysDto> res = new ArrayList<PaysDto>();

		final List<Pays> listPays = paysDao.findAll();
		if (!CollectionUtils.isEmpty(listPays)) {
			for (final Pays pays : listPays) {
				res.add(getMapper().map(pays, PaysDto.class));
			}
		}
		return res;
	}

}
