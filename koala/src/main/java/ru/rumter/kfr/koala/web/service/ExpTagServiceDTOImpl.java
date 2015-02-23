package ru.rumter.kfr.koala.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.entity.exp.ExpTag;
import ru.rumter.kfr.koala.domain.service.ExpTagService;
import ru.rumter.kfr.koala.web.domain.criteria.ExpTagCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpTagDTO;
import ru.rumter.kfr.koala.web.domain.service.ExpTagServiceDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExpTagServiceDTOImpl implements ExpTagServiceDTO {

    @Autowired
    ExpTagService expTagService;

    @Override
    public long countByCriteria(ExpTagCriteriaDTO expTagCriteriaDTO) {
        return expTagService.countByCriteria(expTagCriteriaDTO.toDomainCriteria());
    }

    @Override
    public List<ExpTagDTO> findByCriteria(ExpTagCriteriaDTO expTagCriteriaDTO) {
        List<ExpTag> expTagList = expTagService.findByCriteria(expTagCriteriaDTO.toDomainCriteria());
        List<ExpTagDTO> res = new ArrayList<>();
        if (expTagList != null && !expTagList.isEmpty()) {
            for (ExpTag entity : expTagList) {
                res.add(ExpTagDTO.toDTO(entity));
            }
        }
        return res;
    }

    @Override
    public void save(ExpTagDTO expTagDTO) {
        expTagService.save(expTagDTO.fromDTO());
    }

    @Override
    public void delete(Long id) {
        expTagService.delete(id);
    }

}
