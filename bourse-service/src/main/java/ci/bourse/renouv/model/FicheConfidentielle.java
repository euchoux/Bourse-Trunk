package ci.bourse.renouv.model;

import java.util.Date;

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
@Table(name = "Fiche_Confidentielle")
public class FicheConfidentielle extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fiche_id", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "fi_adresse_postale", length = ModelConstant.LENGTH_300)
	private String adresse;

	@Column(name = "fi_nom_etablissement", nullable = false, length = ModelConstant.LENGTH_300)
	private String nomEtablissement;

	@Column(name = "fi_departement", length = ModelConstant.LENGTH_300)
	private String departement;

	@Column(name = "fi_date_incription")
	private Date dateInscription;

	@Column(name = "fi_specialite_formation", length = ModelConstant.LENGTH_300)
	private String specialiteFormation;

	@Column(name = "fi_duree_formation", nullable = false)
	private Integer dureeFormation;

	@Column(name = "fi_type_examen", length = ModelConstant.LENGTH_100)
	private String typeExamen;

	@Column(name = "fi_theme_memoire", length = ModelConstant.LENGTH_100)
	private String themeMemoire;

	@Column(name = "fi_telephone", length = ModelConstant.LENGTH_30)
	private String telephone;

	@Column(name = "fi_diplome_envisage", nullable = false, length = ModelConstant.LENGTH_100)
	private String diplomeEnvisage;

	@Column(name = "fi_appreciation", length = ModelConstant.LENGTH_300)
	private String anneeObtentionBac;

	@Column(name = "fi_date_obtention_diplome")
	private Date dateObtentionDiplome;

	@Column(name = "fi_resume_evolution_travail", length = ModelConstant.LENGTH_300)
	private String resumeEvolutionTravail;

	@ManyToOne
	@JoinColumn(name = "boursier_id", nullable = false)
	private Boursier boursier;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Utilisateur rapporteur;

	@ManyToOne
	@JoinColumn(name = "niveau_id", nullable = false)
	private Niveau niveau;

	@OneToOne(mappedBy = "ficheConfidentielle")
	private Renouvellement renouvellement;

	public FicheConfidentielle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(final String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the nomEtablissement
	 */
	public String getNomEtablissement() {
		return nomEtablissement;
	}

	/**
	 * @param nomEtablissement
	 *            the nomEtablissement to set
	 */
	public void setNomEtablissement(final String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(final String departement) {
		this.departement = departement;
	}

	/**
	 * @return the dateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}

	/**
	 * @param dateInscription
	 *            the dateInscription to set
	 */
	public void setDateInscription(final Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	/**
	 * @return the specialiteFormation
	 */
	public String getSpecialiteFormation() {
		return specialiteFormation;
	}

	/**
	 * @param specialiteFormation
	 *            the specialiteFormation to set
	 */
	public void setSpecialiteFormation(final String specialiteFormation) {
		this.specialiteFormation = specialiteFormation;
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
	 * @return the typeExamen
	 */
	public String getTypeExamen() {
		return typeExamen;
	}

	/**
	 * @param typeExamen
	 *            the typeExamen to set
	 */
	public void setTypeExamen(final String typeExamen) {
		this.typeExamen = typeExamen;
	}

	/**
	 * @return the themeMemoire
	 */
	public String getThemeMemoire() {
		return themeMemoire;
	}

	/**
	 * @param themeMemoire
	 *            the themeMemoire to set
	 */
	public void setThemeMemoire(final String themeMemoire) {
		this.themeMemoire = themeMemoire;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the diplomeEnvisage
	 */
	public String getDiplomeEnvisage() {
		return diplomeEnvisage;
	}

	/**
	 * @param diplomeEnvisage
	 *            the diplomeEnvisage to set
	 */
	public void setDiplomeEnvisage(final String diplomeEnvisage) {
		this.diplomeEnvisage = diplomeEnvisage;
	}

	/**
	 * @return the anneeObtentionBac
	 */
	public String getAnneeObtentionBac() {
		return anneeObtentionBac;
	}

	/**
	 * @param anneeObtentionBac
	 *            the anneeObtentionBac to set
	 */
	public void setAnneeObtentionBac(final String anneeObtentionBac) {
		this.anneeObtentionBac = anneeObtentionBac;
	}

	/**
	 * @return the dateObtentionDiplome
	 */
	public Date getDateObtentionDiplome() {
		return dateObtentionDiplome;
	}

	/**
	 * @param dateObtentionDiplome
	 *            the dateObtentionDiplome to set
	 */
	public void setDateObtentionDiplome(final Date dateObtentionDiplome) {
		this.dateObtentionDiplome = dateObtentionDiplome;
	}

	/**
	 * @return the resumeEvolutionTravail
	 */
	public String getResumeEvolutionTravail() {
		return resumeEvolutionTravail;
	}

	/**
	 * @param resumeEvolutionTravail
	 *            the resumeEvolutionTravail to set
	 */
	public void setResumeEvolutionTravail(final String resumeEvolutionTravail) {
		this.resumeEvolutionTravail = resumeEvolutionTravail;
	}

	/**
	 * @return the boursier
	 */
	public Boursier getBoursier() {
		return boursier;
	}

	/**
	 * @param boursier
	 *            the boursier to set
	 */
	public void setBoursier(final Boursier boursier) {
		this.boursier = boursier;
	}

	/**
	 * @return the rapporteur
	 */
	public Utilisateur getRapporteur() {
		return rapporteur;
	}

	/**
	 * @param rapporteur
	 *            the rapporteur to set
	 */
	public void setRapporteur(final Utilisateur rapporteur) {
		this.rapporteur = rapporteur;
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
	 * @return the renouvellement
	 */
	public Renouvellement getRenouvellement() {
		return renouvellement;
	}

	/**
	 * @param renouvellement
	 *            the renouvellement to set
	 */
	public void setRenouvellement(final Renouvellement renouvellement) {
		this.renouvellement = renouvellement;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boursier == null) ? 0 : boursier.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rapporteur == null) ? 0 : rapporteur.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
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
		final FicheConfidentielle other = (FicheConfidentielle) obj;
		if (boursier == null) {
			if (other.boursier != null) {
				return false;
			}
		} else if (!boursier.equals(other.boursier)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (rapporteur == null) {
			if (other.rapporteur != null) {
				return false;
			}
		} else if (!rapporteur.equals(other.rapporteur)) {
			return false;
		}
		return true;
	}

}
