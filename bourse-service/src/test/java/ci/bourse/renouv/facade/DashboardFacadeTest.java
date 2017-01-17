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
		this.dataSetFileList.add("niveau.xml");
		this.dataSetFileList.add("utilisateur.xml");
		this.dataSetFileList.add("utilisateur_pays.xml");
		this.dataSetFileList.add("bourse.xml");
		this.dataSetFileList.add("boursier.xml");
		this.dataSetFileList.add("fiche_confidentielle.xml");
		this.dataSetFileList.add("renouvellement.xml");
	}

	@Test
	public void testLoadDashboard(){

		final DashboardDto dash = dashboardFacade.loadDashboard(2017);
		assertNotNull(dash);
		assertEquals(Integer.valueOf(7), dash.getDashBoursiers().getNbTotalBoursier());
		assertEquals(Integer.valueOf(4),
				dash.getDashBoursiers().getNbEnAttenteValidationAmbassade());
		assertEquals(Integer.valueOf(1),
				dash.getDashBoursiers().getNbEnAttenteValidationDob());
		assertEquals(Integer.valueOf(2),
				dash.getDashBoursiers().getNbDemandesNonSoumises());

		assertEquals(4, dash.getNbBoursierParPays().size());
		assertEquals(Integer.valueOf(2), dash.getNbBoursierParPays().get("MA"));
		assertEquals(Integer.valueOf(1), dash.getNbBoursierParPays().get("CI"));
		assertEquals(Integer.valueOf(2), dash.getNbBoursierParPays().get("AL"));
		assertEquals(Integer.valueOf(2), dash.getNbBoursierParPays().get("FR"));

		assertEquals(Integer.valueOf(4),
				dash.getNbDemandesEnAttenteFicheConfidentielle());
		assertEquals(Double.valueOf(20), dash.getPourcentageDemandesRefusees());
		assertEquals(Double.valueOf(20), dash.getPourcentageDocumentsManquants());

		assertEquals(5, dash.getMontantBourseParAnnee().size());
		assertEquals(Double.valueOf(0), dash.getMontantBourseParAnnee().get("2013"));
		assertEquals(Double.valueOf(12500000),
				dash.getMontantBourseParAnnee().get("2014"));
		assertEquals(Double.valueOf(6300500),
				dash.getMontantBourseParAnnee().get("2015"));
		assertEquals(Double.valueOf(14500000),
				dash.getMontantBourseParAnnee().get("2016"));
		assertEquals(Double.valueOf(0), dash.getMontantBourseParAnnee().get("2017"));
	}

}
