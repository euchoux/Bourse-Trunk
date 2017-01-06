package ci.bourse.renouv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author euchoux
 */
@Embeddable
public class EleveParentPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "parent_id", nullable = false,
            insertable = false, updatable = false)
	private int parentId;

	@Column(name = "bousier_id", nullable = false, insertable = false, updatable = false)
	private int bousierId;

	@Column(name = "lien_id", nullable = false, insertable = false,
            updatable = false)
	private int lienId;

    public EleveParentPk() {
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
