package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;

public class ExpensesDto {
    private String description;
    private Double value;
    private Category category;
    private String userName;

    public ExpensesDto(String description, Double value, Category category, String userName) {
        this.description = description;
        this.value = value;
        this.category = category;
        this.userName = userName;
    }

    public ExpensesDto(Expenses expense) {
        description = expense.getDescription();
        value = expense.getValue();
        category = expense.getCategory();
        userName = expense.getUser().getUserName();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
