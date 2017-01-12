package ci.bourse.renouv.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.dto.SexeDto;
import ci.bourse.renouv.facade.NomenclatureFacade;
import ci.bourse.renouv.service.PaysService;
import ci.bourse.renouv.service.ProfilService;
import ci.bourse.renouv.service.SexeService;

/**
 * @author euchoux
 */
@Service
public class NomenclatureFacadeImpl implements NomenclatureFacade {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	private PaysService paysService;

	@Resource
	private SexeService sexeService;

	@Resource
	private ProfilService profilService;

	@Override
	public PaysDto trouverPaysParId(final Integer paysId) {
		return paysService.trouverPaysParId(paysId);
	}

	@Override
	public SexeDto trouverSexeParId(final Integer sexeId) {
		return sexeService.trouverSexeParId(sexeId);
	}

	@Override
	public ProfilDto trouverProfilParCode(final String codeProfil) {
		return profilService.trouverProfilParCode(codeProfil);
	}

	@Override
	public List<SexeDto> findAllSexe() {
		return sexeService.findAllSexe();
	}

	@Override
	public List<ProfilDto> findAllProfil() {
		return profilService.findAllProfil();
	}

	@Override
	public List<PaysDto> findAllPays() {
		return paysService.findAllPays();
	}

}
