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

	private DashBoardBoursierDto dashBoursiers;

	public DashboardDto() {
		super();
		nbBoursierParPays = new HashMap<String, Integer>();
		montantBourseParAnnee = new HashMap<String, Double>();
		pourcentageDemandesRefusees = Double.valueOf(0);
		pourcentageDocumentsManquants = Double.valueOf(0);
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

}
