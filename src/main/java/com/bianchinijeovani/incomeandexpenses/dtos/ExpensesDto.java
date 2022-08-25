package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Expenses;

import java.time.LocalDate;

public class ExpensesDto {

    private String description;
    private Double value;

    public ExpensesDto(String description, Double value) {
        this.description = description;
        this.value = value;
    }

    public ExpensesDto(Expenses expense) {
        description = expense.getDescription();
        value = expense.getValue();
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
