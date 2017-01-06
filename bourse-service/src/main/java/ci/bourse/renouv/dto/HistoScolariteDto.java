package ci.bourse.renouv.dto;

import java.io.Serializable;

/**
 * @author euchoux
 */
public class HistoScolariteDto implements Serializable {

	private static final long serialVersionUID = -7005383571444763376L;

	private Integer id;

	private String anneeScolaire;

	private String filiere;

	private String diplome;

	private String etablissement;

	private Double moyenne;

	private String mention;

	private BoursierDto boursier;

	private NiveauDto niveau;

	public HistoScolariteDto() {
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
	 * @return the niveauDto
	 */
	public NiveauDto getNiveau() {
		return niveau;
	}


	/**
	 * @param niveauDto
	 *            the niveauDto to set
	 */
	public void setNiveau(final NiveauDto niveauDto) {
		this.niveau = niveauDto;
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
		final HistoScolariteDto other = (HistoScolariteDto) obj;
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
