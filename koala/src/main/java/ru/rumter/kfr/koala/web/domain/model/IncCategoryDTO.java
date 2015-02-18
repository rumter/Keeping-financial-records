package ru.rumter.kfr.koala.web.domain.model;

import ru.rumter.kfr.koala.domain.entity.inc.IncCategory;

public class IncCategoryDTO {

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

    public static IncCategoryDTO toDTO(IncCategory entity) {
        IncCategoryDTO dto = new IncCategoryDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return dto;
    }

}
