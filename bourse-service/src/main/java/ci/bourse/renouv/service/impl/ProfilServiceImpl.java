package ci.bourse.renouv.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bourse.renouv.dao.ProfilDao;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.model.Profil;
import ci.bourse.renouv.service.ProfilService;

@Service
@Transactional
public class ProfilServiceImpl extends AbstractService implements ProfilService {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	private ProfilDao profilDao;

	@Override
	public ProfilDto trouverProfilParCode(final String codeProfil) {
		ProfilDto res = null;
		final Profil profil = profilDao.findByCode(codeProfil);
		if (profil != null) {
			res = getMapper().map(profil, ProfilDto.class);
		}
		return res;
	}

	@Override
	public List<ProfilDto> findAllProfil() {

		final List<ProfilDto> res = new ArrayList<ProfilDto>();

		final List<Profil> listProfil = profilDao.findAll();
		if (!CollectionUtils.isEmpty(listProfil)) {
			for (final Profil profil : listProfil) {
				res.add(getMapper().map(profil, ProfilDto.class));
			}
		}
		return res;
	}

}
