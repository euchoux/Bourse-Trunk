package ci.bourse.renouv.facade;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ci.bourse.renouv.AbstractTest;
import ci.bourse.renouv.dto.PaysDto;
import ci.bourse.renouv.dto.ProfilDto;
import ci.bourse.renouv.dto.SexeDto;
import ci.bourse.renouv.dto.UtilisateurDto;
import ci.bourse.renouv.exception.MetierException;
import ci.bourse.renouv.utils.PasswordUtils;

public class UtilisateurFacadeTest extends AbstractTest {

	@Autowired
	private UtilisateurFacade utilisateurFacade;

	public UtilisateurFacadeTest() {
		this.dataSetFileList.add("pays.xml");
		this.dataSetFileList.add("profil.xml");
		this.dataSetFileList.add("sexe.xml");
		this.dataSetFileList.add("utilisateur.xml");
		this.dataSetFileList.add("utilisateur_pays.xml");
	}

	@Test
	public void testCreerUtilisateur(){

		// Test Cas nominal
		final UtilisateurDto utilisateur = buildUtilisateurDto();
		utilisateur.setLogin("MonTest");

		try {
			utilisateurFacade.creerUtilisateur(utilisateur);
		} catch (final MetierException e) {
			e.printStackTrace();
		}

		// Test de création de l'utilisation.
		assertNotNull(utilisateurFacade.findByLogin("MonTest"));

		// Test envoi d'un login existant
		try {
			utilisateurFacade.creerUtilisateur(utilisateur);
		} catch (final MetierException e) {
			assert (e.getMessage()
					.contains("Un compte avec le même utilisateur existe."));
		}
	}

	@Test
	public void testModifierUtilisateur(){

		final UtilisateurDto utilisateur = utilisateurFacade.findById(102);
		// Avant modification du nom
		assertEquals("ALAIN", utilisateur.getNom());

		// Test modification du nom
		utilisateur.setNom("nom");
		final PaysDto pays2 = new PaysDto();
		pays2.setId(102);
		//
		final Set<PaysDto> setPays = new HashSet<PaysDto>();
		setPays.add(pays2);

		utilisateur.setPaysGestion(setPays);

		utilisateurFacade.modifierUtilisateur(utilisateur);

		final UtilisateurDto result = utilisateurFacade.findById(102);
		// On vérifie que le nom a bien changé.
		assertEquals("nom", result.getNom());
		assertEquals(1, result.getPaysGestion().size());
	}

	private UtilisateurDto buildUtilisateurDto(){
		final UtilisateurDto utilisateur = new UtilisateurDto();

		utilisateur.setNom("nom");
		utilisateur.setPrenoms("prenoms");
		utilisateur.setTelephone("093444");
		utilisateur.setPassword(PasswordUtils.hacherMessageSHA256("test", "fff"));

		final PaysDto pays = new PaysDto();
		pays.setId(102);

		final ProfilDto profil = new ProfilDto();
		profil.setId(105);

		final SexeDto sexe = new SexeDto();
		sexe.setId(101);

		utilisateur.setPays(pays);
		utilisateur.setProfil(profil);
		utilisateur.setSexe(sexe);
		utilisateur.setCompteBloque(false);
		utilisateur.setDateDerniereConnexion(new Timestamp(new Date().getTime()));
		utilisateur.setDateNaissance(new Timestamp(new Date().getTime()));
		return utilisateur;
	}

}
