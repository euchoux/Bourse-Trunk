package ci.bourse.renouv.service.impl;

import javax.annotation.Resource;

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
	ProfilDao profilDao;

	@Override
	public ProfilDto trouverProfilParCode(final String codeProfil) {
		ProfilDto res = null;
		final Profil profil = profilDao.findByCode(codeProfil);
		if (profil != null) {
			res = getMapper().map(profil, ProfilDto.class);
		}
		return res;
	}


}
