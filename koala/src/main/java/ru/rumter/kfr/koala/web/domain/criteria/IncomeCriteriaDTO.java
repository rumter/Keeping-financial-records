package ru.rumter.kfr.koala.web.domain.criteria;

import ru.rumter.kfr.koala.domain.criteria.IncomeCriteria;

public class IncomeCriteriaDTO extends CriteriaDTO {

    public IncomeCriteria toDomainCriteria() {
        IncomeCriteria ic = new IncomeCriteria();
        ic.setStart(getStart().intValue());
        ic.setCount(getLimit().intValue());
        ic.setSort(toDomainSort());
        return ic;
    }

}
