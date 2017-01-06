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
@Table(name = "Histo_sco")
public class HistoScolarite extends AbstractData<Integer> {

	private static final long serialVersionUID = -7005383571444763376L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "histo_id", nullable = false)
	private Integer id;

	@Column(name = "hi_annee_scolaire", length = ModelConstant.LENGTH_4)
	private String anneeScolaire;

	@Column(name = "hi_filiere", length = ModelConstant.LENGTH_300)
	private String filiere;

	@Column(name = "hi_diplome", length = ModelConstant.LENGTH_300)
	private String diplome;

	@Column(name = "hi_etablissement", length = ModelConstant.LENGTH_300)
	private String etablissement;

	@Column(name = "hi_moyenne")
	private Double moyenne;

	@Column(name = "hi_mention", length = ModelConstant.LENGTH_100)
	private String mention;

	@ManyToOne
	@JoinColumn(name = "boursier_id", nullable = false)
	private Boursier boursier;

	@ManyToOne
	@JoinColumn(name = "niveau_id", nullable = false)
	private Niveau niveau;

	public HistoScolarite() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}


	/**
	 * @return the anneeScolaire
	 */
	public String getAnneeScolaire() {
		return anneeScolaire;
	}


	/**
	 * @param anneeScolaire
	 *            the anneeScolaire to set
	 */
	public void setAnneeScolaire(final String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}


	/**
	 * @return the filiere
	 */
	public String getFiliere() {
		return filiere;
	}


	/**
	 * @param filiere
	 *            the filiere to set
	 */
	public void setFiliere(final String filiere) {
		this.filiere = filiere;
	}


	/**
	 * @return the diplome
	 */
	public String getDiplome() {
		return diplome;
	}


	/**
	 * @param diplome
	 *            the diplome to set
	 */
	public void setDiplome(final String diplome) {
		this.diplome = diplome;
	}


	/**
	 * @return the etablissement
	 */
	public String getEtablissement() {
		return etablissement;
	}


	/**
	 * @param etablissement
	 *            the etablissement to set
	 */
	public void setEtablissement(final String etablissement) {
		this.etablissement = etablissement;
	}


	/**
	 * @return the moyenne
	 */
	public Double getMoyenne() {
		return moyenne;
	}


	/**
	 * @param moyenne
	 *            the moyenne to set
	 */
	public void setMoyenne(final Double moyenne) {
		this.moyenne = moyenne;
	}


	/**
	 * @return the mention
	 */
	public String getMention() {
		return mention;
	}


	/**
	 * @param mention
	 *            the mention to set
	 */
	public void setMention(final String mention) {
		this.mention = mention;
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
	 * @return the niveau
	 */
	public Niveau getNiveau() {
		return niveau;
	}


	/**
	 * @param niveau
	 *            the niveau to set
	 */
	public void setNiveau(final Niveau niveau) {
		this.niveau = niveau;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boursier == null) ? 0 : boursier.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
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
		final HistoScolarite other = (HistoScolarite) obj;
		if (boursier == null) {
			if (other.boursier != null) {
				return false;
			}
		} else if (!boursier.equals(other.boursier)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (niveau == null) {
			if (other.niveau != null) {
				return false;
			}
		} else if (!niveau.equals(other.niveau)) {
			return false;
		}
		return true;
	}


}
