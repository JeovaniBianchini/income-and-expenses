package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.dtos.CategoryForm;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CategoryForm categoryForm){
        if (categoryService.existsByName(categoryForm.getName())){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Category already exist");
        }

        return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(categoryForm));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }

        categoryService.delete(categoryOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }
}
