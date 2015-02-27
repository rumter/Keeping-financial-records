package ru.rumter.kfr.koala.web.domain.model;

import org.springframework.format.annotation.DateTimeFormat;
import ru.rumter.kfr.koala.domain.entity.exp.Expense;

import java.util.Date;

public class ExpenseDTO {

    private Long id;
    private Long amount;
    private String description;

    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private Date occured;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Expense fromDTO() {
        Expense entity = new Expense();
        entity.setId(getId());

        entity.setOccured(getOccured());
        entity.setAmount(getAmount());
        entity.setDescription(getDescription());
        return entity;
    }

    public static ExpenseDTO toDTO(Expense entity) {
        ExpenseDTO dto = new ExpenseDTO();
        dto.setId(entity.getId());
        dto.setOccured(entity.getOccured());
        dto.setAmount(entity.getAmount());
        dto.setDescription(entity.getDescription());
        return dto;
    }

}