package ci.bourse.renouv.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ci.bourse.renouv.constant.ModelConstant;

/**
 * @author euchoux
 */
@Entity
@Table(name = "Boursier")
public class Boursier extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "boursier_id", nullable = false)
	private Integer id;

	@Column(name = "br_nom", nullable = false, length = ModelConstant.LENGTH_60)
	private String nom;

	@Column(name = "br_prenoms", nullable = false, length = ModelConstant.LENGTH_300)
	private String prenoms;

	@Column(name = "br_date_naissance", nullable = false)
	private Date dateNaissance;

	@Column(name = "br_date_attribution", nullable = false)
	private Date dateAttribution;

	@Column(name = "br_numero_carte_etudiant", length = ModelConstant.LENGTH_30)
	private String numeroCarteEtudiant;

	@Column(name = "br_nationalite", nullable = false, length = ModelConstant.LENGTH_100)
	private String nationalite;

	@Column(name = "br_mail", length = ModelConstant.LENGTH_100)
	private String mail;

	@Column(name = "br_numero_carte_identite", length = ModelConstant.LENGTH_60)
	private String numeroCarteIdentite;

	@Column(name = "br_telephone", length = ModelConstant.LENGTH_30)
	private String telephone;

	@Column(name = "br_lieu_naissance", nullable = false, length = ModelConstant.LENGTH_100)
	private String lieuNaissance;

	@Column(name = "br_annee_obtention_bac", nullable = false, length = ModelConstant.LENGTH_4)
	private String anneeObtentionBac;

	@Column(name = "br_numero_attestion_bac", length = ModelConstant.LENGTH_25)
	private String numeroAttestationBac;

	@ManyToOne
	@JoinColumn(name = "bourse_id", nullable = false)
	private Bourse bourse;

	@ManyToOne
	@JoinColumn(name = "pays_id", nullable = false)
	private Pays pays;

	@ManyToOne
	@JoinColumn(name = "sexe_id", nullable = false)
	private Sexe sexe;

	public Boursier() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(final String prenoms) {
		this.prenoms = prenoms;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(final Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateAttribution() {
		return dateAttribution;
	}

	public void setDateAttribution(final Date dateAttribution) {
		this.dateAttribution = dateAttribution;
	}

	public String getNumeroCarteEtudiant() {
		return numeroCarteEtudiant;
	}

	public void setNumeroCarteEtudiant(final String numeroCarteEtudiant) {
		this.numeroCarteEtudiant = numeroCarteEtudiant;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(final String nationalite) {
		this.nationalite = nationalite;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(final String mail) {
		this.mail = mail;
	}

	public String getNumeroCarteIdentite() {
		return numeroCarteIdentite;
	}

	public void setNumeroCarteIdentite(final String numeroCarteIdentite) {
		this.numeroCarteIdentite = numeroCarteIdentite;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(final String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getAnneeObtentionBac() {
		return anneeObtentionBac;
	}

	public void setAnneeObtentionBac(final String anneeObtentionBac) {
		this.anneeObtentionBac = anneeObtentionBac;
	}

	public String getNumeroAttestationBac() {
		return numeroAttestationBac;
	}

	public void setNumeroAttestationBac(final String numeroAttestationBac) {
		this.numeroAttestationBac = numeroAttestationBac;
	}

	public Bourse getBourse() {
		return bourse;
	}

	public void setBourse(final Bourse bourse) {
		this.bourse = bourse;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(final Pays pays) {
		this.pays = pays;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(final Sexe sexe) {
		this.sexe = sexe;
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
		final Boursier other = (Boursier) obj;
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
