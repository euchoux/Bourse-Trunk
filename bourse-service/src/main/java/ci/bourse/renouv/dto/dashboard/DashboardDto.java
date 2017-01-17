package ci.bourse.renouv.dto.dashboard;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author euchoux
 */
public class DashboardDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Map<String, Integer> nbBoursierParPays;

	private Map<String, Double> montantBourseParAnnee;

	private Double pourcentageDemandesRefusees;

	private Double pourcentageDocumentsManquants;

	private Integer nbDemandesEnAttenteFicheConfidentielle;

	private DashBoardBoursierDto dashBoursiers;

	public DashboardDto() {
		super();
		nbBoursierParPays = new HashMap<String, Integer>();
		montantBourseParAnnee = new HashMap<String, Double>();
		pourcentageDemandesRefusees = Double.valueOf(0);
		pourcentageDocumentsManquants = Double.valueOf(0);
		nbDemandesEnAttenteFicheConfidentielle = Integer.valueOf(0);
		dashBoursiers = new DashBoardBoursierDto();
	}

	/**
	 * @return the nbBoursierParPays
	 */
	public Map<String, Integer> getNbBoursierParPays() {
		return nbBoursierParPays;
	}

	/**
	 * @param nbBoursierParPays
	 *            the nbBoursierParPays to set
	 */
	public void setNbBoursierParPays(final Map<String, Integer> nbBoursierParPays) {
		this.nbBoursierParPays = nbBoursierParPays;
	}

	/**
	 * @return the montantBourseParAnnee
	 */
	public Map<String, Double> getMontantBourseParAnnee() {
		return montantBourseParAnnee;
	}

	/**
	 * @param montantBourseParAnnee
	 *            the montantBourseParAnnee to set
	 */
	public void setMontantBourseParAnnee(final Map<String, Double> montantBourseParAnnee) {
		this.montantBourseParAnnee = montantBourseParAnnee;
	}

	/**
	 * @return the pourcentageDemandesRefusees
	 */
	public Double getPourcentageDemandesRefusees() {
		return pourcentageDemandesRefusees;
	}

	/**
	 * @param pourcentageDemandesRefusees
	 *            the pourcentageDemandesRefusees to set
	 */
	public void setPourcentageDemandesRefusees(final Double pourcentageDemandesRefusees) {
		this.pourcentageDemandesRefusees = pourcentageDemandesRefusees;
	}

	/**
	 * @return the pourcentageDocumentsManquants
	 */
	public Double getPourcentageDocumentsManquants() {
		return pourcentageDocumentsManquants;
	}

	/**
	 * @param pourcentageDocumentsManquants
	 *            the pourcentageDocumentsManquants to set
	 */
	public void setPourcentageDocumentsManquants(final Double pourcentageDocumentsManquants) {
		this.pourcentageDocumentsManquants = pourcentageDocumentsManquants;
	}

	/**
	 * @return the nbDemandesEnAttenteFicheConfidentielle
	 */
	public Integer getNbDemandesEnAttenteFicheConfidentielle(){
		return nbDemandesEnAttenteFicheConfidentielle;
	}

	/**
	 * @param nbDemandesEnAttenteFicheConfidentielle
	 *            the nbDemandesEnAttenteFicheConfidentielle to set
	 */
	public void setNbDemandesEnAttenteFicheConfidentielle(
			final Integer nbDemandesEnAttenteFicheConfidentielle){
		this.nbDemandesEnAttenteFicheConfidentielle = nbDemandesEnAttenteFicheConfidentielle;
	}

	/**
	 * @return the dashBoursiers
	 */
	public DashBoardBoursierDto getDashBoursiers() {
		return dashBoursiers;
	}

	/**
	 * @param dashBoursiers
	 *            the dashBoursiers to set
	 */
	public void setDashBoursiers(final DashBoardBoursierDto dashBoursiers) {
		this.dashBoursiers = dashBoursiers;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((montantBourseParAnnee == null) ? 0
				: montantBourseParAnnee.hashCode());
		result = prime * result
				+ ((nbBoursierParPays == null) ? 0 : nbBoursierParPays.hashCode());
		result = prime * result + ((nbDemandesEnAttenteFicheConfidentielle == null) ? 0
				: nbDemandesEnAttenteFicheConfidentielle.hashCode());
		result = prime * result + ((pourcentageDemandesRefusees == null) ? 0
				: pourcentageDemandesRefusees.hashCode());
		result = prime * result + ((pourcentageDocumentsManquants == null) ? 0
				: pourcentageDocumentsManquants.hashCode());
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
		final DashboardDto other = (DashboardDto) obj;
		if (montantBourseParAnnee == null) {
			if (other.montantBourseParAnnee != null) {
				return false;
			}
		} else if (!montantBourseParAnnee.equals(other.montantBourseParAnnee)) {
			return false;
		}
		if (nbBoursierParPays == null) {
			if (other.nbBoursierParPays != null) {
				return false;
			}
		} else if (!nbBoursierParPays.equals(other.nbBoursierParPays)) {
			return false;
		}
		if (nbDemandesEnAttenteFicheConfidentielle == null) {
			if (other.nbDemandesEnAttenteFicheConfidentielle != null) {
				return false;
			}
		} else if (!nbDemandesEnAttenteFicheConfidentielle
				.equals(other.nbDemandesEnAttenteFicheConfidentielle)) {
			return false;
		}
		if (pourcentageDemandesRefusees == null) {
			if (other.pourcentageDemandesRefusees != null) {
				return false;
			}
		} else if (!pourcentageDemandesRefusees
				.equals(other.pourcentageDemandesRefusees)) {
			return false;
		}
		if (pourcentageDocumentsManquants == null) {
			if (other.pourcentageDocumentsManquants != null) {
				return false;
			}
		} else if (!pourcentageDocumentsManquants
				.equals(other.pourcentageDocumentsManquants)) {
			return false;
		}
		return true;
	}

}
