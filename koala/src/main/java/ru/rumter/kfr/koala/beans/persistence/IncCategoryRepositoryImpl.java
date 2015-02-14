package ru.rumter.kfr.koala.beans.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rumter.kfr.koala.domain.entity.inc.IncCategory;
import ru.rumter.kfr.koala.domain.repository.inc.IncCategoryRepository;

@Repository
@Transactional
public class IncCategoryRepositoryImpl extends AbstractCrudRepository<IncCategory> implements IncCategoryRepository {

	@Override
	protected Class<IncCategory> getEntityClass() {
		return IncCategory.class;
	}

}
