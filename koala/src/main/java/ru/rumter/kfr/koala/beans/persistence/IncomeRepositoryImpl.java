package ru.rumter.kfr.koala.beans.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rumter.kfr.koala.domain.entity.inc.Income;
import ru.rumter.kfr.koala.domain.repository.inc.IncomeRepository;

@Repository
@Transactional
public class IncomeRepositoryImpl extends AbstractCrudRepository<Income> implements IncomeRepository {

	@Override
	protected Class<Income> getEntityClass() {
		return Income.class;
	}

}
