package ru.rumter.kfr.koala.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.entity.exp.Expense;
import ru.rumter.kfr.koala.domain.service.ExpenseService;
import ru.rumter.kfr.koala.web.domain.criteria.ExpenseCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.ExpenseDTO;
import ru.rumter.kfr.koala.web.domain.service.ExpenseServiceDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ExpenseServiceDTOImpl implements ExpenseServiceDTO {

    @Autowired
    ExpenseService expenseService;

    @Override
    public long countByCriteria(ExpenseCriteriaDTO expenseCriteriaDTO) {
        return expenseService.countByCriteria(expenseCriteriaDTO.toDomainCriteria());
    }

    @Override
    public List<ExpenseDTO> findByCriteria(ExpenseCriteriaDTO expenseCriteriaDTO) {
        List<Expense> expenseList = expenseService.findByCriteria(expenseCriteriaDTO.toDomainCriteria());
        List<ExpenseDTO> res = new ArrayList<>();
        if (expenseList != null && !expenseList.isEmpty()) {
            for (Expense entity : expenseList) {
                res.add(ExpenseDTO.toDTO(entity));
            }
        }
        return res;
    }

    @Override
    public void save(ExpenseDTO expenseDTO) {
        expenseService.save(expenseDTO.fromDTO());
    }

    @Override
    public void delete(Long id) {
        expenseService.delete(id);
    }

}
