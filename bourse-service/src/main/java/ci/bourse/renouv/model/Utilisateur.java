package ci.bourse.renouv.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ci.bourse.renouv.constant.ModelConstant;

/**
 * @author euchoux
 */
@Entity
@Table(name = "Utilisateur")
public class Utilisateur extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private Integer id;

	@Column(name = "us_nom", nullable = false, length = ModelConstant.LENGTH_60)
	private String nom;

	@Column(name = "us_prenoms", nullable = false, length = ModelConstant.LENGTH_300)
	private String prenoms;

	@Column(name = "us_login", nullable = false, length = ModelConstant.LENGTH_25)
	private String login;

	@Column(name = "us_date_naissance")
	private Date dateNaissance;

	@Column(name = "us_mdp")
	private String password;

	@Column(name = "us_telephone", length = ModelConstant.LENGTH_25)
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "pays_id", nullable = false)
	private Pays pays;

	@ManyToOne
	@JoinColumn(name = "sexe_id", nullable = false)
	private Sexe sexe;

	@ManyToOne
	@JoinColumn(name = "profil_id", nullable = false)
	private Profil profil;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Utilisateur_Pays",
			joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "pays_id"))
	private Set<Pays> paysGestion;

	@Column(name = "us_date_derniere_connexion")
	private Timestamp dateDerniereConnexion;

	@Column(name = "us_nombre_tentatifs")
	private Integer nbTentatifsRestant;

	@Column(name = "us_compte_bloque")
	private boolean compteBloque;

	@Column(name = "us_supprime")
	private boolean supprime;

	public Utilisateur() {
		super();
	}

	public Integer getId() {
		return id;
	}

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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}


	/**
	 * @return the sexe
	 */
	public Sexe getSexe() {
		return sexe;
	}


	/**
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(final Sexe sexe) {
		this.sexe = sexe;
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
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * @param pays
	 *            the pays to set
	 */
	public void setPays(final Pays pays) {
		this.pays = pays;
	}

	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil
	 *            the profil to set
	 */
	public void setProfil(final Profil profil) {
		this.profil = profil;
	}

	/**
	 * @return the paysGestion
	 */
	public Set<Pays> getPaysGestion() {
		return paysGestion;
	}

	/**
	 * @param paysGestion
	 *            the paysGestion to set
	 */
	public void setPaysGestion(final Set<Pays> paysGestion) {
		this.paysGestion = paysGestion;
	}

	/**
	 * @return the dateDerniereConnexion
	 */
	public Timestamp getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}

	/**
	 * @param dateDerniereConnexion
	 *            the dateDerniereConnexion to set
	 */
	public void setDateDerniereConnexion(final Timestamp dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

	/**
	 * @return the nbTentatifsRestant
	 */
	public Integer getNbTentatifsRestant() {
		return nbTentatifsRestant;
	}

	/**
	 * @param nbTentatifsRestant
	 *            the nbTentatifsRestant to set
	 */
	public void setNbTentatifsRestant(final Integer nbTentatifsRestant) {
		this.nbTentatifsRestant = nbTentatifsRestant;
	}

	/**
	 * @return the compteBloque
	 */
	public boolean isCompteBloque() {
		return compteBloque;
	}

	/**
	 * @param compteBloque
	 *            the compteBloque to set
	 */
	public void setCompteBloque(final boolean compteBloque) {
		this.compteBloque = compteBloque;
	}

	/**
	 * @return the supprime
	 */
	public boolean isSupprime() {
		return supprime;
	}

	/**
	 * @param supprime
	 *            the supprime to set
	 */
	public void setSupprime(final boolean supprime) {
		this.supprime = supprime;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenoms == null) ? 0 : prenoms.hashCode());
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
		final Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (prenoms == null) {
			if (other.prenoms != null) {
				return false;
			}
		} else if (!prenoms.equals(other.prenoms)) {
			return false;
		}
		return true;
	}


}
