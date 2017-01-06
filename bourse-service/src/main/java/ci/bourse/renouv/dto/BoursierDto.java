package ci.bourse.renouv.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author euchoux
 */
public class BoursierDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String nom;

	private String prenoms;

	private Date dateNaissance;

	private Date dateAttribution;

	private String numeroCarteEtudiant;

	private String nationalite;

	private String mail;

	private String numeroCarteIdentite;

	private String telephone;

	private String lieuNaissance;

	private String anneeObtentionBac;

	private String numeroAttestationBac;

	private BourseDto bourse;

	private PaysDto pays;

	private SexeDto sexe;

	public BoursierDto() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenoms
	 *            the prenoms to set
	 */
	public void setPrenoms(final String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(final Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the dateAttribution
	 */
	public Date getDateAttribution() {
		return dateAttribution;
	}

	/**
	 * @param dateAttribution
	 *            the dateAttribution to set
	 */
	public void setDateAttribution(final Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}

	/**
	 * @return the numeroCarteEtudiant
	 */
	public String getNumeroCarteEtudiant() {
		return numeroCarteEtudiant;
	}

	/**
	 * @param numeroCarteEtudiant
	 *            the numeroCarteEtudiant to set
	 */
	public void setNumeroCarteEtudiant(final String numeroCarteEtudiant) {
		this.numeroCarteEtudiant = numeroCarteEtudiant;
	}

	/**
	 * @return the nationalite
	 */
	public String getNationalite() {
		return nationalite;
	}

	/**
	 * @param nationalite
	 *            the nationalite to set
	 */
	public void setNationalite(final String nationalite) {
		this.nationalite = nationalite;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * @return the numeroCarteIdentite
	 */
	public String getNumeroCarteIdentite() {
		return numeroCarteIdentite;
	}

	/**
	 * @param numeroCarteIdentite
	 *            the numeroCarteIdentite to set
	 */
	public void setNumeroCarteIdentite(final String numeroCarteIdentite) {
		this.numeroCarteIdentite = numeroCarteIdentite;
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
	 * @return the lieuNaissance
	 */
	public String getLieuNaissance() {
		return lieuNaissance;
	}

	/**
	 * @param lieuNaissance
	 *            the lieuNaissance to set
	 */
	public void setLieuNaissance(final String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
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
	 * @return the numeroAttestationBac
	 */
	public String getNumeroAttestationBac() {
		return numeroAttestationBac;
	}

	/**
	 * @param numeroAttestationBac
	 *            the numeroAttestationBac to set
	 */
	public void setNumeroAttestationBac(final String numeroAttestationBac) {
		this.numeroAttestationBac = numeroAttestationBac;
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
	 * @return the paysDto
	 */
	public PaysDto getPays() {
		return pays;
	}

	/**
	 * @param paysDto
	 *            the paysDto to set
	 */
	public void setPays(final PaysDto paysDto) {
		this.pays = paysDto;
	}

	/**
	 * @return the sexeDto
	 */
	public SexeDto getSexe() {
		return sexe;
	}

	/**
	 * @param sexeDto
	 *            the sexeDto to set
	 */
	public void setSexe(final SexeDto sexeDto) {
		this.sexe = sexeDto;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lieuNaissance == null) ? 0 : lieuNaissance.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		final BoursierDto other = (BoursierDto) obj;
		if (dateNaissance == null) {
			if (other.dateNaissance != null) {
				return false;
			}
		} else if (!dateNaissance.equals(other.dateNaissance)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (lieuNaissance == null) {
			if (other.lieuNaissance != null) {
				return false;
			}
		} else if (!lieuNaissance.equals(other.lieuNaissance)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		return true;
	}


}
