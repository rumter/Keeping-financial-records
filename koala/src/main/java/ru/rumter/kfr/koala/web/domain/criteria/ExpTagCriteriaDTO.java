package ru.rumter.kfr.koala.web.domain.criteria;

import ru.rumter.kfr.koala.domain.criteria.ExpTagCriteria;

public class ExpTagCriteriaDTO extends CriteriaDTO {

    public ExpTagCriteria toDomainCriteria() {
        ExpTagCriteria icc = new ExpTagCriteria();
        icc.setStart(getStart().intValue());
        icc.setCount(getLimit().intValue());
        icc.setSort(toDomainSort());
        return icc;
    }

}