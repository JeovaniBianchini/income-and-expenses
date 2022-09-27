package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.CategoryDto;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(CategoryDto categoryDto){

        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }
    public Category findByName(String name){
        return categoryRepository.findByName(name);
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public boolean existsByName(String name){
        return categoryRepository.existsByName(name);
    }
}
