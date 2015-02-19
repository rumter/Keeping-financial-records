package ru.rumter.kfr.koala.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.entity.inc.IncCategory;
import ru.rumter.kfr.koala.domain.service.IncCategoryService;
import ru.rumter.kfr.koala.web.domain.criteria.IncCategoryCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.IncCategoryDTO;
import ru.rumter.kfr.koala.web.domain.service.IncCategoryServiceDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IncCategoryServiceDTOImpl implements IncCategoryServiceDTO {

    @Autowired
    IncCategoryService incCategoryService;

    @Override
    public long countByCriteria(IncCategoryCriteriaDTO incCategoryCriteriaDTO) {
        return incCategoryService.countByCriteria(incCategoryCriteriaDTO.toDomainCriteria());
    }

    @Override
    public List<IncCategoryDTO> findByCriteria(IncCategoryCriteriaDTO incCategoryCriteriaDTO) {
        List<IncCategory> incCategoryList = incCategoryService.findByCriteria(incCategoryCriteriaDTO.toDomainCriteria());
        List<IncCategoryDTO> res = new ArrayList<>();
        if (incCategoryList != null && !incCategoryList.isEmpty()) {
            for (IncCategory entity : incCategoryList) {
                res.add(IncCategoryDTO.toDTO(entity));
            }
        }
        return res;
    }

    @Override
    public void save(IncCategoryDTO incCategoryDTO) {
        incCategoryService.save(incCategoryDTO.fromDTO());
    }

    @Override
    public void delete(Long id) {
        incCategoryService.delete(id);
    }

}
