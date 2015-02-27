package ru.rumter.kfr.koala.web.domain.service;

import ru.rumter.kfr.koala.web.domain.criteria.ExpenseCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpenseDTO;

import java.util.List;

public interface ExpenseServiceDTO {

    long countByCriteria(ExpenseCriteriaDTO expenseCriteriaDTO);

    List<ExpenseDTO> findByCriteria(ExpenseCriteriaDTO expenseCriteriaDTO);

    void save(ExpenseDTO expenseDTO);

    void delete(Long id);

}
