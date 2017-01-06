package ci.bourse.renouv.model;

import java.io.Serializable;

/**
 * Classe générique.
 * Les classes héritants de cet objet peuvent utiliser les méthodes génériques
 * de création / modification et suppression.
 * 
 * @author eubosson
 * 
 */
public abstract class AbstractData<T extends Serializable> implements
        Serializable {

    private static final long serialVersionUID = -2718946445751826466L;

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public abstract boolean equals(Object object);

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public abstract int hashCode();
}
