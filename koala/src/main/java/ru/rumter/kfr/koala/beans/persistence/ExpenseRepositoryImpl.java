package ru.rumter.kfr.koala.beans.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rumter.kfr.koala.domain.entity.exp.Expense;
import ru.rumter.kfr.koala.domain.repository.exp.ExpenseRepository;

@Repository
@Transactional
public class ExpenseRepositoryImpl extends AbstractCrudRepository<Expense> implements ExpenseRepository {

	@Override
	protected Class<Expense> getEntityClass() {
		return Expense.class;
	}

}
