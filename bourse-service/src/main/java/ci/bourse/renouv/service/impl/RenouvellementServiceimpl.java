package ci.bourse.renouv.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bourse.renouv.dao.RenouvellementDao;
import ci.bourse.renouv.service.RenouvellementService;
import ci.bourse.renouv.utils.DoubleUtils;

@Service
@Transactional
public class RenouvellementServiceimpl extends AbstractService
		implements RenouvellementService {

	private static final long serialVersionUID = 5490778262098490583L;

	@Resource
	private RenouvellementDao renouvellementDao;

	@Override
	public Double trouverPourcentageDemandesRefusees(){
		Double res = Double.valueOf(0);
		final Double nbTotalDemande = trouverTotaleDemandesRecues();

		if (nbTotalDemande != null && nbTotalDemande > Double.valueOf(0)) {
			final Double nbDemandesRefusees = renouvellementDao
					.trouverPourcentageDemandesRefusees();
			res = nbDemandesRefusees * 100 / nbTotalDemande;
		}
		return DoubleUtils.round(res, 2);
	}

	@Override
	public Double trouverPourcentageDocumentsManquants(){
		Double res = Double.valueOf(0);
		final Double nbTotalDemande = trouverTotaleDemandesRecues();

		if (nbTotalDemande != null && nbTotalDemande > Double.valueOf(0)) {
			final Double nbDemandesRefusees = renouvellementDao
					.trouverPourcentageDocumentsManquants();
			res = nbDemandesRefusees * 100 / nbTotalDemande;
		}
		return DoubleUtils.round(res, 2);
	}

	@Override
	public Double trouverTotaleDemandesRecues(){
		return renouvellementDao.trouverTotaleDemandesRecues();
	}

	@Override
	public Integer trouverNbEnAttenteFicheConfidentielle(){
		return renouvellementDao.trouverNbEnAttenteFicheConfidentielle();
	}

	@Override
	public Integer trouverNbEnAttenteValidationAmbassade(){
		return renouvellementDao.trouverNbEnAttenteValidationAmbassade();
	}

	@Override
	public Integer trouverNbEnAttenteValidationDob(){
		return renouvellementDao.trouverNbEnAttenteValidationDob();
	}

}
