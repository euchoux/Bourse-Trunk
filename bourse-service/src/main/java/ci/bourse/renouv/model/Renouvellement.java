package ci.bourse.renouv.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ci.bourse.renouv.constant.ModelConstant;

/**
 * @author euchoux
 */
@Entity
@Table(name = "Renouvellement")
public class Renouvellement extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "revouv_id", nullable = false)
	private Integer id;

	@Column(name = "re_date_soumission", nullable = false)
	private Timestamp dateSoumission;

	@Column(name = "re_specialite", length = ModelConstant.LENGTH_100)
	private String specialite;

	@Column(name = "re_diplome_prepare", nullable = false, length = ModelConstant.LENGTH_100)
	private String diplomePrepare;

	@Column(name = "re_duree_formation", nullable = false)
	private Integer dureeFormation;

	@Column(name = "re_etablissement", nullable = false, length = ModelConstant.LENGTH_300)
	private String etablissement;

	@ManyToOne
	@JoinColumn(name = "bourse_id", nullable = false)
	private Bourse bourse;

	@ManyToOne
	@JoinColumn(name = "statut_id", nullable = false)
	private Statut statut;

	@ManyToOne
	@JoinColumn(name = "niveau_id", nullable = false)
	private Niveau niveau;

	@OneToOne
	@JoinColumn(name = "fiche_id")
	private FicheConfidentielle ficheConfidentielle;

	public Renouvellement() {
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
	 * @return the bourse
	 */
	public Bourse getBourse() {
		return bourse;
	}

	/**
	 * @param bourse
	 *            the bourse to set
	 */
	public void setBourse(final Bourse bourse) {
		this.bourse = bourse;
	}

	/**
	 * @return the statut
	 */
	public Statut getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(final Statut statut) {
		this.statut = statut;
	}

	/**
	 * @return the niveau
	 */
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau
	 *            the niveau to set
	 */
	public void setNiveau(final Niveau niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the ficheConfidentielle
	 */
	public FicheConfidentielle getFicheConfidentielle() {
		return ficheConfidentielle;
	}

	/**
	 * @param ficheConfidentielle
	 *            the ficheConfidentielle to set
	 */
	public void setFicheConfidentielle(final FicheConfidentielle ficheConfidentielle) {
		this.ficheConfidentielle = ficheConfidentielle;
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
		final Renouvellement other = (Renouvellement) obj;
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
