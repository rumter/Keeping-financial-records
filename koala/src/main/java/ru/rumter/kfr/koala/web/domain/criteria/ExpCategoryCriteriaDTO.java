package ru.rumter.kfr.koala.web.domain.criteria;

import ru.rumter.kfr.koala.domain.criteria.ExpCategoryCriteria;

public class ExpCategoryCriteriaDTO extends CriteriaDTO {

    public ExpCategoryCriteria toDomainCriteria() {
        ExpCategoryCriteria icc = new ExpCategoryCriteria();
        icc.setStart(getStart().intValue());
        icc.setCount(getLimit().intValue());
        icc.setSort(toDomainSort());
        return icc;
    }

}