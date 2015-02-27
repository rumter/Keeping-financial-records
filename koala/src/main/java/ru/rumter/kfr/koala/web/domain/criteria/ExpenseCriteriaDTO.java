package ru.rumter.kfr.koala.web.domain.criteria;

import ru.rumter.kfr.koala.domain.criteria.ExpenseCriteria;

public class ExpenseCriteriaDTO extends CriteriaDTO {

    public ExpenseCriteria toDomainCriteria() {
        ExpenseCriteria ec = new ExpenseCriteria();
        ec.setStart(getStart().intValue());
        ec.setCount(getLimit().intValue());
        ec.setSort(toDomainSort());
        return ec;
    }

}
