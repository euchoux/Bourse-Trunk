package ci.bourse.renouv.dto;

import java.io.Serializable;

/**
 * @author euchoux
 */
public class EleveParentPkDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int parentId;

	private int bousierId;

	private int lienId;

    public EleveParentPkDto() {
        super();
    }

	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(final int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the bousierId
	 */
	public int getBousierId() {
		return bousierId;
	}

	/**
	 * @param bousierId
	 *            the bousierId to set
	 */
	public void setBousierId(final int bousierId) {
		this.bousierId = bousierId;
	}

	/**
	 * @return the lienId
	 */
	public int getLienId() {
		return lienId;
	}

	/**
	 * @param lienId
	 *            the lienId to set
	 */
	public void setLienId(final int lienId) {
		this.lienId = lienId;
	}


}
