package ru.rumter.kfr.koala.domain.service;

import ru.rumter.kfr.koala.domain.criteria.ExpenseCriteria;
import ru.rumter.kfr.koala.domain.entity.exp.Expense;

import java.util.List;

public interface ExpenseService {

    long countByCriteria(ExpenseCriteria expenseCriteria);

    List<Expense> findByCriteria(ExpenseCriteria expenseCriteria);

    void save(Expense expense);

    void delete(Long id);

}
