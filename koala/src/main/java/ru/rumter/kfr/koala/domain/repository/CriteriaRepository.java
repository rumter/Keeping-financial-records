package ru.rumter.kfr.koala.domain.repository;

import java.util.List;

import ru.rumter.kfr.koala.domain.criteria.Criteria;

public interface CriteriaRepository<T, C extends Criteria> extends Repository {

	List<T> findByCriteria(C criteria);

	long countByCriteria(C criteria);

}
