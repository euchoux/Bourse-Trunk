package ci.bourse.renouv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ci.bourse.renouv.constant.ModelConstant;

/**
 * @author euchoux
 */
@Entity
@Table(name = "Bourse")
public class Bourse extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bourse_id", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "bo_numero", nullable = false, length = ModelConstant.LENGTH_100)
	private String numero;

	@Column(name = "bo_duree", nullable = false)
	private Integer duree;

	@Column(name = "bo_montant", nullable = false)
	private Double montant;

	@ManyToOne
	@JoinColumn(name = "serie_id", nullable = false)
	private Serie serie;

	@ManyToOne
	@JoinColumn(name = "pays_id", nullable = false)
	private Pays pays;

	@ManyToOne
	@JoinColumn(name = "statut_id", nullable = false)
	private Statut statut;

	public Bourse() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(final Integer duree) {
		this.duree = duree;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(final Double montant) {
		this.montant = montant;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(final Serie serie) {
		this.serie = serie;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(final Pays pays) {
		this.pays = pays;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(final Statut statut) {
		this.statut = statut;
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
		final Bourse other = (Bourse) obj;
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
