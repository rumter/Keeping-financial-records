package ru.rumter.kfr.koala.domain.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Repository interface for CRUD operations
 * 
 * @author Ilya
 *
 * @param <T>
 */
public interface CrudRepository<T> extends Repository {

	/**
	 * Find all entities
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * Count all entities
	 * 
	 * @return
	 */
	long countAll();

	/**
	 * Find one entity by id
	 * 
	 * @param id
	 * @return
	 */
	T findOneById(Serializable id);

	/**
	 * Exists entity by id
	 * 
	 * @param id
	 * @return
	 */
	boolean exists(Serializable id);

	/**
	 * Save entity
	 * 
	 * @return saved entity
	 */
	T save(T entity);

	/**
	 * Update entity
	 * 
	 * @param entity
	 * @return updated entity
	 */
	void update(T entity);

	/**
	 * Save or update entity
	 * 
	 * @param entity
	 */
	void saveOrUpdate(T entity);

	/**
	 * Remove entity
	 * 
	 * @param entity
	 */
	void remove(T entity);

	/**
	 * Remove entity by id
	 * 
	 * @param id
	 */
	void removeById(Serializable id);

}