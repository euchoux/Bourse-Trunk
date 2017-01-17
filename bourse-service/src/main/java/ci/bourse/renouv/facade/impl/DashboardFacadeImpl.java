package ci.bourse.renouv.facade.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dto.dashboard.DashBoardBoursierDto;
import ci.bourse.renouv.dto.dashboard.DashboardDto;
import ci.bourse.renouv.facade.DashboardFacade;
import ci.bourse.renouv.service.BoursierService;
import ci.bourse.renouv.service.RenouvellementService;

/**
 * @author euchoux
 */
@Service
public class DashboardFacadeImpl implements DashboardFacade {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	private BoursierService boursierService;

	@Resource
	private RenouvellementService renouvellementService;

	@Override
	public DashboardDto loadDashboard(final Integer anneeCourante){
		final DashboardDto res = new DashboardDto();

		final DashBoardBoursierDto dashBoardBoursierDto = new DashBoardBoursierDto();

		// Montant par année
		final Map<String, Double> montantBourseParAnnee = boursierService
				.trouverMontantBourseParAnnee(BourseConstant.NOMBRE_ANNEE_MAX,
						anneeCourante);
		res.setMontantBourseParAnnee(montantBourseParAnnee);

		// Boursier par pays
		final Map<String, Integer> nbBoursierParPays = boursierService.trouverNombreBoursierParPays();
		res.setNbBoursierParPays(nbBoursierParPays);

		// En attente de fiches confidentielles
		final Integer nbEnAttenteFicheConf = renouvellementService
				.trouverNbEnAttenteFicheConfidentielle();
		res.setNbDemandesEnAttenteFicheConfidentielle(nbEnAttenteFicheConf);

		// Pourcentage renouvellement refus et decument manquant
		final Double pourcentageDemandesRefusees = renouvellementService
				.trouverPourcentageDemandesRefusees();

		final Double pourcentageDocumentsManquants = renouvellementService
				.trouverPourcentageDocumentsManquants();

		res.setPourcentageDemandesRefusees(pourcentageDemandesRefusees);
		res.setPourcentageDocumentsManquants(pourcentageDocumentsManquants);

		// Nombre total de boursier
		final Integer nbTotalBoursier = boursierService.trouverNombreTotalBoursier();


		// Nombre de demandes en attente de validation ambassade
		final Integer nbEnAttenteValidationAmbassade = renouvellementService
				.trouverNbEnAttenteValidationAmbassade();

		final Integer nbEnAttenteValidationDob = renouvellementService
				.trouverNbEnAttenteValidationDob();

		dashBoardBoursierDto
				.setNbEnAttenteValidationAmbassade(nbEnAttenteValidationAmbassade);
		dashBoardBoursierDto.setNbEnAttenteValidationDob(nbEnAttenteValidationDob);
		dashBoardBoursierDto.setNbTotalBoursier(nbTotalBoursier);
		dashBoardBoursierDto.setNbDemandesNonSoumises(nbTotalBoursier
				- nbEnAttenteValidationAmbassade - nbEnAttenteValidationDob);

		res.setDashBoursiers(dashBoardBoursierDto);

		return res;
	}

}
