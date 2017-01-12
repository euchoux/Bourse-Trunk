package ci.bourse.renouv.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
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
	private SexeDao sexeDao;

	@Override
	public SexeDto trouverSexeParId(final Integer sexeId) {
		SexeDto res = null;
		final Sexe sexe = sexeDao.findById(sexeId);
		if (sexe != null) {
			res = getMapper().map(sexe, SexeDto.class);
		}
		return res;

	}

	@Override
	public List<SexeDto> findAllSexe() {

		final List<SexeDto> res = new ArrayList<SexeDto>();

		final List<Sexe> listSexe = sexeDao.findAll();
		if (!CollectionUtils.isEmpty(listSexe)) {
			for (final Sexe sexe : listSexe) {
				res.add(getMapper().map(sexe, SexeDto.class));
			}
		}
		return res;
	}

}
