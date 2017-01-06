package ci.bourse.renouv.dto;

import java.io.Serializable;

/**
 * @author euchoux
 */
public class BourseDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String numero;

	private Integer duree;

	private Double montant;

	private SerieDto serie;

	private PaysDto pays;

	private StatutDto statut;

	public BourseDto() {
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(final String numero) {
		this.numero = numero;
	}

	/**
	 * @return the duree
	 */
	public Integer getDuree() {
		return duree;
	}

	/**
	 * @param duree
	 *            the duree to set
	 */
	public void setDuree(final Integer duree) {
		this.duree = duree;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(final Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the serieDto
	 */
	public SerieDto getSerie() {
		return serie;
	}

	/**
	 * @param serieDto
	 *            the serieDto to set
	 */
	public void setSerie(final SerieDto serieDto) {
		this.serie = serieDto;
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
	 * @return the statutDto
	 */
	public StatutDto getStatut() {
		return statut;
	}

	/**
	 * @param statutDto
	 *            the statutDto to set
	 */
	public void setStatut(final StatutDto statutDto) {
		this.statut = statutDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duree == null) ? 0 : duree.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

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
		final BourseDto other = (BourseDto) obj;
		if (duree == null) {
			if (other.duree != null) {
				return false;
			}
		} else if (!duree.equals(other.duree)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}


}
