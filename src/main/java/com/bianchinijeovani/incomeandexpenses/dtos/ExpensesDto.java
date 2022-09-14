package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Expenses;

import java.time.LocalDate;

public class ExpensesDto {


    private String description;
    private Double value;
    private String category;



    public ExpensesDto(String description, Double value, String category) {
        this.description = description;
        this.value = value;
        this.category = category;
    }

    public ExpensesDto(Expenses expense) {
        description = expense.getDescription();
        value = expense.getValue();
        category = expense.getCategory();

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
