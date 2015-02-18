package ru.rumter.kfr.koala.domain.service;

import ru.rumter.kfr.koala.domain.criteria.IncCategoryCriteria;
import ru.rumter.kfr.koala.domain.entity.inc.IncCategory;

import java.util.List;

public interface IncCategoryService {

    long countByCriteria(IncCategoryCriteria incCategoryCriteria);

    List<IncCategory> findByCriteria(IncCategoryCriteria incCategoryCriteria);

}
