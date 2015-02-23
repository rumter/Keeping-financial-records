package ru.rumter.kfr.koala.beans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.criteria.IncomeCriteria;
import ru.rumter.kfr.koala.domain.entity.inc.Income;
import ru.rumter.kfr.koala.domain.repository.inc.IncomeRepository;
import ru.rumter.kfr.koala.domain.service.IncomeService;

import java.util.List;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public long countByCriteria(IncomeCriteria incomeCriteria) {
        return incomeRepository.countByCriteria(incomeCriteria);
    }

    @Override
    public List<Income> findByCriteria(IncomeCriteria incomeCriteria) {
        return incomeRepository.findByCriteria(incomeCriteria);
    }

    @Override
    public void save(Income income) {
        incomeRepository.saveOrUpdate(income);
    }

    @Override
    public void delete(Long id) {
        incomeRepository.removeById(id);
    }

}
