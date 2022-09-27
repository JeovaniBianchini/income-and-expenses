package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;

public class CategoryDto {

    private String name;

    public CategoryDto(){
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public CategoryDto(Category category) {
        name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
