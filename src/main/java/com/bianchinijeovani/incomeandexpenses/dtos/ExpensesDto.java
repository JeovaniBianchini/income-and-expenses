package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class ExpensesDto {


    private String description;
    private Double value;
    private Category category;
    private User user;


    public ExpensesDto(String description, Double value, Category category, User user) {
        this.description = description;
        this.value = value;
        this.category = category;


    }

    public ExpensesDto(Expenses expense) {
        description = expense.getDescription();
        value = expense.getValue();
        category = expense.getCategory();
        user = expense.getUser();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
