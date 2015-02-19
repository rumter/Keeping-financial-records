package ru.rumter.kfr.koala.web.domain.service;

import ru.rumter.kfr.koala.web.domain.criteria.IncCategoryCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.IncCategoryDTO;

import java.util.List;

public interface IncCategoryServiceDTO {

    long countByCriteria(IncCategoryCriteriaDTO incCategoryCriteriaDTO);

    List<IncCategoryDTO> findByCriteria(IncCategoryCriteriaDTO incCategoryCriteriaDTO);

    void save(IncCategoryDTO incCategoryDTO);

    void delete(Long id);

}
