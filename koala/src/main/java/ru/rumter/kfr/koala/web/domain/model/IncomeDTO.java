package ru.rumter.kfr.koala.web.domain.model;

import java.util.Date;

import ru.rumter.kfr.koala.domain.entity.inc.Income;
import ru.rumter.kfr.koala.domain.entity.inc.IncCategory;

public class IncomeDTO {

    private Long id;
    private Long incCategoryId;
    private String incCategoryTitle;
    private Date occured;
    private Long amount;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIncCategoryId() {
        return incCategoryId;
    }

    public void setIncCategoryId(Long incCategoryId) {
        this.incCategoryId = incCategoryId;
    }

    public String getIncCategoryTitle() {
        return incCategoryTitle;
    }

    public void setIncCategoryTitle(String incCategoryTitle) {
        this.incCategoryTitle = incCategoryTitle;
    }

    public Date getOccured() {
        return occured;
    }

    public void setOccured(Date occured) {
        this.occured = occured;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Income fromDTO() {
        Income entity = new Income();
        entity.setId(getId());

        IncCategory category = new IncCategory();
        category.setId(getIncCategoryId());
        entity.setIncCategory(category);

        entity.setOccured(getOccured());
        entity.setAmount(getAmount());
        entity.setDescription(getDescription());
        return entity;
    }

    public static IncomeDTO toDTO(Income entity) {
        IncomeDTO dto = new IncomeDTO();
        dto.setId(entity.getId());
        dto.setIncCategoryId(entity.getIncCategory().getId());
        dto.setIncCategoryTitle(entity.getIncCategory().getTitle());
        dto.setOccured(entity.getOccured());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}