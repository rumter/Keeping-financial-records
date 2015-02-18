package ru.rumter.kfr.koala.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.criteria.IncCategoryCriteria;
import ru.rumter.kfr.koala.domain.entity.inc.IncCategory;
import ru.rumter.kfr.koala.domain.repository.inc.IncCategoryRepository;
import ru.rumter.kfr.koala.domain.service.IncCategoryService;

import java.util.List;

@Service
@Transactional
public class IncCategoryServiceImpl implements IncCategoryService {

    @Autowired
    IncCategoryRepository incCategoryRepository;

    @Override
    public long countByCriteria(IncCategoryCriteria incCategoryCriteria) {
        return incCategoryRepository.countByCriteria(incCategoryCriteria);
    }

    @Override
    public List<IncCategory> findByCriteria(IncCategoryCriteria incCategoryCriteria) {
        return incCategoryRepository.findByCriteria(incCategoryCriteria);
    }
}
