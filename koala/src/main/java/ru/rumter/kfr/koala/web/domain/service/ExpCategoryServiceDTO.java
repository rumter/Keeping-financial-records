package ru.rumter.kfr.koala.web.domain.service;

import ru.rumter.kfr.koala.web.domain.criteria.ExpCategoryCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpCategoryDTO;

import java.util.List;

public interface ExpCategoryServiceDTO {

    long countByCriteria(ExpCategoryCriteriaDTO expCategoryCriteriaDTO);

    List<ExpCategoryDTO> findByCriteria(ExpCategoryCriteriaDTO expCategoryCriteriaDTO);

    void save(ExpCategoryDTO expCategoryDTO);

    void delete(Long id);

}
