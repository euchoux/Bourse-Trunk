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

	private Integer nbEnAttenteValidationAmbassade;

	private Integer nbEnAttenteValidationDob;

	public DashBoardBoursierDto() {
		super();
		nbTotalBoursier = Integer.valueOf(0);
		nbDemandesNonSoumises = Integer.valueOf(0);
		nbEnAttenteValidationAmbassade = Integer.valueOf(0);
		nbEnAttenteValidationDob = Integer.valueOf(0);
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
	public Integer getNbEnAttenteValidationAmbassade(){
		return nbEnAttenteValidationAmbassade;
	}

	/**
	 * @param nbDemandesEnAttenteAmbassade
	 *            the nbDemandesEnAttenteAmbassade to set
	 */
	public void setNbEnAttenteValidationAmbassade(
			final Integer nbEnAttenteValidationAmbassade){
		this.nbEnAttenteValidationAmbassade = nbEnAttenteValidationAmbassade;
	}

	/**
	 * @return the nbDemandesEnAttenteDirectionBourses
	 */
	public Integer getNbEnAttenteValidationDob(){
		return nbEnAttenteValidationDob;
	}

	/**
	 * @param nbDemandesEnAttenteDirectionBourses
	 *            the nbDemandesEnAttenteDirectionBourses to set
	 */
	public void setNbEnAttenteValidationDob(final Integer nbEnAttenteValidationDob){
		this.nbEnAttenteValidationDob = nbEnAttenteValidationDob;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nbDemandesNonSoumises == null) ? 0
				: nbDemandesNonSoumises.hashCode());
		result = prime * result + ((nbEnAttenteValidationAmbassade == null) ? 0
				: nbEnAttenteValidationAmbassade.hashCode());
		result = prime * result + ((nbEnAttenteValidationDob == null) ? 0
				: nbEnAttenteValidationDob.hashCode());
		result = prime * result
				+ ((nbTotalBoursier == null) ? 0 : nbTotalBoursier.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj){
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DashBoardBoursierDto other = (DashBoardBoursierDto) obj;
		if (nbDemandesNonSoumises == null) {
			if (other.nbDemandesNonSoumises != null) {
				return false;
			}
		} else if (!nbDemandesNonSoumises.equals(other.nbDemandesNonSoumises)) {
			return false;
		}
		if (nbEnAttenteValidationAmbassade == null) {
			if (other.nbEnAttenteValidationAmbassade != null) {
				return false;
			}
		} else if (!nbEnAttenteValidationAmbassade
				.equals(other.nbEnAttenteValidationAmbassade)) {
			return false;
		}
		if (nbEnAttenteValidationDob == null) {
			if (other.nbEnAttenteValidationDob != null) {
				return false;
			}
		} else if (!nbEnAttenteValidationDob.equals(other.nbEnAttenteValidationDob)) {
			return false;
		}
		if (nbTotalBoursier == null) {
			if (other.nbTotalBoursier != null) {
				return false;
			}
		} else if (!nbTotalBoursier.equals(other.nbTotalBoursier)) {
			return false;
		}
		return true;
	}

}
