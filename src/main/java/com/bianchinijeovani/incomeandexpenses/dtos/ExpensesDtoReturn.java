package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;

import java.time.LocalDate;

public class ExpensesDtoReturn {

    private String description;
    private Double value;
    private LocalDate date;
    private Category category;

    public ExpensesDtoReturn(){
    }

    public ExpensesDtoReturn(String description, Double value, LocalDate date, Category category) {
        this.description = description;
        this.value = value;
        this.date = date;
        this.category = category;
    }

    public ExpensesDtoReturn(Expenses expenses) {
        description = expenses.getDescription();
        value = expenses.getValue();
        date = expenses.getDate();
        category = expenses.getCategory();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
