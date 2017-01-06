package ci.bourse.renouv.dto;

import java.io.Serializable;

/**
 * @author euchoux
 */
public class EleveParentDto implements Serializable {

	private static final long serialVersionUID = -1846365182038355031L;

	private EleveParentPkDto id;

	private FiliationDto filiation;

	private BoursierDto boursier;

	private LienDto lien;

	public EleveParentDto() {
		super();
	}

	/**
	 * @return the id
	 */
	public EleveParentPkDto getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final EleveParentPkDto id) {
		this.id = id;
	}


	/**
	 * @return the filiatioDto
	 */
	public FiliationDto getFiliatio() {
		return filiation;
	}


	/**
	 * @param filiatioDto
	 *            the filiatioDto to set
	 */
	public void setFiliatio(final FiliationDto filiatioDto) {
		this.filiation = filiatioDto;
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
	 * @return the lienDto
	 */
	public LienDto getLien() {
		return lien;
	}


	/**
	 * @param lienDto
	 *            the lienDto to set
	 */
	public void setLien(final LienDto lienDto) {
		this.lien = lienDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
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
		final EleveParentDto other = (EleveParentDto) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
