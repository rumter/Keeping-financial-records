package ru.rumter.kfr.koala.beans.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.rumter.kfr.koala.domain.entity.exp.ExpTag;
import ru.rumter.kfr.koala.domain.repository.exp.ExpTagRepository;

@Repository
@Transactional
public class ExpTagRepositoryImpl extends AbstractCrudRepository<ExpTag> implements ExpTagRepository {

	@Override
	protected Class<ExpTag> getEntityClass() {
		return ExpTag.class;
	}

}
