package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;

public class CategoryForm {

    private String name;

    public CategoryForm(){
    }

    public CategoryForm(String name) {
        this.name = name;
    }

    public CategoryForm(Category category) {
        name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
