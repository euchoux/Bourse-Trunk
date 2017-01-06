package ci.bourse.renouv.dao;

import java.io.Serializable;
import java.util.List;

import ci.bourse.renouv.model.AbstractData;

/**
 * Ensemble de methodes génériques d'accès à la base de données.
 * 
 * @author eubosson
 * 
 * @param <T>
 *            le type géré par la DAO
 */
public interface DefaultRepository<T extends AbstractData<?>, Id extends Serializable> {

    T load(final Class<T> theClass, final Serializable id);

    T get(final Class<T> theClass, final Serializable id);

    /**
     * Méthode retournant l'ensemble des données d'une table.
     * 
     * @return List<T> la liste des données de la table
     */
    List<T> findAll();

    /**
     * Methode de création d'un objet.
     * 
     * @param pData
     *            l'entité à créer
     * @return l'identifiant de l'entité créée
     */
    Id save(final T pData);

    /**
     * Update existing entity
     */
    void update(final T pData);

    /**
     * Merge existing entity
     */
    T merge(final T pData);

    /**
     * Méthode de modification d'un objet.
     * 
     * @param pData
     *            l'entité à modifier
     */
    T saveOrUpdate(final T pData);

    /**
     * Méthode de suppression d'un objet.
     * 
     * @param pData
     *            l'entité à supprimer
     */
    void delete(final T pData);

    /**
     * Méthode permetant de trouver un enregistrement par son
     * identifiant.
     * 
     * @param id
     *            l'identifiant de l'enregistrement à trouver
     * @return l'enregistrement recherché
     */
    T findById(final Id id);

    boolean contains(final T pData);

}
