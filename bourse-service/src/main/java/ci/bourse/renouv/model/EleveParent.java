package ci.bourse.renouv.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author euchoux
 */
@Entity
@Table(name = "Parent_Boursier")
public class EleveParent extends AbstractData<EleveParentPk> {

    private static final long serialVersionUID = -1846365182038355031L;

    @EmbeddedId
	private EleveParentPk id;

    @ManyToOne
	@JoinColumn(name = "parent_id", nullable = false,
                insertable = false, updatable = false)
	private Filiation filiation;

    @ManyToOne
	@JoinColumn(name = "bousier_id", nullable = false, insertable = false, updatable = false)
	private Boursier boursier;

	@ManyToOne
	@JoinColumn(name = "lien_id", nullable = false,
                insertable = false, updatable = false)
	private Lien lien;

    public EleveParent() {
        super();
    }

	/**
	 * @return the id
	 */
	public EleveParentPk getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final EleveParentPk id) {
		this.id = id;
	}

	/**
	 * @return the filiation
	 */
	public Filiation getFiliation() {
		return filiation;
	}

	/**
	 * @param filiation
	 *            the filiation to set
	 */
	public void setFiliation(final Filiation filiation) {
		this.filiation = filiation;
	}

	/**
	 * @return the boursier
	 */
	public Boursier getBoursier() {
		return boursier;
	}

	/**
	 * @param boursier
	 *            the boursier to set
	 */
	public void setBoursier(final Boursier boursier) {
		this.boursier = boursier;
	}

	/**
	 * @return the lien
	 */
	public Lien getLien() {
		return lien;
	}

	/**
	 * @param lien
	 *            the lien to set
	 */
	public void setLien(final Lien lien) {
		this.lien = lien;
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
        final EleveParent other = (EleveParent) obj;
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
