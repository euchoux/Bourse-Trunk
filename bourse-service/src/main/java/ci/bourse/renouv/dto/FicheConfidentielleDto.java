package ci.bourse.renouv.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author euchoux
 */
public class FicheConfidentielleDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String adresse;

	private String nomEtablissement;

	private String departement;

	private Date dateInscription;

	private String specialiteFormation;

	private Integer dureeFormation;

	private String typeExamen;

	private String themeMemoire;

	private String telephone;

	private String diplomeEnvisage;

	private String anneeObtentionBac;

	private Date dateObtentionDiplome;

	private String resumeEvolutionTravail;

	private BoursierDto boursier;

	private UtilisateurDto rapporteur;

	private NiveauDto niveau;

	private RenouvellementDto renouvellement;

	public FicheConfidentielleDto() {
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
	 * @return the boursierDto
	 */
	public BoursierDto getBoursier() {
		return boursier;
	}

	/**
	 * @param boursierDto
	 *            the boursierDto to set
	 */
	public void setBoursier(final BoursierDto boursierDto) {
		this.boursier = boursierDto;
	}

	/**
	 * @return the rapporteurDto
	 */
	public UtilisateurDto getRapporteur() {
		return rapporteur;
	}

	/**
	 * @param rapporteurDto
	 *            the rapporteurDto to set
	 */
	public void setRapporteur(final UtilisateurDto rapporteurDto) {
		this.rapporteur = rapporteurDto;
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
	 * @return the renouvellementDto
	 */
	public RenouvellementDto getRenouvellement() {
		return renouvellement;
	}

	/**
	 * @param renouvellementDto
	 *            the renouvellementDto to set
	 */
	public void setRenouvellement(final RenouvellementDto renouvellementDto) {
		this.renouvellement = renouvellementDto;
	}

	/**
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
		final FicheConfidentielleDto other = (FicheConfidentielleDto) obj;
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
