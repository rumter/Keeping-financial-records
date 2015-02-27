package ru.rumter.kfr.koala.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.criteria.ExpenseCriteria;
import ru.rumter.kfr.koala.domain.entity.exp.Expense;
import ru.rumter.kfr.koala.domain.repository.exp.ExpenseRepository;
import ru.rumter.kfr.koala.domain.service.ExpenseService;

import java.util.List;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public long countByCriteria(ExpenseCriteria expenseCriteria) {
        return expenseRepository.countByCriteria(expenseCriteria);
    }

    @Override
    public List<Expense> findByCriteria(ExpenseCriteria expenseCriteria) {
        return expenseRepository.findByCriteria(expenseCriteria);
    }

    @Override
    public void save(Expense expense) {
        expenseRepository.saveOrUpdate(expense);
    }

    @Override
    public void delete(Long id) {
        expenseRepository.removeById(id);
    }

}
