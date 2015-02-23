package ru.rumter.kfr.koala.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rumter.kfr.koala.domain.entity.inc.Income;
import ru.rumter.kfr.koala.domain.service.IncomeService;
import ru.rumter.kfr.koala.web.domain.criteria.IncomeCriteriaDTO;
import ru.rumter.kfr.koala.web.domain.model.IncomeDTO;
import ru.rumter.kfr.koala.web.domain.service.IncomeServiceDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IncomeServiceDTOImpl implements IncomeServiceDTO {

    @Autowired
    IncomeService incomeService;

    @Override
    public long countByCriteria(IncomeCriteriaDTO incomeCriteriaDTO) {
        return incomeService.countByCriteria(incomeCriteriaDTO.toDomainCriteria());
    }

    @Override
    public List<IncomeDTO> findByCriteria(IncomeCriteriaDTO incomeCriteriaDTO) {
        List<Income> incomeList = incomeService.findByCriteria(incomeCriteriaDTO.toDomainCriteria());
        List<IncomeDTO> res = new ArrayList<>();
        if (incomeList != null && !incomeList.isEmpty()) {
            for (Income entity : incomeList) {
                res.add(IncomeDTO.toDTO(entity));
            }
        }
        return res;
    }

    @Override
    public void save(IncomeDTO incomeDTO) {
        incomeService.save(incomeDTO.fromDTO());
    }

    @Override
    public void delete(Long id) {
        incomeService.delete(id);
    }

}
