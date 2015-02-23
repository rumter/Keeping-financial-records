package ru.rumter.kfr.koala.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.criteria.ExpTagCriteria;
import ru.rumter.kfr.koala.domain.entity.exp.ExpTag;
import ru.rumter.kfr.koala.domain.repository.exp.ExpTagRepository;
import ru.rumter.kfr.koala.domain.service.ExpTagService;

import java.util.List;

@Service
@Transactional
public class ExpTagServiceImpl implements ExpTagService {

    @Autowired
    ExpTagRepository expTagRepository;

    @Override
    public long countByCriteria(ExpTagCriteria expTagCriteria) {
        return expTagRepository.countByCriteria(expTagCriteria);
    }

    @Override
    public List<ExpTag> findByCriteria(ExpTagCriteria expTagCriteria) {
        return expTagRepository.findByCriteria(expTagCriteria);
    }

    @Override
    public void save(ExpTag expTag) {
        expTagRepository.saveOrUpdate(expTag);
    }

    @Override
    public void delete(Long id) {
        expTagRepository.removeById(id);
    }

}
