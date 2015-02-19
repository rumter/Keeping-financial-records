package ru.rumter.kfr.koala.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.entity.exp.ExpCategory;
import ru.rumter.kfr.koala.domain.service.ExpCategoryService;
import ru.rumter.kfr.koala.web.domain.criteria.ExpCategoryCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpCategoryDTO;
import ru.rumter.kfr.koala.web.domain.service.ExpCategoryServiceDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExpCategoryServiceDTOImpl implements ExpCategoryServiceDTO {

    @Autowired
    ExpCategoryService expCategoryService;

    @Override
    public long countByCriteria(ExpCategoryCriteriaDTO expCategoryCriteriaDTO) {
        return expCategoryService.countByCriteria(expCategoryCriteriaDTO.toDomainCriteria());
    }

    @Override
    public List<ExpCategoryDTO> findByCriteria(ExpCategoryCriteriaDTO expCategoryCriteriaDTO) {
        List<ExpCategory> expCategoryList = expCategoryService.findByCriteria(expCategoryCriteriaDTO.toDomainCriteria());
        List<ExpCategoryDTO> res = new ArrayList<>();
        if (expCategoryList != null && !expCategoryList.isEmpty()) {
            for (ExpCategory entity : expCategoryList) {
                res.add(ExpCategoryDTO.toDTO(entity));
            }
        }
        return res;
    }

    @Override
    public void save(ExpCategoryDTO expCategoryDTO) {
        expCategoryService.save(expCategoryDTO.fromDTO());
    }

    @Override
    public void delete(Long id) {
        expCategoryService.delete(id);
    }

}
