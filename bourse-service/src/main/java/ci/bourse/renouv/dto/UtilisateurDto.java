package ci.bourse.renouv.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

	private List<ProfilDto> listProfils;

	private List<PaysDto> paysGestion;

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
	 * @return the listProfilsDto
	 */
	public List<ProfilDto> getListProfils() {
		return listProfils;
	}

	/**
	 * @param listProfilsDto
	 *            the listProfilsDto to set
	 */
	public void setListProfils(final List<ProfilDto> listProfilsDto) {
		this.listProfils = listProfilsDto;
	}

	/**
	 * @return the paysGestionDto
	 */
	public List<PaysDto> getPaysGestion() {
		return paysGestion;
	}

	/**
	 * @param paysGestionDto
	 *            the paysGestionDto to set
	 */
	public void setPaysGestion(final List<PaysDto> paysGestionDto) {
		this.paysGestion = paysGestionDto;
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
