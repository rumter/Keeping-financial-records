package ru.rumter.kfr.koala.web.domain.service;

import ru.rumter.kfr.koala.web.domain.criteria.IncomeCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.IncomeDTO;

import java.util.List;

public interface IncomeServiceDTO {

    long countByCriteria(IncomeCriteriaDTO incomeCriteriaDTO);

    List<IncomeDTO> findByCriteria(IncomeCriteriaDTO incomeCriteriaDTO);

    void save(IncomeDTO incomeDTO);

    void delete(Long id);

}
