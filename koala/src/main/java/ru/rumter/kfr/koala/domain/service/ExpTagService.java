package ru.rumter.kfr.koala.domain.service;

import ru.rumter.kfr.koala.domain.criteria.ExpTagCriteria;
import ru.rumter.kfr.koala.domain.entity.exp.ExpTag;

import java.util.List;

public interface ExpTagService {

    long countByCriteria(ExpTagCriteria expTagCriteria);

    List<ExpTag> findByCriteria(ExpTagCriteria expTagCriteria);

    void save(ExpTag expTag);

    void delete(Long id);

}
