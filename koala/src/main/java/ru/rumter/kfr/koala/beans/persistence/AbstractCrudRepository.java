package ru.rumter.kfr.koala.beans.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ru.rumter.kfr.koala.domain.criteria.PageableCriteria;
import ru.rumter.kfr.koala.domain.criteria.SortDirectionEnum;
import ru.rumter.kfr.koala.domain.entity.AbstractEntity;
import ru.rumter.kfr.koala.domain.repository.PageableCrudRepository;

public abstract class AbstractCrudRepository<T extends AbstractEntity> implements PageableCrudRepository<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected abstract Class<T> getEntityClass();

	protected String getEntityName() {
		return getEntityClass().getSimpleName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "FROM " + getEntityName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public long countAll() {
		String hql = "SELECT COUNT(*) FROM " + getEntityName();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findOneById(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(getEntityClass(), id);
	}

	@Override
	public boolean exists(Serializable id) {
		return findOneById(id) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T save(T entity) {
		return (T) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void removeById(Serializable id) {
		sessionFactory.getCurrentSession().delete(findOneById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(PageableCriteria criteria) {
		StringBuilder hql = new StringBuilder("FROM " + getEntityName());
		if (criteria.getSort() != null) {
			String direction = (criteria.getSort().getDirection() == SortDirectionEnum.ASC ? "ASC" : "DESC");
			hql.append(" ORDER BY ").append(criteria.getSort().getField()).append(" ").append(direction);
		}

		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setFirstResult(criteria.getStart());
		if (criteria.getCount() != 0) {
			query.setMaxResults(criteria.getCount());
		}
		return query.list();
	}

	@Override
	public long countByCriteria(PageableCriteria criteria) {
		StringBuilder hql = new StringBuilder("SELECT COUNT(*) FROM " + getEntityName());
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setFirstResult(criteria.getStart());
		if (criteria.getCount() != 0) {
			query.setMaxResults(criteria.getCount());
		}
		return (long) query.uniqueResult();
	}

}
