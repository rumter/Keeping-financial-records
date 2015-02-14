package ru.rumter.kfr.koala.domain.repository;

import ru.rumter.kfr.koala.domain.criteria.PageableCriteria;

/**
 * Repository for CRUD operations supports paging
 * 
 * @author Ilya
 *
 * @param <T>
 */
public interface PageableCrudRepository<T> extends CrudRepository<T>, CriteriaRepository<T, PageableCriteria> {
}
