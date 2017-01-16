package ci.bourse.renouv.facade.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ci.bourse.renouv.constant.BourseConstant;
import ci.bourse.renouv.dto.dashboard.DashBoardBoursierDto;
import ci.bourse.renouv.dto.dashboard.DashboardDto;
import ci.bourse.renouv.facade.DashboardFacade;
import ci.bourse.renouv.service.BoursierService;

/**
 * @author euchoux
 */
@Service
public class DashboardFacadeImpl implements DashboardFacade {

	private static final long serialVersionUID = -2778854087789081735L;

	@Resource
	private BoursierService boursierService;

	@Override
	public DashboardDto loadDashboard() {
		final DashboardDto res = new DashboardDto();

		final DashBoardBoursierDto dashBoardBoursierDto = new DashBoardBoursierDto();

		// Montant par année
		final Map<String, Double> montantBourseParAnnee = boursierService
				.trouverMontantBourseParAnnee(BourseConstant.NOMBRE_ANNEE_MAX);
		res.setMontantBourseParAnnee(montantBourseParAnnee);

		// Boursier par pays
		final Map<String, Integer> nbBoursierParPays = boursierService.trouverNombreBoursierParPays();
		res.setNbBoursierParPays(nbBoursierParPays);

		// Nombre total de boursier
		final Integer nbTotalBoursier = boursierService.trouverNombreTotalBoursier();
		dashBoardBoursierDto.setNbTotalBoursier(nbTotalBoursier);

		res.setDashBoursiers(dashBoardBoursierDto);

		return res;
	}

}
