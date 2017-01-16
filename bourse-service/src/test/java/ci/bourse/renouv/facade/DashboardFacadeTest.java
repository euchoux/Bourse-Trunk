package ci.bourse.renouv.facade;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ci.bourse.renouv.AbstractTest;
import ci.bourse.renouv.dto.dashboard.DashboardDto;

public class DashboardFacadeTest extends AbstractTest {


	@Autowired
	private DashboardFacade dashboardFacade;

	public DashboardFacadeTest() {
		this.dataSetFileList.add("pays.xml");
		this.dataSetFileList.add("profil.xml");
		this.dataSetFileList.add("sexe.xml");
		this.dataSetFileList.add("serie.xml");
		this.dataSetFileList.add("statut.xml");
		this.dataSetFileList.add("bourse.xml");
		this.dataSetFileList.add("boursier.xml");
	}

	@Test
	public void testLoadDashboard(){

		final DashboardDto dash = dashboardFacade.loadDashboard();
		assertNotNull(dash);
	}

}
