package ci.bourse.renouv.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ci.bourse.renouv.dao.DefaultRepository;
import ci.bourse.renouv.model.AbstractData;

/**
 * Classe abstraite de gestion de la connexion à la Base de données l'aide de
 * Spring et hibernate Propose des méthodes génériques et les accesseurs à
 * l'object de référence
 * 
 * @author eubosson
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHibernateRepository<T extends AbstractData<?>, Id extends Serializable>
		implements DefaultRepository<T, Id> {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() {
		if (getSessionFactory() == null) {
			throw new IllegalStateException(getClass().getName() + " : sessionFactory est null");
		}
	}

	@Override
	public T load(final Class<T> theClass, final Serializable id) {
		final Session currentSession = getSession();
		return currentSession.load(theClass, id);
	}

	@Override
	public T get(final Class<T> theClass, final Serializable id) {
		final Session currentSession = getSession();
		return currentSession.get(theClass, id);
	}

	/**
	 * @see fr.edu.grenoble.sconet.common.dao.DefaultRepository#findAll()
	 */
	@Override
	public List<T> findAll() {
		final Session currentSession = getSession();
		final Criteria criteria = currentSession.createCriteria(getFirstTypeArgument());
		return criteria.list();
	}

	/**
	 * @see fr.edu.grenoble.sconet.common.dao.DefaultRepository#save(fr.edu.grenoble.sconet.common.model.AbstractData)
	 */
	@Override
	public Id save(final T pData) {
		final Session currentSession = getSession();
		return (Id) currentSession.save(pData);
	}

	/**
	 * @see fr.edu.grenoble.sconet.common.dao.DefaultRepository#update(fr.edu.grenoble.sconet.common.model.AbstractData)
	 */
	@Override
	public T saveOrUpdate(final T pData) {
		final Session currentSession = getSession();
		currentSession.saveOrUpdate(pData);
		return pData;
	}

	@Override
	public T merge(final T pData) {
		final Session currentSession = getSession();
		return (T) currentSession.merge(pData);
	}

	@Override
	public void update(final T pData) {
		final Session currentSession = getSession();
		currentSession.update(pData);
	}

	/**
	 * @see fr.edu.grenoble.sconet.common.dao.DefaultRepository#delete(fr.edu.grenoble.sconet.common.model.AbstractData)
	 */
	@Override
	public void delete(final T pData) {
		final Session currentSession = getSession();
		currentSession.delete(pData);
	}

	/**
	 * Méthode permetant de trouver des enregistrements par filtrage sur une
	 * colonne.
	 * 
	 * @param tableColumn
	 *            le nom de la colonne
	 * @param value
	 *            la valeur du filtre
	 * @return la liste des enregistrements de la table correspondant au filtre
	 *         indiqué
	 */
	protected final List<T> findAllBy(final String tableColumn, final Object value) {
		final Session currentSession = getSession();
		final Criteria criteria = currentSession.createCriteria(getFirstTypeArgument());
		criteria.add(Restrictions.eq(tableColumn, value));
		return criteria.list();
	}

	/**
	 * Méthode permetant de trouver un enregistrements par filtrage sur une
	 * colonne.
	 * 
	 * @param tableColumn
	 *            le nom de la colonne
	 * @param value
	 *            la valeur du filtre
	 * @return la liste des enregistrements de la table correspondant au filtre
	 *         indiqué
	 */
	protected T findBy(final String tableColumn, final String value) {
		final Session currentSession = getSession();
		final Criteria criteria = currentSession.createCriteria(getFirstTypeArgument());
		criteria.add(Restrictions.eq(tableColumn, value));
		return (T) criteria.uniqueResult();
	}

	/**
	 * @see fr.edu.grenoble.sconet.common.dao.DefaultRepository#findById(java.io.Serializable)
	 */
	@Override
	public T findById(final Id id) {
		final Session currentSession = getSession();
		return currentSession.get(getFirstTypeArgument(), id);
	}

	private Class<T> getFirstTypeArgument() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public boolean contains(final T pData) {
		final Session currentSession = getSession();
		return currentSession.contains(pData);
	}
}
