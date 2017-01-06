package ci.bourse.renouv.dto;

import java.io.Serializable;

/**
 * @author euchoux
 */
public class FiliationDto implements Serializable{

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String nom;

	private String prenoms;

	private String profession;

	private String adresse;

	private Double revenuAnnuel;

	private String telephone;

	private PaysDto paysDto;

	public FiliationDto() {
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
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(final String profession) {
		this.profession = profession;
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
	 * @return the revenuAnnuel
	 */
	public Double getRevenuAnnuel() {
		return revenuAnnuel;
	}

	/**
	 * @param revenuAnnuel
	 *            the revenuAnnuel to set
	 */
	public void setRevenuAnnuel(final Double revenuAnnuel) {
		this.revenuAnnuel = revenuAnnuel;
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
	public PaysDto getPaysDto() {
		return paysDto;
	}

	/**
	 * @param paysDto
	 *            the paysDto to set
	 */
	public void setPaysDto(final PaysDto paysDto) {
		this.paysDto = paysDto;
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
		final FiliationDto other = (FiliationDto) obj;
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
