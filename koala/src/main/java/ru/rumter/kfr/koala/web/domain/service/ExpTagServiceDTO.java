package ru.rumter.kfr.koala.web.domain.service;

import ru.rumter.kfr.koala.web.domain.criteria.ExpTagCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpTagDTO;

import java.util.List;

public interface ExpTagServiceDTO {

    long countByCriteria(ExpTagCriteriaDTO expTagCriteriaDTO);

    List<ExpTagDTO> findByCriteria(ExpTagCriteriaDTO expTagCriteriaDTO);

    void save(ExpTagDTO expTagDTO);

    void delete(Long id);

}
