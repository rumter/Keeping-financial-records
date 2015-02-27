package ru.rumter.kfr.koala.web.domain.criteria;

import ru.rumter.kfr.koala.domain.criteria.IncomeCriteria;
import ru.rumter.kfr.koala.domain.criteria.Sort;

public class IncomeCriteriaDTO extends CriteriaDTO {

    public IncomeCriteria toDomainCriteria() {
        IncomeCriteria ic = new IncomeCriteria();
        ic.setStart(getStart().intValue());
        ic.setCount(getLimit().intValue());

        Sort sort = toDomainSort();
        if (sort != null) {
            if (sort.getProperty().equals("incCategoryId")) {
                sort.setProperty("incCategory.id");
            }
            if (sort.getProperty().equals("incCategoryTitle")) {
                sort.setProperty("incCategory.title");
            }
            ic.setSort(sort);
        }
        return ic;
    }

}
