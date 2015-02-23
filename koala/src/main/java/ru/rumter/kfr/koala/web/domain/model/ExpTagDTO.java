package ru.rumter.kfr.koala.web.domain.model;

import ru.rumter.kfr.koala.domain.entity.exp.ExpTag;

public class ExpTagDTO {

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

    public ExpTag fromDTO() {
        ExpTag entity = new ExpTag();
        entity.setId(getId());
        entity.setTitle(getTitle());
        return entity;
    }

    public static ExpTagDTO toDTO(ExpTag entity) {
        ExpTagDTO dto = new ExpTagDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return dto;
    }

}