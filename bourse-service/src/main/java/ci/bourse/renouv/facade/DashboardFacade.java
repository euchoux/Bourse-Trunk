package ci.bourse.renouv.facade;

import java.io.Serializable;

import ci.bourse.renouv.dto.dashboard.DashboardDto;

/**
 * @author euchoux
 */
public interface DashboardFacade extends Serializable {
	
	/**
	 * Construit et retourne les indicateurs du tableau de bord.
	 * 
	 * @return
	 */
	DashboardDto loadDashboard();

}
