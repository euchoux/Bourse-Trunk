package ci.bourse.renouv.facade;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ci.bourse.renouv.AbstractTest;
import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.dto.SexeDto;

public class NomenclatureFacadeTest extends AbstractTest {


	@Autowired
	private NomenclatureFacade nomenclatureFacade;

	public NomenclatureFacadeTest() {
		this.dataSetFileList.add("pays.xml");
		this.dataSetFileList.add("sexe.xml");
		this.dataSetFileList.add("profil.xml");
	}

	/**
	 * Test simple utilisant AssertJ-DB.
	 */
	@Test
	public void testTrouverPaysParId() {
		final PaysDto pays = nomenclatureFacade.trouverPaysParId(101);
		assertEquals("AL", pays.getCode());
	}

	@Test
	public void testFindAllPays() {
		final List<PaysDto> list = nomenclatureFacade.findAllPays();
		assertEquals(4, list.size());
	}

	@Test
	public void testTrouverSexeParId() {
		final SexeDto sexe = nomenclatureFacade.trouverSexeParId(102);
		assertEquals("F", sexe.getCode());
	}

	@Test
	public void testFindAllSexe() {
		final List<SexeDto> list = nomenclatureFacade.findAllSexe();
		assertEquals(2, list.size());
	}

	@Test
	public void testTrouverProfilParCode() {
		final ProfilDto profil = nomenclatureFacade.trouverProfilParCode("GMI");
		assertEquals("ROLE_GES_MINISTERE", profil.getLibelle());
	}

	@Test
	public void testFindAllProfil() {
		final List<ProfilDto> list = nomenclatureFacade.findAllProfil();
		assertEquals(7, list.size());
	}

}
