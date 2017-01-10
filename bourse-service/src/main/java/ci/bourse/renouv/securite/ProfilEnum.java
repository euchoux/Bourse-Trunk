/**
 * 
 */
package ci.bourse.renouv.securite;


/**
 * @author euchoux
 *
 */
public enum ProfilEnum {
	ROLE_ADMIN_BOURSE("Administrateur"), ROLE_ADMIN_MINISTERE("Administrateur"), ROLE_GES_AMBASSADE(
			"Personnel ambassade"), ROLE_GES_BOURSE("Gestionnaire"), ROLE_GES_MINISTERE(
					"Gestionnaire"), ROLE_CONSULTATION("Consultation"), ROLE_AUTRE("Autre");

	private final String libelle;

	private ProfilEnum(final String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

}
