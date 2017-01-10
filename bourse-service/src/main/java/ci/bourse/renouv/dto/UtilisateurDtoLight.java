package ci.bourse.renouv.dto;

import java.io.Serializable;

import ci.bourse.renouv.securite.ProfilEnum;

/**
 * @author euchoux
 */
public class UtilisateurDtoLight implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String nom;

	private String prenoms;

	private ProfilEnum userProfil;

	public UtilisateurDtoLight() {
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
	 * @return the profil
	 */
	public ProfilEnum getUserProfil() {
		return userProfil;
	}

	/**
	 * @param profil
	 *            the profil to set
	 */
	public void setUserProfil(final ProfilEnum userProfil) {
		this.userProfil = userProfil;
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
		final UtilisateurDtoLight other = (UtilisateurDtoLight) obj;
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
