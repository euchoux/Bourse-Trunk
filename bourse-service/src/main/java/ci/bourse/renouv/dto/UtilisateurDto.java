package ci.bourse.renouv.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * @author euchoux
 */
public class UtilisateurDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String nom;

	private String prenoms;

	private String login;

	private Date dateNaissance;

	private String password;

	private String telephone;

	private PaysDto pays;

	private SexeDto sexe;

	private ProfilDto profil;

	private Set<PaysDto> paysGestion;

	private Timestamp dateDerniereConnexion;

	private Integer nbTentatifsRestant;

	private boolean compteBloque;

	private boolean supprime;

	public UtilisateurDto() {
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
	 * @return the paysDto
	 */
	public PaysDto getPays() {
		return pays;
	}

	/**
	 * @param paysDto
	 *            the pays to set
	 */
	public void setPays(final PaysDto paysDto) {
		this.pays = paysDto;
	}

	/**
	 * @return the profil
	 */
	public ProfilDto getProfil() {
		return profil;
	}

	/**
	 * @param profil
	 *            the profil to set
	 */
	public void setProfil(final ProfilDto profil) {
		this.profil = profil;
	}

	/**
	 * @return the paysGestionDto
	 */
	public Set<PaysDto> getPaysGestion() {
		return paysGestion;
	}

	/**
	 * @param paysGestionDto
	 *            the paysGestionDto to set
	 */
	public void setPaysGestion(final Set<PaysDto> paysGestionDto) {
		this.paysGestion = paysGestionDto;
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
		final UtilisateurDto other = (UtilisateurDto) obj;
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
