package ru.rumter.kfr.koala.domain.service;

import ru.rumter.kfr.koala.domain.criteria.ExpCategoryCriteria;
import ru.rumter.kfr.koala.domain.entity.exp.ExpCategory;

import java.util.List;

public interface ExpCategoryService {

    long countByCriteria(ExpCategoryCriteria expCategoryCriteria);

    List<ExpCategory> findByCriteria(ExpCategoryCriteria expCategoryCriteria);

    void save(ExpCategory expCategory);

    void delete(Long id);

}
