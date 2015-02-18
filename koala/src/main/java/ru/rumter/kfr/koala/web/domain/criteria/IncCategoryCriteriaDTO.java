package ru.rumter.kfr.koala.web.domain.criteria;

import ru.rumter.kfr.koala.domain.criteria.IncCategoryCriteria;

public class IncCategoryCriteriaDTO extends CriteriaDTO {

    public IncCategoryCriteria toDomainCriteria() {
        IncCategoryCriteria icc = new IncCategoryCriteria();
        icc.setStart(getStart().intValue());
        icc.setCount(getLimit().intValue());
        icc.setSort(toDomainSort());
        return icc;
    }

}
