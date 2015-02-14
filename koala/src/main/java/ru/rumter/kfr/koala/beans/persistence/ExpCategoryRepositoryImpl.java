package ru.rumter.kfr.koala.beans.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rumter.kfr.koala.domain.entity.exp.ExpCategory;
import ru.rumter.kfr.koala.domain.repository.exp.ExpCategoryRepository;

@Repository
@Transactional
public class ExpCategoryRepositoryImpl extends AbstractCrudRepository<ExpCategory> implements ExpCategoryRepository {

	@Override
	protected Class<ExpCategory> getEntityClass() {
		return ExpCategory.class;
	}

}
