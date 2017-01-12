/**
 * 
 */
package ci.bourse.renouv.dto.dashboard;

import java.io.Serializable;

/**
 * @author euchoux
 *
 */
public class DashBoardBoursierDto implements Serializable {

	private static final long serialVersionUID = -3989932847660789603L;

	private Integer nbTotalBoursier;

	private Integer nbDemandesNonSoumises;

	private Integer nbDemandesEnAttenteAmbassade;

	private Integer nbDemandesEnAttenteFicheConfidentielle;

	private Integer nbDemandesEnAttenteDirectionBourses;

	public DashBoardBoursierDto() {
		super();
		nbTotalBoursier = Integer.valueOf(0);
		nbDemandesNonSoumises = Integer.valueOf(0);
		nbDemandesEnAttenteAmbassade = Integer.valueOf(0);
		nbDemandesEnAttenteFicheConfidentielle = Integer.valueOf(0);
		nbDemandesEnAttenteDirectionBourses = Integer.valueOf(0);
	}

	/**
	 * @return the nbTotalBoursier
	 */
	public Integer getNbTotalBoursier() {
		return nbTotalBoursier;
	}

	/**
	 * @param nbTotalBoursier
	 *            the nbTotalBoursier to set
	 */
	public void setNbTotalBoursier(final Integer nbTotalBoursier) {
		this.nbTotalBoursier = nbTotalBoursier;
	}

	/**
	 * @return the nbDemandesNonSoumises
	 */
	public Integer getNbDemandesNonSoumises() {
		return nbDemandesNonSoumises;
	}

	/**
	 * @param nbDemandesNonSoumises
	 *            the nbDemandesNonSoumises to set
	 */
	public void setNbDemandesNonSoumises(final Integer nbDemandesNonSoumises) {
		this.nbDemandesNonSoumises = nbDemandesNonSoumises;
	}

	/**
	 * @return the nbDemandesEnAttenteAmbassade
	 */
	public Integer getNbDemandesEnAttenteAmbassade() {
		return nbDemandesEnAttenteAmbassade;
	}

	/**
	 * @param nbDemandesEnAttenteAmbassade
	 *            the nbDemandesEnAttenteAmbassade to set
	 */
	public void setNbDemandesEnAttenteAmbassade(final Integer nbDemandesEnAttenteAmbassade) {
		this.nbDemandesEnAttenteAmbassade = nbDemandesEnAttenteAmbassade;
	}

	/**
	 * @return the nbDemandesEnAttenteFicheConfidentielle
	 */
	public Integer getNbDemandesEnAttenteFicheConfidentielle() {
		return nbDemandesEnAttenteFicheConfidentielle;
	}

	/**
	 * @param nbDemandesEnAttenteFicheConfidentielle
	 *            the nbDemandesEnAttenteFicheConfidentielle to set
	 */
	public void setNbDemandesEnAttenteFicheConfidentielle(final Integer nbDemandesEnAttenteFicheConfidentielle) {
		this.nbDemandesEnAttenteFicheConfidentielle = nbDemandesEnAttenteFicheConfidentielle;
	}

	/**
	 * @return the nbDemandesEnAttenteDirectionBourses
	 */
	public Integer getNbDemandesEnAttenteDirectionBourses() {
		return nbDemandesEnAttenteDirectionBourses;
	}

	/**
	 * @param nbDemandesEnAttenteDirectionBourses
	 *            the nbDemandesEnAttenteDirectionBourses to set
	 */
	public void setNbDemandesEnAttenteDirectionBourses(final Integer nbDemandesEnAttenteDirectionBourses) {
		this.nbDemandesEnAttenteDirectionBourses = nbDemandesEnAttenteDirectionBourses;
	}

}
