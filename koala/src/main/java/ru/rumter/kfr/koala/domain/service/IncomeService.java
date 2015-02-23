package ru.rumter.kfr.koala.domain.service;

import ru.rumter.kfr.koala.domain.criteria.IncomeCriteria;
import ru.rumter.kfr.koala.domain.entity.inc.Income;

import java.util.List;

public interface IncomeService {

    long countByCriteria(IncomeCriteria incomeCriteria);

    List<Income> findByCriteria(IncomeCriteria incomeCriteria);

    void save(Income income);

    void delete(Long id);

}
