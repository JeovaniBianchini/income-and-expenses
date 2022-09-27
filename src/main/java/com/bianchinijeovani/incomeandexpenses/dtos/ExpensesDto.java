package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ExpensesDto {


    private String description;
    private Double value;
    private Category category;



    public ExpensesDto(String description, Double value, Category category) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
