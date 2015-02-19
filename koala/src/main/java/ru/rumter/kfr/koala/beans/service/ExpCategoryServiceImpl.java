package ru.rumter.kfr.koala.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.criteria.ExpCategoryCriteria;
import ru.rumter.kfr.koala.domain.entity.exp.ExpCategory;
import ru.rumter.kfr.koala.domain.repository.exp.ExpCategoryRepository;
import ru.rumter.kfr.koala.domain.service.ExpCategoryService;

import java.util.List;

@Service
@Transactional
public class ExpCategoryServiceImpl implements ExpCategoryService {

    @Autowired
    ExpCategoryRepository expCategoryRepository;

    @Override
    public long countByCriteria(ExpCategoryCriteria expCategoryCriteria) {
        return expCategoryRepository.countByCriteria(expCategoryCriteria);
    }

    @Override
    public List<ExpCategory> findByCriteria(ExpCategoryCriteria expCategoryCriteria) {
        return expCategoryRepository.findByCriteria(expCategoryCriteria);
    }

    @Override
    public void save(ExpCategory expCategory) {
        expCategoryRepository.saveOrUpdate(expCategory);
    }

    @Override
    public void delete(Long id) {
        expCategoryRepository.removeById(id);
    }

}
