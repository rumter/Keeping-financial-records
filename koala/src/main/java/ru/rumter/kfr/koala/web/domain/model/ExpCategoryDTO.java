package ru.rumter.kfr.koala.web.domain.model;

import ru.rumter.kfr.koala.domain.entity.exp.ExpCategory;

public class ExpCategoryDTO {

    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExpCategory fromDTO() {
        ExpCategory entity = new ExpCategory();
        entity.setId(getId());
        entity.setTitle(getTitle());
        return entity;
    }

    public static ExpCategoryDTO toDTO(ExpCategory entity) {
        ExpCategoryDTO dto = new ExpCategoryDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return dto;
    }

}