package ci.bourse.renouv.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author euchoux
 */
public class RenouvellementDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private Timestamp dateSoumission;

	private String specialite;

	private String diplomePrepare;

	private Integer dureeFormation;

	private String etablissement;

	private BourseDto bourse;

	private StatutDto statut;

	private NiveauDto niveau;

	private FicheConfidentielleDto ficheConfidentielle;

	public RenouvellementDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the dateSoumission
	 */
	public Timestamp getDateSoumission() {
		return dateSoumission;
	}

	/**
	 * @param dateSoumission
	 *            the dateSoumission to set
	 */
	public void setDateSoumission(final Timestamp dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	/**
	 * @return the specialite
	 */
	public String getSpecialite() {
		return specialite;
	}

	/**
	 * @param specialite
	 *            the specialite to set
	 */
	public void setSpecialite(final String specialite) {
		this.specialite = specialite;
	}

	/**
	 * @return the diplomePrepare
	 */
	public String getDiplomePrepare() {
		return diplomePrepare;
	}

	/**
	 * @param diplomePrepare
	 *            the diplomePrepare to set
	 */
	public void setDiplomePrepare(final String diplomePrepare) {
		this.diplomePrepare = diplomePrepare;
	}

	/**
	 * @return the dureeFormation
	 */
	public Integer getDureeFormation() {
		return dureeFormation;
	}

	/**
	 * @param dureeFormation
	 *            the dureeFormation to set
	 */
	public void setDureeFormation(final Integer dureeFormation) {
		this.dureeFormation = dureeFormation;
	}

	/**
	 * @return the etablissement
	 */
	public String getEtablissement() {
		return etablissement;
	}

	/**
	 * @param etablissement
	 *            the etablissement to set
	 */
	public void setEtablissement(final String etablissement) {
		this.etablissement = etablissement;
	}

	/**
	 * @return the bourseDto
	 */
	public BourseDto getBourse() {
		return bourse;
	}

	/**
	 * @param bourseDto
	 *            the bourseDto to set
	 */
	public void setBourse(final BourseDto bourseDto) {
		this.bourse = bourseDto;
	}

	/**
	 * @return the statutDto
	 */
	public StatutDto getStatut() {
		return statut;
	}

	/**
	 * @param statutDto
	 *            the statutDto to set
	 */
	public void setStatut(final StatutDto statutDto) {
		this.statut = statutDto;
	}

	/**
	 * @return the niveauDto
	 */
	public NiveauDto getNiveau() {
		return niveau;
	}

	/**
	 * @param niveauDto
	 *            the niveauDto to set
	 */
	public void setNiveau(final NiveauDto niveauDto) {
		this.niveau = niveauDto;
	}

	/**
	 * @return the ficheConfidentielleDto
	 */
	public FicheConfidentielleDto getFicheConfidentielle() {
		return ficheConfidentielle;
	}

	/**
	 * @param ficheConfidentielleDto
	 *            the ficheConfidentielleDto to set
	 */
	public void setFicheConfidentielle(final FicheConfidentielleDto ficheConfidentielleDto) {
		this.ficheConfidentielle = ficheConfidentielleDto;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bourse == null) ? 0 : bourse.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final RenouvellementDto other = (RenouvellementDto) obj;
		if (bourse == null) {
			if (other.bourse != null) {
				return false;
			}
		} else if (!bourse.equals(other.bourse)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}


}
