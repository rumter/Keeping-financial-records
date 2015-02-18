package ru.rumter.kfr.koala.web.domain.criteria;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rumter.kfr.koala.domain.criteria.Sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriteriaDTO {

    private static final Logger logger = LoggerFactory.getLogger(CriteriaDTO.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    protected Long start;
    protected Long page;
    protected Long limit;
    protected String sort;

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Sort toDomainSort() {
        if (getSort() != null) {
            try {
                List<Sort> sortList = objectMapper.readValue(getSort(), new TypeReference<ArrayList<Sort>>() {
                });
                if (sortList.size() > 0) {
                    return sortList.get(0);
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
