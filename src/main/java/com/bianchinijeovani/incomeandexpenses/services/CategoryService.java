package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.CategoryDto;
import com.bianchinijeovani.incomeandexpenses.dtos.CategoryForm;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public boolean existsByName(String name){
        return categoryRepository.existsByName(name);
    }

    @Transactional
    public void delete(Category category){
        categoryRepository.delete(category);
    }


    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
