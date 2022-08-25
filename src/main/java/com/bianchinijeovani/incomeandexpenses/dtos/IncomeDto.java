package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Income;

import java.time.LocalDate;

public class IncomeDto {

    private Long id;
    private String description;
    private Double value;

    public IncomeDto(){
    }


    public IncomeDto(Long id, String description, Double value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public IncomeDto(Income income) {
        id = income.getId();
        description = income.getDescription();
        value = income.getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
