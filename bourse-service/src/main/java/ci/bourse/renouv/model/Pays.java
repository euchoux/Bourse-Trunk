package ci.bourse.renouv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ci.bourse.renouv.constant.ModelConstant;

/**
 * @author euchoux
 */
@Entity
@Table(name = "Pays")
public class Pays extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pays_id", nullable = false)
    private Integer id;

	@Column(name = "py_code", length = ModelConstant.LENGTH_5)
    private String code;
    
	@Column(name = "py_libelle", length = ModelConstant.LENGTH_100)
    private String libelle;

	public Pays() {
		super();
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(final Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(final String code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		final Pays other = (Pays) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
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
