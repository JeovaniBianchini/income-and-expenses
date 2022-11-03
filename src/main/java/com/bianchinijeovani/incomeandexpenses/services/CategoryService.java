package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.CategoryDto;
import com.bianchinijeovani.incomeandexpenses.dtos.CategoryForm;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(CategoryForm categoryForm){

        Category category = new Category();
        category.setName(categoryForm.getName());
        return categoryRepository.save(category);
    }
    public Category findByName(String name){
        return categoryRepository.findByName(name);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public List<CategoryDto> getTotalValueExpenses(LocalDate localDate){
        return categoryRepository.getTotalValueExpenses(localDate);
    }






}
