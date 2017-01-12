package ci.bourse.renouv.facade;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import ci.bourse.renouv.AbstractTest;
import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.dto.SexeDto;

public class NomenclatureFacadeTest extends AbstractTest {


	@Autowired
	private NomenclatureFacade nomenclatureFacade;

	public NomenclatureFacadeTest() {
	}

	/**
	 * Test simple utilisant AssertJ-DB.
	 */
	@Test
	@DatabaseSetup("file:src/test/resources/datas/pays.xml")
	public void testTrouverPaysParId() {
		final PaysDto pays = nomenclatureFacade.trouverPaysParId(1);
		assertEquals("AL", pays.getCode());
	}

	@Test
	@DatabaseSetup("file:src/test/resources/datas/sexe.xml")
	public void testTrouverSexeParId() {
		final SexeDto sexe = nomenclatureFacade.trouverSexeParId(2);
		assertEquals("F", sexe.getCode());
	}

	@Test
	@DatabaseSetup("file:src/test/resources/datas/profil.xml")
	public void testTrouverProfilParCode() {
		final ProfilDto profil = nomenclatureFacade.trouverProfilParCode("GMI");
		assertEquals("ROLE_GES_MINISTERE", profil.getLibelle());
	}

}
